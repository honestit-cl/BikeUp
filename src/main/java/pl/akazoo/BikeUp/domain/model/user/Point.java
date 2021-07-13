package pl.akazoo.BikeUp.domain.model.user;

import lombok.*;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import javax.persistence.*;

@Entity
@Table(name = "points", uniqueConstraints = @UniqueConstraint(columnNames = {"tour_id","owner_id","giver_id"}))
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long amount;
    @ManyToOne
    private Tour tour;
    @ManyToOne
    private User owner;
    @Column
    private String description;
    @ManyToOne
    private User giver;
}