package com.russel.atm.simulator.iso.connector.tcp;

import org.jpos.iso.ISOMsg;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.0 $
 */
public class ISOTcpConnector implements ISOConnector {

    private String ip;
    private int port;

    private ResourceBundle props;

    public ISOTcpConnector() {
        props = ResourceBundle.getBundle(getClass().getName());
        ip = props.getString("ip");
        port = Integer.valueOf(props.getString("portNo"));
    }

    public String execute(String msg, ISOMsg isoMsg) throws Exception {
        String responseMessage = "";
        TCPConnection connection = null;
        try {
            connection = new TCPConnection(ip, port);            
            connection.send(msg);
            responseMessage = connection.receive();
        }
        catch (Exception ioe) {
            throw new Exception(ioe);
        }
        finally {
            connection.close();
        }
        return responseMessage;
    }

    class TcpReceiver implements Runnable{
        TCPConnection conn;

        public void setConn(TCPConnection conn) {
            this.conn = conn;
        }

        TcpReceiver(TCPConnection conn) {
            this.conn = conn;
        }

        public void run() {
            try {
                conn.receive();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}