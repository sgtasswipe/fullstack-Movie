package com.example.fullstack.controllers;

import com.example.fullstack.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller


public class HomeController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
public  String index(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        return  "home/index";
    }
}
