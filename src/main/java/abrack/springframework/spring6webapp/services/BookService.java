package abrack.springframework.spring6webapp.services;

import abrack.springframework.spring6webapp.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    Iterable<Book> findAll();


}
