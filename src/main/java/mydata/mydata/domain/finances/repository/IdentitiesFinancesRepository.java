package mydata.mydata.domain.finances.repository;

import mydata.mydata.domain.finances.entity.IdentitiesFinances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentitiesFinancesRepository extends JpaRepository<IdentitiesFinances,Long> {
}
