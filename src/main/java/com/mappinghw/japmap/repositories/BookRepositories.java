package com.mappinghw.japmap.repositories;

import com.mappinghw.japmap.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositories extends JpaRepository<BookEntity,Long> {
}
