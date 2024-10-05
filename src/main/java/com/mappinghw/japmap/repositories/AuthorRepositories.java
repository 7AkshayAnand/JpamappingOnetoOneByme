package com.mappinghw.japmap.repositories;

import com.mappinghw.japmap.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepositories extends JpaRepository<AuthorEntity,Long> {
}
