package tech.crawler.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @ExceptionHandler
    public
    @ResponseBody
    String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        return "error";
    }
}
