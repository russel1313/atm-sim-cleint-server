package com.russel.atm.simulator.iso.connector.tcp;

import org.jpos.iso.ISOMsg;

import java.util.Date;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.0 $
 */
public class RequestResponse {
    private Date requestDate;
    private Date responseDate;
    private ISOMsg request;
    private ISOMsg response;

    public RequestResponse(ISOMsg request, Date requestDate) {
        this.request = request;
        this.requestDate = requestDate;
    }

    public RequestResponse(ISOMsg request, Date requestDate, ISOMsg response, Date responseDate) {
        this.request = request;
        this.requestDate = requestDate;
        this.response = response;
        this.responseDate = responseDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public ISOMsg getRequest() {
        return request;
    }

    public void setRequest(ISOMsg request) {
        this.request = request;
    }

    public ISOMsg getResponse() {
        return response;
    }

    public void setResponse(ISOMsg response) {
        this.response = response;
    }

    public long calculateResponseTime(){
        if(responseDate!=null && requestDate!=null){
           return responseDate.getTime()-requestDate.getTime();
        }
        return -1;
    }
}