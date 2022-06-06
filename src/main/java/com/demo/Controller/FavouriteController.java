package com.demo.Controller;

import com.demo.Entity.Favourite;
import com.demo.Response.ResponseCode;
import com.demo.Service.FavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/Favourite/")
@RequiredArgsConstructor
public class FavouriteController {
    private final FavouriteService service;

    // 响应添加收藏，返回收藏对象
    @PostMapping("add")
    @ResponseBody
    public com.demo.Response.ResponseBody addFavourite(@RequestBody Favourite fav){
        if(service.exists(fav)){
            return new com.demo.Response.ResponseBody(ResponseCode.ADD_FAVOURITE_FAIL, service.findFavourite(fav));
        }
        service.insert(fav);
        return new com.demo.Response.ResponseBody(ResponseCode.ADD_FAVOURITE_SUCCESS, service.findFavourite(fav));
    }

    @PostMapping("update")
    @ResponseBody
    public com.demo.Response.ResponseBody updateFavourite(@RequestBody Favourite favourite){
        return new com.demo.Response.ResponseBody(service.update(favourite) ? ResponseCode.UPDATE_FAVOURITE_SUCCESS : ResponseCode.UPDATE_FAVOURITE_FAIL, "");
    }

    // 在主界面，显示所有藏书及信息
    @GetMapping("searchByUid")
    @ResponseBody
    public com.demo.Response.ResponseBody searchByUid(@RequestParam("uid") Integer uid){
        return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, service.findFavouritesByUid(uid));
    }

    // 主界面上，查看某个标签下所有的书的信息
    @GetMapping("searchByUidAndTid")
    @ResponseBody
    public com.demo.Response.ResponseBody searchByUidAndTid(@RequestParam(value = "uid") Integer uid, @RequestParam(value = "tid") Integer tid){
        return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, service.searchBooksDetailByUidAndTid(uid, tid));
    }

    @GetMapping("delete")
    @ResponseBody
    public com.demo.Response.ResponseBody deleteByUidAndISBN(@RequestParam("uid") Integer uid, @RequestParam("ISBN") String ISBN){
        if(service.existsByUidAndISBN(uid, ISBN)){
            service.deleteByUidAndISBN(uid, ISBN);
            return new com.demo.Response.ResponseBody(ResponseCode.DELETE_FAVOURITE_SUCCESS, "");
        }
        return new com.demo.Response.ResponseBody(ResponseCode.DELETE_FAVOURITE_FAIL, "");
    }
}
