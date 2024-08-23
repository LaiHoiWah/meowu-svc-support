package com.meowu.svc.support.core.test.controller;

import com.meowu.starter.commons.security.domain.Response;
import com.meowu.starter.commons.security.exception.BusinessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestRestController{

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> test(){
        return new Response<String>("Test", 200, "Success");
    }

    @GetMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> error(){
        throw new RuntimeException("Error test");
    }

    @GetMapping(value = "/business", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> business(){
        throw new BusinessException(1000, "Business exception test");
    }
}
