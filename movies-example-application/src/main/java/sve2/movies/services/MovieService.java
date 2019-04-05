package sve2.movies.services;

import sve2.movies.domain.Movie;

import java.util.List;
import java.util.Map;

public interface MovieService {

    Movie findByTitle(String title);

    List<Movie> findByTitleLike(String title);

    Map<String, Object> graph(int limit);

}
