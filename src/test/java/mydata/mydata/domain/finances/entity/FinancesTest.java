package mydata.mydata.domain.finances.entity;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FinancesTest {

    @Autowired
    EntityManager em;

    @Test
    public void insertFinance() throws Exception
    {
        // given
        Finances wooriBank = new Finances("우리은행", "URL1", FinanceType.BANK);
        Finances shinhanCard = new Finances("신한카드", "URL2", FinanceType.CARD);

        em.persist(wooriBank);
        em.persist(shinhanCard);
        em.flush();
        em.clear();

        // when
        Finances findWooriBank = em.find(Finances.class, wooriBank.getId());
        Finances findShinhanCard = em.find(Finances.class, shinhanCard.getId());

        // then
        // wooriBank
        assertThat(findWooriBank.getId()).isEqualTo(wooriBank.getId());
        assertThat(findWooriBank.getName()).isEqualTo(wooriBank.getName());
//        Assertions.assertThat(findWooriBank.get).isEqualTo(wooriBank.getId());
//        Assertions.assertThat(findWooriBank.getId()).isEqualTo(wooriBank.getId());
//        Assertions.assertThat(findWooriBank.getId()).isEqualTo(wooriBank.getId());

        // shinhanCard
        assertThat(findShinhanCard.getId()).isEqualTo(shinhanCard.getId());
//        Assertions.assertThat(findShinhanCard.getId()).isEqualTo(shinhanCard.getId());
//        Assertions.assertThat(findShinhanCard.getId()).isEqualTo(shinhanCard.getId());
//        Assertions.assertThat(findShinhanCard.getId()).isEqualTo(shinhanCard.getId());
//        Assertions.assertThat(findShinhanCard.getId()).isEqualTo(shinhanCard.getId());


    }
}