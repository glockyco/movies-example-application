package sve2.movies.repositories;

import org.jnosql.artemis.Param;
import sve2.movies.domain.Movie;

import java.util.List;

public interface MovieRepository {

    Movie findByTitle(@Param("title") String title);

    List<Movie> findByTitleLike(@Param("title") String title);

    List<Movie> graph(@Param("limit") int limit);

}
