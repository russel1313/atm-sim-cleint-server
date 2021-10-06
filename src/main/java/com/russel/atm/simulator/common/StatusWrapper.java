package com.russel.atm.simulator.common;

import com.russel.atm.simulator.util.StringUtil;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class StatusWrapper implements ResultStatus, Serializable{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8580771607478213849L;

    /** The status. */
    private Status status;
    
    /** The description. */
    private String description;
    
    /** The server code. */
    private String serverCode;
    
    /** The additional status. */
    private StatusIF[] additionalStatus;

    /**
     * Instantiates a new status wrapper.
     * 
     * @param status the status
     */
    public StatusWrapper(Status status) {
        Assert.notNull(status);
        this.status=status;
    }

    /**
     * Instantiates a new status wrapper.
     * 
     * @param status the status
     * @param serverCode the server code
     */
    public StatusWrapper(Status status, String serverCode) {
        Assert.notNull(status);
        this.status = status;
        this.serverCode = serverCode;
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.ResultStatus#getAdditionalStatus()
     */
    public StatusIF[] getAdditionalStatus() {
        return additionalStatus;
    }

    /**
     * Sets the additional status.
     * 
     * @param additionalStatus the new additional status
     */
    public void setAdditionalStatus(StatusIF[] additionalStatus) {
        this.additionalStatus = additionalStatus;
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.StatusIF#getSeverity()
     */
    public Severity getSeverity() {
        return status.getSeverity();
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.StatusIF#getCode()
     */
    public String getCode() {
        return status.getCode();
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.StatusIF#getDescription()
     */
    public String getDescription() {
        return !StringUtil.isEmpty(description)? description: status.getDescription();
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.StatusIF#getServerCode()
     */
    public String getServerCode() {
        return serverCode;
    }

    /**
     * Sets the server code.
     * 
     * @param serverCode the new server code
     */
    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }

    /**
     * Sets the description.
     * 
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.StatusIF#getName()
     */
    public String getName() {
        return status.getName();
    }
}
