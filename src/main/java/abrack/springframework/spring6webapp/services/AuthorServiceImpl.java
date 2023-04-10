package abrack.springframework.spring6webapp.services;

import abrack.springframework.spring6webapp.domain.Author;
import abrack.springframework.spring6webapp.repositories.AuthorRepository;

public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

}
