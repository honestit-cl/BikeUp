package pl.akazoo.BikeUp.domain.model.tour;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tours_details")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TourDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "tourDetails")
    private Tour tour;
    @Column(nullable = false)
    private String start; //starting place
    @Column(nullable = false)
    private String description; //  extra description
    @Column(nullable = false)
    private Long howFar; // how far from city chosen before
    @Column
    private LocalDateTime creationTime;
    @Column
    private LocalDateTime updateTime;

    @PrePersist
    public void creationTimeUpdate() {
        creationTime = LocalDateTime.now();
    }

    @PreUpdate
    public void updateTimeUpdate() {
        updateTime = LocalDateTime.now();
    }
}