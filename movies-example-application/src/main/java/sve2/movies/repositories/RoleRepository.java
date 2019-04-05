package sve2.movies.repositories;

import sve2.movies.domain.Role;

public interface RoleRepository {

    Role findByMovieAndPerson(String movie, String person);

}
