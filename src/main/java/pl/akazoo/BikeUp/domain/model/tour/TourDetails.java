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
    private String gatheringPlace;
    @Column(nullable = false,length = 1000)
    private String description;
    @Column
    private LocalDateTime creationTime;
    @Column
    private LocalDateTime updateTime;
    @Column(length = 1024)
    private String mapLink;
    @Column(nullable = false)
    private String returning;

    @PrePersist
    public void creationTimeUpdate() {
        creationTime = LocalDateTime.now();
    }

    @PreUpdate
    public void updateTimeUpdate() {
        updateTime = LocalDateTime.now();
    }
}