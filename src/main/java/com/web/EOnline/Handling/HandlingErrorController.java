package com.web.EOnline.Handling;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HandlingErrorController implements ErrorController {

    public HandlingErrorController() {}

    @GetMapping(value = "/error")
    public String handleError(Model model,HttpServletRequest request) {
        
    	Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

//        if (status != null) {
//        
//            Integer statusCode = Integer.valueOf(status.toString());
//
//            if(statusCode == HttpStatus.NOT_FOUND.value()) {
//                return "error-404";
//            }
//            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                return "error-500";
//            }
//        }
    		model.addAttribute("errorStatus", status);
        return "error-pages/error";
    }

    @Override
    public String getErrorPath() {
        return "error-pages/error";
    }

}