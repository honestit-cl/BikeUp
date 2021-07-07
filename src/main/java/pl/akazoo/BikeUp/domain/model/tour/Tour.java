package pl.akazoo.BikeUp.domain.model.tour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Formula;
import pl.akazoo.BikeUp.domain.model.user.User;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tours")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user","tourDetails"})
@Getter
@Setter
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JsonIgnore
    private TourDetails tourDetails;
    //
    @Formula("(select count(p.id) from participators p where p.tour_id=id and p.status like 'aktywny')")
    private int realParticipants;
    @Column(nullable = false)
    private int participants; //allowed number of participants
    //
    @Column(nullable = false)
    private Long distance; //distance in km
    @Column(nullable = false)
    private String hours; //duration
    @Column
    private LocalDate date; //event date
    @Column(nullable = false)
    private String active;
    @ManyToOne
    @JsonIgnore
    private User user;
    @Column (nullable = false)
    private String startPlace;
    @Column (nullable = false)
    private String startPost; // postal code
    @Column (nullable = false)
    private String endPlace;
    @Column (nullable = false)
    private String endPost; // postal code
}