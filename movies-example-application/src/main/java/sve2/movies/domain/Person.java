package sve2.movies.domain;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity
public class Person {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private int born;

    // @FIXME: add some sort of @Relationship annotation
    // private List<Role> roles = new ArrayList<>();

    public Person() {
    }

    public Person(String name, int born) {
        this.name = name;
        this.born = born;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }

    // public List<Role> getRoles() {
    //     return roles;
    // }
}
