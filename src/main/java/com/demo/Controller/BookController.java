package com.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.Entity.Book;
import com.demo.api.GetBookFromISBN;
import com.demo.Response.ResponseCode;
import com.demo.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @RequestMapping("searchBookByName")
    @ResponseBody
    public com.demo.Response.ResponseBody searchBookByName(@RequestParam("bookName") String bookName){
        Iterable<Book> books = service.findBooksByBookName(bookName);
        return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, books);
    }

    @RequestMapping("searchBookByISBN")
    @ResponseBody
    public com.demo.Response.ResponseBody searchBookByISBN(@RequestParam("ISBN") String ISBN){
        // 如果本地数据库中没有，则调用api获取
        if(!service.existsByISBN(ISBN)) {
            JSONObject rawBookData = GetBookFromISBN.getBookFromISBN(ISBN);
            JSONObject bookData = JSONObject.parseObject(rawBookData.get("data").toString());
            JSONObject book = new JSONObject();
            book.put("ISBN", bookData.get("code"));
            book.put("bookName", bookData.get("name"));
            book.put("author", bookData.get("author"));
            book.put("publisher", bookData.get("publishing"));
            book.put("pageCount", bookData.get("pages"));
            book.put("icon", bookData.get("photoUrl"));
            Book newBook = new Book(book.get("ISBN").toString(), book.get("bookName").toString(), book.get("author").toString(), book.get("publisher").toString(), book.get("pageCount").toString(), book.get("icon").toString());
            service.insert(newBook);
            return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, book);
        }
        Book book = service.findBookByISBN(ISBN);
        return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, book);
    }

    @GetMapping("findAllBooks")
    public com.demo.Response.ResponseBody findAllBooks(){
        return new com.demo.Response.ResponseBody(ResponseCode.SEARCH_SUCCESS, service.findAll());
    }

    @GetMapping("booktest")
    public com.demo.Response.ResponseBody test(){
        return new com.demo.Response.ResponseBody(0, service.findBookByISBN("9787020024759"));
    }

}
