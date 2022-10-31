package bg.softuni.hasEntities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", targetEntity = Article.class,
        fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> articles;

    public User() {
        this.articles = new ArrayList<>();
    }

    public User(String name) {
        this();

        this.name = name;
    }

    public void addArtice(Article article) {
        this.articles.add(article);
    }
}
