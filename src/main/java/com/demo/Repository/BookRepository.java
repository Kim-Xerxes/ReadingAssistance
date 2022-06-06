package com.demo.Repository;

import com.demo.Entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,String> {
    @Query(value = "select b from Book b where b.bookName like concat('%',?1,'%') ")
    Iterable<Book> findBooksByBookName(String bookName);
    Book findBookByISBN(String ISBN);
}
