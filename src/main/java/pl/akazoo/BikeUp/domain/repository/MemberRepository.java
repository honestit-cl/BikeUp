package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}