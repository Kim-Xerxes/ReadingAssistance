package com.demo.Search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteDetail {
    private Integer uid;
    private String ISBN;
    private String time;
    private Integer tid;
    private String tag;
    private String progress;
    private String bookName;
    private String author;
    private String publisher;
    private String pageCount;
    private String icon;
}
