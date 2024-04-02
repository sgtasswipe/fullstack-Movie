package com.example.fullstack.controllers;

import com.example.fullstack.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MovieController {
    @Autowired
    private MovieService movieService;
@GetMapping("/new")
public String insert() {
    return "home/new";
}
@PostMapping("/new")
public String insert(@RequestParam String title, @RequestParam int releaseYear, @RequestParam String description, @RequestParam String tags) {
    movieService.insert(title, releaseYear, description, tags);
    return "redirect:/";
}
@GetMapping("/prepare_update")
public String prepareUpdate(@RequestParam int id, Model model) {
    model.addAttribute(movieService.prepareUpdate(id));
    return "home/update";

}
@PostMapping("/update")
public String update (@RequestParam int id, @RequestParam String title, @RequestParam int releaseYear, @RequestParam String description, @RequestParam String tags) {
    movieService.update(id, title, releaseYear, description, tags);
    return "redirect:/";

}

    @GetMapping ("/confirm_delete")
    public String confirmDelete (@RequestParam int id, Model model) {
        model.addAttribute(movieService.getMovie(id)) ;
        return "home/confirm_delete";
    }
    @PostMapping ("/delete")
    public String delete (@RequestParam int id) {
        movieService.delete(id);
        return "redirect:/";
    }

}
