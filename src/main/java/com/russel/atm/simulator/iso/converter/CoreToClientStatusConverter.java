package com.russel.atm.simulator.iso.converter;

import com.russel.atm.simulator.common.CoreResponseCode;
import com.russel.atm.simulator.common.Status;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class CoreToClientStatusConverter {
    
    private static CoreToClientStatusConverter instance;
    private Log log = LogFactory.getLog(CoreToClientStatusConverter.class);

    public static CoreToClientStatusConverter getInstance() {
        if (instance == null) {
            instance = new CoreToClientStatusConverter();
        }
        return instance;
    }

    private Map<Status, CoreResponseCode> map = new HashMap<Status, CoreResponseCode>();

    private CoreToClientStatusConverter() {
        map.put(Status.SUCCESS, CoreResponseCode.APPROVED);
        map.put(Status.GENERAL_ERROR, CoreResponseCode.CARD_ISSUER_NOT_AVAILABLE);
        map.put(Status.GENERAL_DATA_ERROR, CoreResponseCode.REJECTED);
    }

    public Status convert(String code) {
        Status[] clientCodes = Status.values();
        for (Status clientCode : clientCodes) {
            if(map.get(clientCode).getCode().equals(code)) {
                return clientCode;
            }
        }
        log.warn("Core response code: " + code + " did not match any data in " + Status.class);
        return null;
    }
}