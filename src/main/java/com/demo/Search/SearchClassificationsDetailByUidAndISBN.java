package com.demo.Search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SearchClassificationsDetailByUidAndISBN {
    private Integer uid;
    private String ISBN;
    private Integer tid;
    private String content;
}
