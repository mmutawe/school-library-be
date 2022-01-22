package com.mmutawe.projects.school.library.be.repositories;

import com.mmutawe.projects.school.library.be.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
