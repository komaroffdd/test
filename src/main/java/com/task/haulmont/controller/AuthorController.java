package com.task.haulmont.controller;

import com.task.haulmont.entity.Author;
import com.task.haulmont.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/list")
    public String getAllAuthor(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "/author/list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("author", authorService.getById(id));
        return "/author/showAuthor/";
    }

    @GetMapping("/add")
    public String createAuthorPage() {
        return "/author/createAuthor";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("author") @Valid Author author,BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "author/error";
        }
        authorService.save(author);
        return "redirect:/author/list";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("author", authorService.getById(id));
        return "/author/editAuthor";
    }

    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute("author") Author author) throws Exception {
        authorService.update(author);
        return "redirect:/author/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        authorService.delete(id);
        return "redirect:/author/list";
    }
    @GetMapping("/error")
    public String error(){
        return "/author/error";
    }
}
