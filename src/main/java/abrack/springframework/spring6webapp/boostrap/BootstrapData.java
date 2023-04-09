package abrack.springframework.spring6webapp.boostrap;

import abrack.springframework.spring6webapp.domain.Author;
import abrack.springframework.spring6webapp.domain.Book;
import abrack.springframework.spring6webapp.domain.Publisher;
import abrack.springframework.spring6webapp.repositories.AuthorRepository;
import abrack.springframework.spring6webapp.repositories.BookRepository;
import abrack.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author alex = new Author();
        alex.setFirstName("Alex");
        alex.setLastName("Brackenridge");

        Book awesomeness = new Book();
        awesomeness.setTitle("Awesomeness");
        awesomeness.setIsbn("123456");

        Author alexSaved = authorRepository.save(alex);
        Book awesomenessSaved = bookRepository.save(awesomeness);

        Author bob = new Author();
        bob.setFirstName("Bob");
        bob.setLastName("Bobson");

        Book epicness = new Book();
        epicness.setTitle("Epicness");
        epicness.setIsbn("654321");

        Author bobSaved = authorRepository.save(bob);
        Book epicnessSaved = bookRepository.save(epicness);

        alexSaved.getBooks().add(awesomenessSaved);
        bobSaved.getBooks().add(epicnessSaved);
        awesomenessSaved.getAuthors().add(alexSaved);
        epicnessSaved.getAuthors().add(bobSaved);

        authorRepository.save(alexSaved);
        authorRepository.save(bobSaved);

        System.out.println("In bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());

        Publisher Jack = new Publisher();
        Jack.setPublisherName("Jack");
        Jack.setAddress("123 Street Name");
        Jack.setCity("RandomCity");
        Jack.setPostCode("RA7 DOM");
        Publisher savedPublisher = publisherRepository.save(Jack);

        awesomenessSaved.setPublisher(savedPublisher);
        epicnessSaved.setPublisher(savedPublisher);
        bookRepository.save(awesomenessSaved);
        bookRepository.save(epicnessSaved);

        System.out.println("Publisher count: " + publisherRepository.count());


    }
}
