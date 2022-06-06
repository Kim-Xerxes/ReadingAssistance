package com.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String ISBN;
    private String bookName;
    private String author;
    private String publisher;
    private String pageCount;
    private String icon;

    public String getISBN(){return ISBN;}
    public void setISBN(String ISBN){this.ISBN = ISBN;}
    public String getBookName(){return bookName;}
    public void setBookName(String bookName){this.bookName = bookName;}
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}
    public String getPublisher(){return publisher;}
    public void setPublisher(String publisher){this.publisher = publisher;}
    public String getPageCount(){return pageCount;}
    public void setPageCount(String pageCount){this.pageCount = pageCount;}
    public String getIcon() {return icon;}
    public void setIcon(String icon) {this.icon = icon;}

}
