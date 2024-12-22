package mydata.mydata.domain.transactions.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mydata.mydata.domain.auth.entity.Identities;
import mydata.mydata.domain.basetime.BaseTimeEntity;
import mydata.mydata.domain.categories.entity.Categories;
import mydata.mydata.domain.finances.entity.Finances;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transactions extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Long id;

    private String invoiceNumber;
    private String detail;

    @Column(precision = 10,scale = 2)
    private BigDecimal amount;


    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private int installmentMonth;

    private LocalDateTime installmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id")
    private Categories category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finances_id")
    private Finances finance;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_ci", referencedColumnName = "ci")
    private Identities identityCi;

    @Column(columnDefinition = "boolean default false")
    private boolean isGet;

    public Transactions(String invoiceNumber,
                        String detail,
                        BigDecimal amount,
                        TransactionType transactionType,
                        int installmentMonth,
                        LocalDateTime installmentDate,
                        Categories category,
                        Finances finance,
                        Identities identityCi) {
        this.invoiceNumber = invoiceNumber;
        this.detail = detail;
        this.amount = amount;
        this.transactionType = transactionType;
        this.installmentMonth = installmentMonth;
        this.installmentDate = installmentDate;
        this.category = category;
        this.finance = finance;
        this.identityCi = identityCi;
    }

    public void setIsGet() {
        isGet = true;
    }
}
