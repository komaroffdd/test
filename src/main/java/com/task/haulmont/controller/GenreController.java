package com.task.haulmont.controller;

import com.task.haulmont.entity.Author;
import com.task.haulmont.entity.Genre;
import com.task.haulmont.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/list")
    public String getAllBook(Model model) {
        model.addAttribute("genres", genreService.findAll());
        return "/genre/list";
    }
    @GetMapping("/add")
    public String createGenrePage()
    {
        return "/genre/createGenre";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("genre")Genre genre) {
        genreService.save(genre);
        return "redirect:/genre/list";
    }
    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute("genre") Genre genre) {
        genreService.update(genre);
        return "redirect:/genre/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        genreService.delete(id);
        return "redirect:/genre/list";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("genre",genreService.getById(id));
        return "/genre/editGenre";
    }
}
