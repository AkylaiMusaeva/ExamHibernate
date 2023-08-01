package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.Gender;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Profile {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_gen"
    )
    @SequenceGenerator(
            sequenceName = "profile_seq",
            name = "profile_gen",
            allocationSize = 1)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String bio;




    @OneToOne(mappedBy = "profile",
    cascade = {
            REFRESH,
            MERGE,
            PERSIST,
           // REMOVE,
            DETACH,

    })
    @ToString.Exclude
    private User user;

    public Profile(String fullName, LocalDate dateOfBirth, Gender gender, String bio) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bio = bio;
    }
}
