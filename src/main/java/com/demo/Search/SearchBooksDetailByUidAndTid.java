package com.demo.Search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SearchBooksDetailByUidAndTid {
    private Integer uid;
    private Integer tid;
    private String tag;
    private String ISBN;
    private String bookName;
    private String author;
    private String publisher;
    private String pageCount;
    private String icon;
}
