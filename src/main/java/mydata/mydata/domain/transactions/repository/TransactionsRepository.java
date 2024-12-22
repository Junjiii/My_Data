package mydata.mydata.domain.transactions.repository;

import mydata.mydata.domain.transactions.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
}
