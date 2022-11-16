package com.capgemini.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = MethodNotAllowedException.class)
    public String nullPointerHandler(Model theModel) {
        theModel.addAttribute("err", "NullPointerException");
        return "access-denied";
    }

    @ExceptionHandler(value = Exception.class)
    public String AnyOtherHandler() {
        return "access-denied";
    }

}