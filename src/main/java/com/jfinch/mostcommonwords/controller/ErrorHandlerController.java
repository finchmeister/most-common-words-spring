package com.jfinch.mostcommonwords.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ErrorHandlerController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public RedirectView handleError() {
        return new RedirectView("/");
    }
}