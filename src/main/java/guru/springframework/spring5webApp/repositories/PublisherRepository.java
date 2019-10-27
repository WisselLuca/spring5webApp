package guru.springframework.spring5webApp.repositories;

import guru.springframework.spring5webApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
