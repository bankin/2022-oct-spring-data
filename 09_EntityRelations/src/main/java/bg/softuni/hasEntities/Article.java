package bg.softuni.hasEntities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @ManyToOne
    private User author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "articles_categories",
        joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "id")

    )
    private Set<Category> categories;

    public Article() {
        this.categories = new HashSet<>();
    }

    public Article(String text) {
        this();

        this.text = text;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
