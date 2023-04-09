package abrack.springframework.spring6webapp.services;

import abrack.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();


}
