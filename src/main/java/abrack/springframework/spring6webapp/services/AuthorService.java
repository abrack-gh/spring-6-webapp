package abrack.springframework.spring6webapp.services;

import abrack.springframework.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
