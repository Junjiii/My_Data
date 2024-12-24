package mydata.mydata.domain.transactions.entity;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import mydata.mydata.domain.categories.entity.Categories;
import mydata.mydata.domain.finances.entity.FinanceType;
import mydata.mydata.domain.finances.entity.Finances;
import mydata.mydata.domain.identities.entity.Identities;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BigDecimalAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
//@Rollback(value = false)
@Slf4j
class TransactionsTest {

    @Autowired
    EntityManager em;

    Identities identity1;
    Identities identity2;
    Finances wooriBank;
    Finances shinhanCard;
    Categories utility;
    Categories shopping;


    @BeforeEach
    void setUp() {
        identity1 = new Identities("01011111111", "djfkshdks");
        identity2 = new Identities("01022222222", "skjhfsss");
        wooriBank = new Finances("우리은행", "URL1", FinanceType.BANK);
        shinhanCard = new Finances("신한카드", "URL2", FinanceType.CARD);
        utility = new Categories("공과금");
        shopping = new Categories("쇼핑");

        em.persist(identity1);
        em.persist(identity2);
        em.persist(wooriBank);
        em.persist(shinhanCard);
        em.persist(utility);
        em.persist(shopping);
    }

    @Test
    public void insertTransactionsTest() throws Exception
    {
        // given
        Transactions transaction1 = new Transactions("SH주택관리공사", 100000, TransactionType.REGULAR, utility, wooriBank, identity1);
        Transactions transaction2 = new Transactions("무신사", 149000, TransactionType.GENERAL, shopping, shinhanCard, identity2);
        transaction2.setInstallment(3);
        transaction2.setAccessed();

        em.persist(transaction1);
        em.persist(transaction2);

        em.flush();
        em.clear();

        // when
        Transactions findTransaction1 = em.find(Transactions.class, transaction1.getId());
        Transactions findTransaction2 = em.find(Transactions.class, transaction2.getId());

        // transaction1
        assertThat(findTransaction1.getId()).isEqualTo(findTransaction1.getId());
        assertThat(findTransaction1.getInvoiceSerialNumber()).isEqualTo(transaction1.getInvoiceSerialNumber()); // invoiceSerialNumber
        assertThat(findTransaction1.getDetail()).isEqualTo(transaction1.getDetail()); // detail
        assertInstanceOf(BigDecimal.class,findTransaction1.getAmount()); // bigDecimal type
        assertThat(findTransaction1.getAmount()).isEqualByComparingTo(transaction1.getAmount().setScale(2));// amount
        assertThat(findTransaction1.getTransactionType()).isEqualTo(transaction1.getTransactionType()); // transactionType
        assertThat(findTransaction1.getCategory().getId()).isEqualTo(utility.getId()); // category
        assertThat(findTransaction1.getFinance().getId()).isEqualTo(wooriBank.getId()); // finance
        assertThat(findTransaction1.getIdentityCi().getCi()).isEqualTo(identity1.getCi()); // ci
        assertThat(findTransaction1.getInstallmentMonth()).isEqualTo(0); // installmentMonth
        assertThat(findTransaction1.getInstallmentDate()).isNull();  // installmentDate
        assertThat(findTransaction1.isAccessed()).isEqualTo(false);


        // transaction2
        assertThat(findTransaction2.getId()).isEqualTo(findTransaction2.getId());
        assertThat(findTransaction2.getInvoiceSerialNumber()).isEqualTo(transaction2.getInvoiceSerialNumber()); // invoiceSerialNumber
        assertThat(findTransaction2.getDetail()).isEqualTo(transaction2.getDetail()); // detail
        assertInstanceOf(BigDecimal.class,findTransaction2.getAmount()); // bigDecimal type
        assertThat(findTransaction2.getAmount()).isEqualByComparingTo(transaction2.getAmount().setScale(2));// amount
        assertThat(findTransaction2.getTransactionType()).isEqualTo(transaction2.getTransactionType()); // transactionType
        assertThat(findTransaction2.getCategory().getId()).isEqualTo(shopping.getId()); // category
        assertThat(findTransaction2.getFinance().getId()).isEqualTo(shinhanCard.getId()); // finance
        assertThat(findTransaction2.getIdentityCi().getCi()).isEqualTo(identity2.getCi()); // ci
        assertThat(findTransaction2.getInstallmentMonth()).isEqualTo(3); // installmentMonth
        assertThat(findTransaction2.getInstallmentDate()).isEqualTo(transaction2.getInstallmentDate()); // installmentDate
        assertThat(findTransaction2.isAccessed()).isEqualTo(true); // setAccessed test


    }

}