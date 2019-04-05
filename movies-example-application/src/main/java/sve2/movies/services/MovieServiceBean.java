package sve2.movies.services;

import sve2.movies.domain.Movie;
import sve2.movies.repositories.MovieRepository;

import javax.inject.Inject;
import java.util.*;

public class MovieServiceBean implements MovieService {

    @Inject
    private MovieRepository movieRepository;

    @Override
    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> findByTitleLike(String title) {
        return movieRepository.findByTitleLike(title);
    }

    @Override
    public Map<String, Object> graph(int limit) {
        return toD3Format(movieRepository.graph(limit));
    }

    private Map<String, Object> toD3Format(Collection<Movie> movies) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();

        /*
        int i = 0;
        for (Movie movie : movies) {
            nodes.add(map("title", movie.getTitle(), "label", "movie"));
            int target = i;
            i++;
            for (Role role : movie.getRoles()) {
                Map<String, Object> actor = map("title", role.getPerson().getName(), "label", "actor");
                int source = nodes.indexOf(actor);
                if (source == -1) {
                    nodes.add(actor);
                    source = i++;
                }
                rels.add(map("source", source, "target", target));
            }
        }
        */

        return map("nodes", nodes, "links", rels);
    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }


}
