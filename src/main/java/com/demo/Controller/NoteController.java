package com.demo.Controller;

import com.demo.Entity.Note;
import com.demo.Response.ResponseCode;
import com.demo.Service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/Note/")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService service;

    @PostMapping("add")
    @ResponseBody
    public com.demo.Response.ResponseBody add(@RequestBody Note note){
        service.insert(note);
        return new com.demo.Response.ResponseBody(ResponseCode.ADD_NOTE_SUCCESS, "");

    }

    @GetMapping("delete")
    @ResponseBody
    public com.demo.Response.ResponseBody delete(@RequestParam("NID") Integer nid){
        return new com.demo.Response.ResponseBody(service.deleteNoteByNid(nid) ? ResponseCode.DELETE_NOTE_SUCCESS : ResponseCode.DELETE_NOTE_FAIL, "");
    }

    @PostMapping("update")
    @ResponseBody
    public com.demo.Response.ResponseBody update(@RequestBody Note note){
        service.update(note);
        return new com.demo.Response.ResponseBody(service.update(note) ? ResponseCode.UPDATE_NOTE_SUCCESS : ResponseCode.UPDATE_NOTE_FAIL, "");
    }

    @GetMapping("getAll")
    @ResponseBody
    public com.demo.Response.ResponseBody getAll(@RequestParam("UID") Integer uid){
        return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, service.findNotesByUid(uid));
    }

    @GetMapping("get")
    @ResponseBody
    public com.demo.Response.ResponseBody get(@RequestParam("UID") Integer uid, @RequestParam("ISBN") String ISBN){
        return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, service.findNotesByUidAndISBN(uid, ISBN));
    }
}
