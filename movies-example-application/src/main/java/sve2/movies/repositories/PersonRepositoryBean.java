package sve2.movies.repositories;

import org.jnosql.artemis.graph.GraphTemplate;
import sve2.movies.domain.Movie;
import sve2.movies.domain.Person;

import javax.inject.Inject;
import java.util.List;

public class PersonRepositoryBean implements PersonRepository {

    @Inject
    private GraphTemplate graph;

    @Override
    public List<Person> findByMovie(String movie) {
        return graph.getTraversalVertex()
            .hasLabel(Movie.class).has("title", movie)
            .in().hasLabel(Person.class)
            .getResultList();
    }
}
