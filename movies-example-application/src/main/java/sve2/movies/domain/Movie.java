package sve2.movies.domain;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity
public class Movie {

    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private int released;

    @Column
    private String tagline;

    // @FIXME: add some sort of @Relationship annotation
    // private List<Role> roles = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, int released, String tagline) {
        this.title = title;
        this.released = released;
        this.tagline = tagline;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleased() {
        return released;
    }

    public String getTagline() {
        return tagline;
    }

    // public List<Role> getRoles() {
    //     return roles;
    // }
}
