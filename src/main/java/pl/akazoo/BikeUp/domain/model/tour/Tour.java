package pl.akazoo.BikeUp.domain.model.tour;

import lombok.*;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.province.City;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tours")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private TourDetails tourDetails;
    //
    @OneToMany(mappedBy = "tour")
    private List<Member> members;
    //
    @Column(nullable = false)
    private int participants; //allowed number of participants
    @Column(nullable = false)
    private int kilometers; //distance
    @ManyToOne
    private City city;
    @Column(nullable = false)
    private double hours; //duration
    @Column
    private LocalDate date; //event date
}