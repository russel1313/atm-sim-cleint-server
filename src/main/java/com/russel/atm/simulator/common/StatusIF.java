package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public interface StatusIF {
    
    /**
     * Gets the severity.
     * 
     * @return the severity
     */
    Severity getSeverity();
    
    /**
     * Gets the code.
     * 
     * @return the code
     */
    String getCode();
    
    /**
     * Gets the description.
     * 
     * @return the description
     */
    String getDescription();
    
    /**
     * Gets the server code.
     * 
     * @return the server code
     */
    String getServerCode();
    
    /**
     * Gets the name.
     * 
     * @return the name
     */
    String getName();
}