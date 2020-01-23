package com.greenfoxacademy.libaryexample;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("Something With Demons", "Dan Brown", 2008));
        books.add(new Book("Bible", "God", 2020));
    }

    @GetMapping("/book-list")
    public String listBooks(Model model, @RequestParam(name = "author", required = false) String author) {
        List<Book> queriedBooks;

        if(author!= null) {
            queriedBooks = filterBooksByAuthor(author);
        }else {
            queriedBooks = books;
        }
        model.addAttribute("books", queriedBooks);
        return "booklist";
    }

    private List<Book> filterBooksByAuthor(String author) {
        return books.stream().filter(x -> x.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @RequestMapping(path="/book-list/add", method = RequestMethod.GET)
    public String addNewBookForm(Model model, @ModelAttribute(name="book") Book book){
        model.addAttribute("book", book);
        return "addNewBookForm";
    }

    @RequestMapping(path="/book-list/add", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute(name="book") Book book){
        books.add(book);
        return "redirect:/book-list";
    }


    @GetMapping("book-list/{id}/details")
    public String getDetails(Model model, @PathVariable(name="id") Long id) {
        Book bookById = null;

        for (Book book : books) {
            if(book.getId() == id){
                bookById = book;
            }
        }

        if(bookById != null){
            model.addAttribute("book", bookById);
        }else {
            model.addAttribute("error", "Book not found!");
        }

        return "details";
    }
}
