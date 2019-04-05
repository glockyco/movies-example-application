package sve2.movies.rest;

import sve2.movies.domain.Movie;
import sve2.movies.services.MovieService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/")
@RequestScoped
public class MovieResource {

    @Inject
    private MovieService movieService;

    @GET
    @Path("/graph/")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> graph(/*Integer limit*/) {
        return movieService.graph(100);
    }

    @GET
    @Path("/movies/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie findByTitle(@PathParam("title") String title) {
        return movieService.findByTitle(title);
    }

    @GET
    @Path("/search/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> findByTitleLike(@QueryParam("q") String title) {
        return movieService.findByTitleLike(title);
    }

}
