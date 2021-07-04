package pl.akazoo.BikeUp.domain.model.user;

import lombok.*;
import org.hibernate.annotations.Formula;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @ManyToOne
    private Province province;
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