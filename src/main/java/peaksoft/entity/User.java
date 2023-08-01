package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_gen"
    )
    @SequenceGenerator(
            sequenceName = "user_seq",
            name = "user_gen",
            allocationSize = 1)
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToOne(
            cascade = {
                    REFRESH,
                    MERGE,
                    PERSIST,
                    REMOVE,
                    DETACH,

            })
    @ToString.Exclude
    private Profile profile;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude

    private List<Comment>comments;
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
