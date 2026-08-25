package io.github.cedarwilliams.bookvault.service;

import io.github.cedarwilliams.bookvault.model.*;
import io.github.cedarwilliams.bookvault.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Provides operations for managing books and connected entities.
 */
@Service
public class BookService {


    private final WorkRepository workRepository;
    private final EditionRepository editionRepository;
    private final IsbnRepository isbnRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;


    @Autowired
    BookService(WorkRepository workRepository,
                EditionRepository editionRepository,
                IsbnRepository isbnRepository,
                PublisherRepository publisherRepository,
                AuthorRepository authorRepository) {
        this.workRepository = workRepository;
        this.editionRepository = editionRepository;
        this.isbnRepository = isbnRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }


    // Work methods

    public Work createWork(Work work) {
        return workRepository.save(work);
    }

    public List<Work> findAllWorks() {
        return workRepository.findAll();
    }

    public Optional<Work> findWorkById(Long id) {
        return workRepository.findById(id);
    }

    public Work saveWork(Work work) {
        return workRepository.save(work);
    }

    public void deleteWork(Work work) {
        workRepository.delete(work);
    }


    // Edition methods

    public Edition createEdition(Edition edition) {
        return editionRepository.save(edition);
    }

    public List<Edition> findAllEditions() {
        return editionRepository.findAll();
    }

    public Optional<Edition> findEditionById(Long id) {
        return editionRepository.findById(id);
    }

    public Edition saveEdition(Edition edition) {
        return editionRepository.save(edition);
    }

    public void deleteEdition(Edition edition) {
        editionRepository.delete(edition);
    }


    // ISBN methods

    public Isbn createIsbn(Isbn isbn) {
        return isbnRepository.save(isbn);
    }

    public List<Isbn> findAllIsbns() {
        return isbnRepository.findAll();
    }

    public Optional<Isbn> findIsbnById(Long id) {
        return isbnRepository.findById(id);
    }

    public Isbn saveIsbn(Isbn isbn) {
        return isbnRepository.save(isbn);
    }

    public void deleteIsbn(Isbn isbn) {
        isbnRepository.delete(isbn);
    }

    
    // Publisher methods

    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> findPublisherById(Long id) {
        return publisherRepository.findById(id);
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(Publisher publisher) {
        publisherRepository.delete(publisher);
    }


    // Author methods

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

}
