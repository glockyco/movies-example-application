package sve2.movies.repositories;

import org.jnosql.artemis.graph.GraphTemplate;
import sve2.movies.domain.Movie;

import javax.inject.Inject;
import java.util.List;

public class MovieRepositoryBean implements MovieRepository {

    @Inject
    private GraphTemplate graph;

    @Override
    public Movie findByTitle(String title) {
        return graph.getTraversalVertex()
            .hasLabel(Movie.class)
            .has("title", title)
            .<Movie>getSingleResult()
            .orElse(null);
    }

    @Override
    public List<Movie> findByTitleLike(String title) {
        return graph.getTraversalVertex()
            .hasLabel(Movie.class)
            .<Movie>filter((i) -> i.getTitle().contains(title))
            .getResultList();
    }

    @Override
    public List<Movie> graph(int limit) {
        return graph.getTraversalVertex()
            .hasLabel(Movie.class)
            .limit(limit)
            .getResultList();
    }
}
