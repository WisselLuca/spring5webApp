package guru.springframework.spring5webApp.repositories;

import guru.springframework.spring5webApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
