package com.russel.atm.simulator.controller;

import com.russel.atm.simulator.common.BalanceInquiryRequest;
import com.russel.atm.simulator.common.BalanceInquiryResponse;
import com.russel.atm.simulator.common.BaseResponseService;
import com.russel.atm.simulator.facade.MessageProcessorFacade;
import com.russel.atm.simulator.service.IUserInfoService;
import com.russel.atm.simulator.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
@Controller
@RequestMapping("app")
public class UserInfoController extends BaseController {
    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @GetMapping("secure/account-details")
    public ModelAndView getAllUserAccounts() {
        String errorMessage;
        ModelAndView mav = new ModelAndView();
        BalanceInquiryRequest request = createBalanceInquiryRequest();
        try {
            BaseResponseService service = MessageProcessorFacade.getInstance().processRequest(request);
            mav.addObject("accountInfo", ((BalanceInquiryResponse)service).getBalance());
            errorMessage = "The operation was successful.";
        }
        catch (Exception ex) {
            errorMessage = "There was an error connecting to remote server.";
        }

        mav.addObject("name", userInfoService.getFullName());
        if(StringUtil.hasText(errorMessage)) {
            mav.addObject("errorMsg", errorMessage);
        }
        mav.setViewName("accounts");
        return mav;
    }

    @GetMapping("error")
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        String errorMessage = "You are not authorized for the requested data.";
        mav.addObject("name", userInfoService.getFullName());
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("403");
        return mav;
    }

    private BalanceInquiryRequest createBalanceInquiryRequest() {
        BalanceInquiryRequest request = new BalanceInquiryRequest();

        request.setRequestUUID(generateRequestUUID());
        request.setCardNo(getCurrentUsername());
        request.setTrk2EquivData(createTrk2EquivData("123", "123"));

        return request;
    }

}