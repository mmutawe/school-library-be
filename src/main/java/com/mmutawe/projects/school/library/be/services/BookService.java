package com.mmutawe.projects.school.library.be.services;

import com.mmutawe.projects.school.library.be.entities.Book;
import org.springframework.stereotype.Service;

public interface BookService {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(long id);

    String deleteBook(long id);
}
