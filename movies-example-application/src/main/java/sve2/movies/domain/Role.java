package sve2.movies.domain;

import org.jnosql.artemis.Id;

// @FIXME: add some sort of @RelationshipEntity annotation
public class Role {

    @Id
    private Long id;

    // @FIXME: add some sort of @StartNode annotation
    private Person person;

    // @FIXME: add some sort of @EndNode annotation
    private Movie movie;

    private String name;

    public Role() {
    }

    public Role(Person person, Movie movie) {
        this.person = person;
        this.movie = movie;
    }

    public Role(Person person, Movie movie, String name) {
        this.person = person;
        this.movie = movie;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    public Movie getMovie() {
        return movie;
    }
}
