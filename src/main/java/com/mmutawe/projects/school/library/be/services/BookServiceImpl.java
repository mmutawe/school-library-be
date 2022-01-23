package com.mmutawe.projects.school.library.be.services;

import com.mmutawe.projects.school.library.be.entities.Book;
import com.mmutawe.projects.school.library.be.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO *** update services with comprehensive possible cases ***
// TODO *** implement customized exception handler ***

@Service
public class BookServiceImpl implements BookService{

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        logger.info("Saving book with name + " + book.getBookName());
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        logger.info("Updating book with name + " + book.getBookName());
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(long id) {
        logger.info("retrieving book from DB");
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteBook(long id) {
        logger.info("book with id ("+ id +") is deleted from DB");
        bookRepository.deleteById(id);
        return "Book deleted ...";
    }
}
