package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public interface ResultStatus extends StatusIF {
    
    /**
     * Gets the additional status.
     * 
     * @return the additional status
     */
    StatusIF[] getAdditionalStatus();
}