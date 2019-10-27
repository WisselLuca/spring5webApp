package guru.springframework.spring5webApp.repositories;

import guru.springframework.spring5webApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
