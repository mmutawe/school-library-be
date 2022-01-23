package com.mmutawe.projects.school.library.be.controllers;

import com.mmutawe.projects.school.library.be.entities.Book;
import com.mmutawe.projects.school.library.be.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// TODO *** update controller with comprehensive possible cases ***
// TODO *** Use ResponseEntity ***

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

}
