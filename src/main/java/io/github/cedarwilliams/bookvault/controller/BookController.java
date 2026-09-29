package io.github.cedarwilliams.bookvault.controller;

import io.github.cedarwilliams.bookvault.model.Work;
import io.github.cedarwilliams.bookvault.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
        List<Work> works = bookService.findAllWorks();
        model.addAttribute("works", works);

        model.addAttribute("pageTitle", "Home");
        return "home";
    }

    @GetMapping("/work/{id}")
    public String workById(@PathVariable Long id, Model model) {
        Work work = bookService.findWorkById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Work not found")
        );
        model.addAttribute("work", work);

        model.addAttribute("pageTitle", work.getTitle());
        return "work";
    }

}
