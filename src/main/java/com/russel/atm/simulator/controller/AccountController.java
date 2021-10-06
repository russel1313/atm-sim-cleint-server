package com.russel.atm.simulator.controller;

import com.russel.atm.simulator.common.*;
import com.russel.atm.simulator.facade.MessageProcessorFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
@Controller
@RequestMapping("app/account")
public class AccountController extends BaseController {
    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public ModelAndView balance() {
        BalanceInquiryRequest request = createBalanceInquiryRequest("1234", "1234");

        try {
            BaseResponseService service = MessageProcessorFacade.getInstance().processRequest(request);
        }
        catch (Exception ex) {

        }
        return new ModelAndView(new RedirectView("/app/secure/account-details"));
    }

    @RequestMapping(value = "/cashOut/{amt}/{wpin2}/{wcvv2}", method = RequestMethod.GET)
    public ModelAndView cashOut(@PathVariable double amt, @PathVariable String wpin2, @PathVariable String wcvv2) {
        String errorMessage;
        if (0 <= amt) {
            CashOutAddRequest request = createCashOutRequest(amt, wpin2, wcvv2);
            try {
                BaseResponseService service = MessageProcessorFacade.getInstance().processRequest(request);
                errorMessage = "The operation was successful.";
            }
            catch (Exception ex) {
                errorMessage = "There was an error connecting to remote server.";
            }
        }
        else {
            errorMessage = "You can not withdraw zero or negative amount.";
        }
        ModelAndView mav = new ModelAndView(new RedirectView("/app/secure/account-details"));
        mav.addObject("errorMsg", errorMessage);
        return mav;
    }

    @RequestMapping(value = "/cashIn/{amt}/{dpin2}/{dcvv2}", method = RequestMethod.GET)
    public ModelAndView cashIn(@PathVariable double amt, @PathVariable String dpin2, @PathVariable String dcvv2) {
        String errorMessage;
        if (0 <= amt) {
            CashInAddRequest request = createCashInRequest(amt, dpin2, dcvv2);
            try {
                BaseResponseService service = MessageProcessorFacade.getInstance().processRequest(request);
                errorMessage = "The operation was successful.";
            }
            catch (Exception ex) {
                errorMessage = "There was an error connecting to remote server.";
            }
        }
        else {
            errorMessage = "You can not charge your account with zero or negative amount.";
        }
        ModelAndView mav = new ModelAndView(new RedirectView("/app/secure/account-details"));
        mav.addObject("errorMsg", errorMessage);
        return mav;
    }

    private BalanceInquiryRequest createBalanceInquiryRequest(String pin , String cvv2) {
        BalanceInquiryRequest request = new BalanceInquiryRequest();

        request.setRequestUUID(generateRequestUUID());
        request.setCardNo(getCurrentUsername());
        request.setTrk2EquivData(createTrk2EquivData(pin, cvv2));

        return request;
    }

    private CashInAddRequest createCashInRequest(double amt, String pin , String cvv2) {
        CashInAddRequest request = new CashInAddRequest();

        request.setRequestUUID(generateRequestUUID());
        request.setFundTransfer(createFundTransfer(getCurrentUsername(), amt));
        request.setTrk2EquivData(createTrk2EquivData(pin, cvv2));

        return request;
    }

    private CashOutAddRequest createCashOutRequest(double amt, String pin , String cvv2) {
        CashOutAddRequest request = new CashOutAddRequest();

        request.setRequestUUID(generateRequestUUID());
        request.setFundTransfer(createFundTransfer(getCurrentUsername(), amt));
        request.setTrk2EquivData(createTrk2EquivData(pin, cvv2));

        return request;
    }
}