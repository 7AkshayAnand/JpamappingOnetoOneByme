package com.mappinghw.japmap.services;

import com.mappinghw.japmap.entities.AuthorEntity;
import com.mappinghw.japmap.entities.BookEntity;
import com.mappinghw.japmap.repositories.AuthorRepositories;
import com.mappinghw.japmap.repositories.BookRepositories;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServices {
    private AuthorRepositories authorRepositories;
    private BookRepositories bookRepositories;

    public AuthorServices(BookRepositories bookRepositories,AuthorRepositories authorRepositories) {
        this.bookRepositories = bookRepositories;
        this.authorRepositories=authorRepositories;
    }



    public AuthorEntity createNewAuthor(AuthorEntity authorEntity) {
      return authorRepositories.save(authorEntity);
    }

    public AuthorEntity getAuthorById(Long authorId) {
      return authorRepositories.findById(authorId).orElse(null);
    }

    public AuthorEntity assignAuthorToBooks(Long authorId, Long bookId) {
    Optional<AuthorEntity> authorEntity=authorRepositories.findById(authorId);
    Optional<BookEntity>   bookEntity=bookRepositories.findById(bookId);

    return authorEntity.flatMap(author->
            bookEntity.map(book->{
               author.setPublishedBook(book);
               return authorRepositories.save(author);
            })).orElse(null);



    }

    public AuthorEntity assignBooksToAuthor(Long authorId,Long bookId){
        Optional<AuthorEntity> authorEntity=authorRepositories.findById(authorId);
        Optional<BookEntity>   bookEntity=bookRepositories.findById(bookId);
        return authorEntity.flatMap(author->
                bookEntity.map(book->{
                  book.setAuthorsBook(author);
//                  as it is bidirectioal mapping so we need to set both bookentity field and author entity field
                  author.getAllBook().add(book);
                  authorRepositories.save(author);
                  return author;

                })).orElse(null);



    }
}

// employeeEntity.map(employee->{
////                    Direct Reference: In a one-to-one relationship, you typically keep a reference to the entire entity (EmployeeEntity) rather than just the ID. This allows you to leverage the relationships defined by JPA/Hibernate.
//        department.setManager(employee);
//                    return departmentRepository.save(department);
