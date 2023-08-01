package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.DETACH;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_gen"
    )
    @SequenceGenerator(
            sequenceName = "post_seq",
            name = "post_gen",
            allocationSize = 1)
    private Long id;
    private String image;
    private String description;
    private LocalDate created;

    @ManyToOne(cascade = {
            REFRESH,
            MERGE,
            PERSIST,
            // REMOVE,
            DETACH,

    })
    @ToString.Exclude
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Comment> comments;


    public Post(String image, String description, LocalDate created) {
        this.image = image;
        this.description = description;
        this.created = created;
    }
}
