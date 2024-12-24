package mydata.mydata.domain.finances.entity;

import jakarta.persistence.EntityManager;
import mydata.mydata.domain.identities.entity.Identities;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class IdentitiesFinancesTest {

    @Autowired
    EntityManager em;

    Identities identity1;
    Identities identity2;
    Finances wooriBank;
    Finances shinhanCard;


    @BeforeEach
    void setUp() {
        identity1 = new Identities("01011111111", "djfkshdks");
        identity2 = new Identities("01022222222", "skjhfsss");
        wooriBank = new Finances("우리은행", "URL1", FinanceType.BANK);
        shinhanCard = new Finances("신한카드", "URL2", FinanceType.CARD);

        em.persist(identity1);
        em.persist(identity2);
        em.persist(wooriBank);
        em.persist(shinhanCard);
    }

    @Test
    public void insertIdentitiesFinancesTest() throws Exception
    {
        String accountNumber1 = "1111-11-1111111";
        String accountNumber2 = "222-22-22222";

        // given
        IdentitiesFinances identityFinance1 = new IdentitiesFinances(identity1, wooriBank, accountNumber1);
        IdentitiesFinances identityFinance2 = new IdentitiesFinances(identity2, shinhanCard, accountNumber2);

        em.persist(identityFinance1);
        em.persist(identityFinance2);
        em.flush();
        em.clear();

        // when
        IdentitiesFinances findIdentityFinance1 = em.find(IdentitiesFinances.class, identityFinance1.getId());
        IdentitiesFinances findIdentityFinance2 = em.find(IdentitiesFinances.class, identityFinance2.getId());

        // then
        assertThat(findIdentityFinance1.getId()).isEqualTo(identityFinance1.getId());
        assertThat(findIdentityFinance2.getId()).isEqualTo(identityFinance2.getId());
        assertThat(findIdentityFinance1.getIdentityCi().getCi()).isEqualTo(identity1.getCi());
        assertThat(findIdentityFinance2.getIdentityCi().getCi()).isEqualTo(identity2.getCi());
        assertThat(findIdentityFinance1.getFinance().getId()).isEqualTo(wooriBank.getId());
        assertThat(findIdentityFinance2.getFinance().getId()).isEqualTo(shinhanCard.getId());


    }


}