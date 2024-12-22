package mydata.mydata.domain.auth.repository;

import mydata.mydata.domain.auth.entity.Identities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentitiesRepository extends JpaRepository<Identities,Long> {
}
