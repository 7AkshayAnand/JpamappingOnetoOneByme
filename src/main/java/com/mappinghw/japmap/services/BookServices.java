package com.mappinghw.japmap.services;

import com.mappinghw.japmap.entities.BookEntity;
import com.mappinghw.japmap.repositories.BookRepositories;
import org.springframework.stereotype.Service;

@Service
public class BookServices {

    private BookRepositories bookRepositories;

    public BookServices(BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    public BookEntity createNewBook(BookEntity bookEntity) {
       return bookRepositories.save(bookEntity);
    }

    public BookEntity getDepartmentById(Long bookId) {
      return bookRepositories.findById(bookId).orElse(null);
    }
}
