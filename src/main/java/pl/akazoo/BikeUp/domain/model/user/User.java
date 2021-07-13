package pl.akazoo.BikeUp.domain.model.user;

import lombok.*;
import org.hibernate.annotations.Formula;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Formula("(select SUM(p.amount) from points p where p.owner_id = id)")
    private Long points;
    @Column
    private LocalDate creationDate;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(nullable = false)
    private String role;
    @Column
    private String visibility;

    @PrePersist
    public void creationDateUpdate(){
        this.creationDate = LocalDate.now();
    }
}