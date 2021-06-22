package pl.akazoo.BikeUp.domain.model.tour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Formula;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.domain.model.user.User;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tours")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user","members","tourDetails"})
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
    @Formula("(select count(p.id) from participators p where p.tour_id=id and p.status like 'active')")
    private int realParticipants;
    @OneToMany(mappedBy = "tour")
    @JsonIgnore
    private List<Member> members;
    //
    @Column(nullable = false)
    private int participants; //allowed number of participants
    @Column(nullable = false)
    private Long distance; //distance in km
    @ManyToOne
    private City city;
    @Column(nullable = false)
    private String hours; //duration
    @Column
    private LocalDate date; //event date
    @Column(nullable = false)
    private String active;
    @ManyToOne
    @JsonIgnore
    private User user;
}