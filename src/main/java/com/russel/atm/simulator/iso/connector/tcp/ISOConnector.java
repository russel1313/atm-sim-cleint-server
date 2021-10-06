package com.russel.atm.simulator.iso.connector.tcp;

import org.jpos.iso.ISOMsg;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.0 $
 */
public interface ISOConnector {

    public String execute(String msg, ISOMsg isoMsg) throws Exception;
}