package com.mappinghw.japmap.controllers;

import com.mappinghw.japmap.entities.AuthorEntity;
import com.mappinghw.japmap.entities.BookEntity;
import com.mappinghw.japmap.services.AuthorServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/authors")
public class AuthorController {

    private AuthorServices authorServices;

    public AuthorController(AuthorServices authorServices) {
        this.authorServices = authorServices;
    }

    @PostMapping
    public AuthorEntity createNewAuthor(@RequestBody AuthorEntity authorEntity){
        return authorServices.createNewAuthor(authorEntity);
    }

    @GetMapping("/{authorId}")
    public AuthorEntity getAuthorById(@PathVariable Long authorId) {
        return authorServices.getAuthorById(authorId);
    }

    @PutMapping(path="/{authorId}/worker/{bookId}")
    public AuthorEntity  assignBookToAuthor(@PathVariable Long authorId,@PathVariable Long bookId){

        return authorServices.assignAuthorToBooks(authorId,bookId);
    }

    @PutMapping(path="/{authorId}/writes/{bookId}")
    public AuthorEntity  assignBooksToAuthor(@PathVariable Long authorId,@PathVariable Long bookId){

        return authorServices.assignBooksToAuthor(authorId,bookId);
    }


}
