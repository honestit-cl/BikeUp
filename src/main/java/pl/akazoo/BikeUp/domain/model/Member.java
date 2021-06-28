package pl.akazoo.BikeUp.domain.model;

import lombok.*;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.user.User;
import javax.persistence.*;

@Entity
@Table(name = "participators", uniqueConstraints = @UniqueConstraint(columnNames = {"tour_id","user_id"}))
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Tour tour;
    @Column(nullable = false)
    private String status;
}