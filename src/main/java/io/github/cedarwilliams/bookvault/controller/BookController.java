package io.github.cedarwilliams.bookvault.controller;

import io.github.cedarwilliams.bookvault.model.Author;
import io.github.cedarwilliams.bookvault.model.Edition;
import io.github.cedarwilliams.bookvault.model.Work;
import io.github.cedarwilliams.bookvault.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

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

    /** Get the work from the service or throw HttpStatus NOT FOUND  */
    public Work getWorkFromBookService(Long workId) {
        return bookService.findWorkById(workId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Work not found")
        );
    }

    /** Get the edition from the service or throw HttpStatus NOT FOUND  */
    public Edition getEditionFromBookService(Long editionId) {
        return bookService.findEditionById(editionId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Work not found")
        );
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Work> works = bookService.findAllByOrderByFirstPublishedDateDesc();
        model.addAttribute("works", works);

        model.addAttribute("pageTitle", "Home");
        return "home";
    }

    @GetMapping("/works/{workId}")
    public String workById(@PathVariable Long workId, Model model) {

        Work work = getWorkFromBookService(workId);

        model.addAttribute("work", work);
        model.addAttribute("pageTitle", work.getTitle());

        return "work";

    }

    @GetMapping("/works/{workId}/editions/add")
    public String addEditionToWork(@PathVariable Long workId, Model model) {

        Work work = getWorkFromBookService(workId);
        List<Author> authors = bookService.findAllAuthors();

        model.addAttribute("work", work);
        model.addAttribute("edition", new Edition());

        model.addAttribute("pageTitle", "Add edition");
        return "add-edition-to-work";
    }

    @PostMapping("/works/{workId}/editions/add")
    public String submitNewEditionForWork(@PathVariable Long workId, @ModelAttribute Edition edition, Model model) {

        Work work = getWorkFromBookService(workId);

        work.addEdition(edition);
        bookService.saveWork(work);

        return "redirect:/works/" + workId;

    }

    @GetMapping("/works/{workId}/editions/{editionId}/update")
    public String updateEdition(@PathVariable Long workId, @PathVariable Long editionId, Model model) {
        Work work = getWorkFromBookService(workId);
        Edition edition =  getEditionFromBookService(editionId);

        model.addAttribute("work", work);
        model.addAttribute("edition", edition);

        model.addAttribute("pageTitle", "Edit edition");
        return "edit-edition";
    }

    @PostMapping("/works/{workId}/editions/{editionId}/update")
    public String saveUpdatedEdition(@PathVariable Long workId, @PathVariable Long editionId, @ModelAttribute Edition edition, Model model) {

        Edition existingEdition = getEditionFromBookService(editionId);
        existingEdition.setTitle(edition.getTitle());
        existingEdition.setSubtitle(edition.getSubtitle());
        existingEdition.setPublishedDate(edition.getPublishedDate());

        bookService.saveEdition(existingEdition);

        return "redirect:/works/" + workId;
    }

}
