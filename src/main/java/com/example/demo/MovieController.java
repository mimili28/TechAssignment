package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {
    private final MovieRepository movies;

    public MovieController(MovieRepository movies){
        this.movies=movies;
    }

    @GetMapping("/")
    public String movie(Model model) {
        List<Movie> movieList = movies.findAll();
        model.addAttribute("movies", movieList);
        return "index";
    }

    @GetMapping("/add")
    public String addMovie(Model model){
        model.addAttribute("movie",new Movie());
        return "addmovie";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie){
        movies.save(movie);
        return "redirect:/";
    }



}
