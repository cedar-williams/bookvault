package io.github.cedarwilliams.bookvault.controller;

import io.github.cedarwilliams.bookvault.model.Work;
import io.github.cedarwilliams.bookvault.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * The MVC controller for handling Books.
 * Using "book" instead of "work" because that's the colloquial user facing term for a work.
 */
@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Home");

        System.out.println("/home request");

        List<Work> works = bookService.findAllWorks();
        model.addAttribute("works", works);
        return "home";
    }

}
