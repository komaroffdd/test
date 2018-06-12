package com.task.haulmont.controller;

import com.task.haulmont.entity.Book;
import com.task.haulmont.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String getAllBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "/book/list";
    }

    @GetMapping("/add")
    public String createBookPage()
    {
        return "/book/createBook";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("book") Book book) throws Exception {
        bookService.save(book);
        return "redirect:/book/list";
    }

    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute("book") Book book) {
        bookService.update(book);
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return "redirect:/book/list";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "/book/editBook";
    }
}