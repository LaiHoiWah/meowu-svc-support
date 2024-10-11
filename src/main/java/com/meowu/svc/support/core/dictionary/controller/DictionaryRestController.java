package com.meowu.svc.support.core.dictionary.controller;

import com.meowu.starter.commons.security.domain.Response;
import com.meowu.svc.support.core.dictionary.entity.Dictionary;
import com.meowu.svc.support.core.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/dictionary")
public class DictionaryRestController{

    @Autowired
    private DictionaryService dictionaryService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Dictionary> save(@RequestBody Dictionary dictionary){
        return new Response<Dictionary>(dictionaryService.save(dictionary));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Dictionary> getById(@PathVariable("id") Long id){
        return new Response<Dictionary>(dictionaryService.getById(id));
    }

    @GetMapping(value = "/group/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Dictionary>> findByGroupId(@PathVariable("groupId") Long groupId){
        return new Response<List<Dictionary>>(dictionaryService.findByGroupId(groupId));
    }
}
