package guru.springframework.spring5webApp.DevBootstrap;

import guru.springframework.spring5webApp.model.Author;
import guru.springframework.spring5webApp.model.Book;
import guru.springframework.spring5webApp.model.Publisher;
import guru.springframework.spring5webApp.repositories.AuthorRepository;
import guru.springframework.spring5webApp.repositories.BookRepository;
import guru.springframework.spring5webApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher feltrinelli = new Publisher("feltrinelli", "Roma");
        Book ddd = new Book("Domain Driven Design", "1234", feltrinelli);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(feltrinelli);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher mondadori = new Publisher("Mondadori", "Milano");
        Book noEJB = new Book("J2EE Development without EJB", "23444", mondadori);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(mondadori);
        bookRepository.save(noEJB);
    }
}
