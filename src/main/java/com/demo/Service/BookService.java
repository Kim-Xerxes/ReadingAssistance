package com.demo.Service;

import com.demo.Entity.Book;
import com.demo.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public Iterable<Book> findBooksByBookName(String bookName){
        return repository.findBooksByBookName(bookName);
    }

    public Book findBookByISBN(String ISBN){
        return repository.findBookByISBN(ISBN);
    }

    public Iterable<Book> findAll(){return repository.findAll();}
    public boolean insert(Book book){
        repository.save(book);
        return true;
    }

    public boolean existsByISBN(String ISBN){
        return repository.existsById(ISBN);
    }
}
