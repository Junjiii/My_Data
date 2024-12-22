package mydata.mydata.domain.finances.repository;

import mydata.mydata.domain.finances.entity.Finances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancesRepository extends JpaRepository<Finances,Long> {
}
