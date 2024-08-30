package com.meowu.svc.support.core.dictionary.controller;

import com.meowu.starter.commons.security.domain.Response;
import com.meowu.svc.support.core.dictionary.entity.Group;
import com.meowu.svc.support.core.dictionary.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/group")
public class GroupRestController{

    @Autowired
    private GroupService groupService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Group> save(@RequestBody Group group){
        return new Response<Group>(groupService.save(group));
    }
}
