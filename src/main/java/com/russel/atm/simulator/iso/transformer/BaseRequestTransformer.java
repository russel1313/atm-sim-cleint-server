package com.russel.atm.simulator.iso.transformer;

import com.russel.atm.simulator.common.BaseRequestService;
import com.russel.atm.simulator.common.ServiceAttribute;
import com.russel.atm.simulator.common.ServiceAttributeAware;
import com.russel.atm.simulator.exception.TransformerException;
import com.russel.atm.simulator.iso.ISOField;
import com.russel.atm.simulator.iso.packager.AsciiXAPackager;
import com.russel.atm.simulator.util.Alignment;
import com.russel.atm.simulator.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public abstract class BaseRequestTransformer<T extends BaseRequestService> implements ServiceAttributeAware {

    private static final Log logger = LogFactory.getLog(BaseRequestTransformer.class);
    protected static AsciiXAPackager asciiPackager;

    public static final String DEFAULT_POINT_OF_SERVICE = "1234567890";
    public static final String DEFAULT_CARD_ACCEPT_TERMINAL_ID = "12345678";
    public static final String DEFAULT_CARD_ACCEPT_ID_CODE = "12345678";
    public static final String DEFAULT_CARD_ACCEPT_NAME_LOCATION = "1234567890";
    public static final String DEFAULT_ACQUIRER_INSTITUTION_ID = "123456";
    public static final String DEFAULT_CURRENCY_CODE = "123";
    private static final String CHARSET_NAME = "8859_1";
    private static final String DEFAULT_MAC_KEY_VALUE = "22222";

    protected BaseRequestTransformer() {
        instantiateAsciiPackager();
    }

    protected Object doTransform(Object o, String s) throws Exception {
        BaseRequestService received = (BaseRequestService) o;
        ISOMsg message = transform(received);
        try {
            setMAC(message);
            byte[] prepaidMessage = message.pack();
            String messageLength = StringUtil.padZero(String.valueOf(prepaidMessage.length), 4, Alignment.LEFT);
            String finalMessage = messageLength + new String(prepaidMessage, CHARSET_NAME);
            return finalMessage.getBytes(CHARSET_NAME);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage() + o.toString());
        }
    }

    protected String tailoreCVV2(String originalCVV2) {
        return StringUtil.hasText(originalCVV2) ?
                StringUtil.fixSize(originalCVV2,4) :
                null;
    }

    protected abstract ISOMsg transform(BaseRequestService o) throws TransformerException;

    public abstract ServiceAttribute getServiceAttribute();

    public static ISOMsg setMAC(ISOMsg msg) {
        try {
            msg.set(ISOField.MAC_CODE.getPosition(), "AAAAAAAAAAAAAAAA");
            byte[] packedData = msg.pack();
            byte[] tailoredData = new byte[packedData.length - 16];
            System.arraycopy(packedData, 0, tailoredData, 0, tailoredData.length);
            msg.set(ISOField.MAC_CODE.getPosition(), createMacKey());
        }
        catch (ISOException e) {
            if (logger.isDebugEnabled()) {
                logger.debug("Error in setting MAC key : " + e.getMessage());
            }
        }
        return msg;
    }

    private static byte[] createMacKey() {
        //@todo: make a better implementation
        return DEFAULT_MAC_KEY_VALUE.getBytes();
    }

    protected static String encryptPin(String pin) {
        //@todo: make a better implementation
        return StringUtil.hasText(pin) ?
                pin : "123";
    }

    private static void instantiateAsciiPackager() {
        if (asciiPackager == null) {
            asciiPackager = new AsciiXAPackager();
        }
    }
}