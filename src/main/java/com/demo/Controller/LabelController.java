package com.demo.Controller;

import com.demo.Entity.Label;
import com.demo.Response.ResponseCode;
import com.demo.Service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/Label/")
@RequiredArgsConstructor
public class LabelController {
    private final LabelService service;

    @PostMapping("add")
    @ResponseBody
    public com.demo.Response.ResponseBody add(@RequestBody Label label){
        service.add(label);
        return new com.demo.Response.ResponseBody(ResponseCode.ADD_LABEL_SUCCESS, "");
    }

    @GetMapping("getAll")
    @ResponseBody
    public com.demo.Response.ResponseBody getAll(@RequestParam(value = "uid") Integer uid){
        return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, service.findLabelsByUid(uid));
    }

}
