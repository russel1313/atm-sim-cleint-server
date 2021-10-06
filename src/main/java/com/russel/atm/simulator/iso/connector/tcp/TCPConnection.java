package com.russel.atm.simulator.iso.connector.tcp;

import com.russel.atm.simulator.util.Alignment;
import com.russel.atm.simulator.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.0 $
 */
public class TCPConnection {

    private Socket clientSocket = null;
    private DataOutputStream outputStream = null;
    private DataInputStream inStream = null;

    public TCPConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        clientSocket.setSoTimeout(25000);
        outputStream = new DataOutputStream(clientSocket.getOutputStream());
        inStream = new DataInputStream(clientSocket.getInputStream());
        System.out.println("Created a new connection");
    }

    public void send(String sendStr) throws IOException {
        byte[] sendBytes = sendStr.getBytes("8859_1");
            outputStream.write(sendBytes);
            outputStream.flush();
    }

    public  synchronized String receive() throws IOException, InterruptedException {
        int length = getMessageLength();
        byte[] isoResponse = new byte[length];
        inStream.readFully(isoResponse);
        return StringUtil.padZero(String.valueOf(length), 4, Alignment.LEFT) + new String(isoResponse, "Cp1256");
    }

    public int getMessageLength() throws IOException {
        byte[] byteRecLen = new byte[4];
        inStream.readFully(byteRecLen);
        return Integer.parseInt(new String(byteRecLen));
    }

    public void close() throws IOException, InterruptedException {
        System.out.println("closing socket");
        outputStream.close();
        inStream.close();
        clientSocket.close();
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public OutputStream getOutStream() {
        return outputStream;
    }

    public void setOutStream(DataOutputStream outStream) {
        this.outputStream = outStream;
    }

    public DataInputStream getInStream() {
        return inStream;
    }

    public void setInStream(DataInputStream inStream) {
        this.inStream = inStream;
    }

    public boolean isClosed() {
        return clientSocket == null || clientSocket.isClosed() || outputStream ==null; 
    }
}