package com.russel.atm.simulator.exception;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class TransformerException extends RuntimeException {

    public TransformerException(String msg) {
        super(msg);
    }

    public TransformerException(String msg, Throwable t) {
        super(msg, t);
    }
}