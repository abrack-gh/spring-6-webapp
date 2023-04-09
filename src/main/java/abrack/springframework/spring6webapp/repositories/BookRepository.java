package abrack.springframework.spring6webapp.repositories;

import abrack.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Long> {
}
