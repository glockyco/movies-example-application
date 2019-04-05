package sve2.movies.repositories;

import org.jnosql.artemis.graph.GraphTemplate;
import sve2.movies.domain.Role;

import javax.inject.Inject;

public class RoleRepositoryBean implements RoleRepository {

    @Inject
    private GraphTemplate graph;

    @Override
    public Role findByMovieAndPerson(String movie, String person) {
        // @TODO: get the role that the given person had in the given movie

        return null;
    }
}
