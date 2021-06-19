package pl.akazoo.BikeUp.domain.model.province;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToOne
    private Province province;
}