package com.russel.atm.simulator.facade;

import com.russel.atm.simulator.common.BaseRequestService;
import com.russel.atm.simulator.common.BaseResponseService;
import com.russel.atm.simulator.exception.TransformerException;
import com.russel.atm.simulator.iso.connector.tcp.ISOTcpConnector;
import com.russel.atm.simulator.iso.packager.AsciiXAPackager;
import com.russel.atm.simulator.iso.transformer.DynamicClientToCoreTransformer;
import com.russel.atm.simulator.iso.transformer.DynamicCoreToClientTransformer;
import com.russel.atm.simulator.util.Alignment;
import com.russel.atm.simulator.util.StringUtil;
import org.jpos.iso.ISOMsg;

import java.util.Date;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.0 $
 */
public class MessageProcessorFacade {

    private static MessageProcessorFacade instance;
    private MessageProcessorFacade() {

    }

    public static MessageProcessorFacade getInstance() {
        if (instance == null) {
            instance = new MessageProcessorFacade();
        }
        return instance;
    }

    public BaseResponseService processRequest(BaseRequestService requestService) throws Exception {
        if(requestService != null) {
            ISOMsg transformed = (ISOMsg) DynamicClientToCoreTransformer.getInstance().doTransform(requestService);
            if (transformed != null) {
//                ISOTcpConnectorSingleton isoConnector = ISOTcpConnectorSingleton.getInstance();
                ISOTcpConnector isoConnector = new ISOTcpConnector();
                byte[] finalMsg = transformed.pack();
                String messageLength = StringUtil.padZero(String.valueOf(finalMsg.length), 4, Alignment.LEFT);
                String originalMessage = messageLength +
                        new String(finalMsg, "8859_1");
                String response = isoConnector.execute(originalMessage, transformed);
                if(response != null) {
                    BaseResponseService responseService = (BaseResponseService) DynamicCoreToClientTransformer.getInstance().doTransform(unpackReceivedMessage(response));
                    return responseService;
                }
                else {
                    return null;
                }
            }
            else {
                throw new TransformerException("Error in trnaforming next request " + requestService.getRequestUUID());
            }
        }
        else {
            throw new TransformerException("Error in trnaforming null request");
        }
    }

    private synchronized ISOMsg unpackReceivedMessage(String receivedISOMessage) {
        try {
            byte[] pureMessage = new byte[receivedISOMessage.length()-4];
            System.arraycopy(receivedISOMessage.getBytes("Cp1256"), 4, pureMessage, 0, pureMessage.length);

            ISOMsg msg = new ISOMsg();
            msg.setPackager(new AsciiXAPackager());
            msg.unpack(pureMessage);
            System.out.println(msg.getString(11) + " received in time: " + new Date());
            return msg;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}