package com.russel.atm.simulator.iso;

import java.util.List;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public abstract class BaseTransformer<E>  {
    private String MTICode;
    private List<String> processCodes;

    public List<String> getProcessCodes() {
        return processCodes;
    }

    public void setProcessCodes(List<String> processCodes) {
        this.processCodes = processCodes;
    }

    public String getMTICode() {
        return MTICode;
    }

    public void setMTICode(String MTICode) {
        this.MTICode = MTICode;
    }

    protected abstract Object doTransform(Object src, String encoding);
}