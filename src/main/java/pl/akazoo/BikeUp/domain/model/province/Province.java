package pl.akazoo.BikeUp.domain.model.province;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provinces")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"cities"})
@Getter
@Setter
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "province")
    private List<City> cities = new ArrayList<>();
}