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
@Table(name = "comments")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_gen"
    )
    @SequenceGenerator(
            sequenceName = "comment_seq",
            name = "comment_gen",
            allocationSize = 1)
    private Long id;
    private String text;
    private LocalDate commentDate;



    @ManyToOne(cascade = {
            REFRESH,
            MERGE,
            PERSIST,
            // REMOVE,
            DETACH,

    })
    @ToString.Exclude
    private User user;



    @ManyToMany(mappedBy = "comments",cascade = {
            REFRESH,
            MERGE,
            PERSIST,
            // REMOVE,
            DETACH,

    })
    @ToString.Exclude
    private List<Post> posts;

    public Comment(String text, LocalDate commentDate) {
        this.text = text;
        this.commentDate = commentDate;
    }

}
