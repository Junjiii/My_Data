package mydata.mydata.domain.identities.repository;

import mydata.mydata.domain.identities.entity.Identities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentitiesRepository extends JpaRepository<Identities,Long> {
}
