package sve2.movies.repositories;

import org.jnosql.artemis.Param;
import sve2.movies.domain.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> findByMovie(@Param("movie") String movie);

}
