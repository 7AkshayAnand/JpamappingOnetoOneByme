package com.mappinghw.japmap.controllers;

import com.mappinghw.japmap.entities.BookEntity;
import com.mappinghw.japmap.repositories.AuthorRepositories;
import com.mappinghw.japmap.repositories.BookRepositories;
import com.mappinghw.japmap.services.BookServices;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @PostMapping
    public BookEntity createNewBook(@RequestBody BookEntity bookEntity){
       return bookServices.createNewBook(bookEntity);
    }

    @GetMapping("/{bookId}")
    public BookEntity getBookById(@PathVariable Long bookId) {
        return bookServices.getDepartmentById(bookId);
    }


}
