package pl.moja.biblioteczka.database.model;

import javax.persistence.*;

@Entity
@Table(name = "category2")
public class Category implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public Category() {
    }

    public Category(String firstName) {
        this.name = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer authorId) {
        this.id = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

}
