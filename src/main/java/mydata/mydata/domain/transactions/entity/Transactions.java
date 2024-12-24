package mydata.mydata.domain.transactions.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mydata.mydata.domain.identities.entity.Identities;
import mydata.mydata.domain.basetime.BaseTimeEntity;
import mydata.mydata.domain.categories.entity.Categories;
import mydata.mydata.domain.finances.entity.Finances;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transactions extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Long id;

    private String invoiceSerialNumber;

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
    private boolean accessed;


    public Transactions(String detail,
                        int amount,
                        TransactionType transactionType,
                        Categories category,
                        Finances finance,
                        Identities identityCi) {

        this.invoiceSerialNumber = UUID.randomUUID().toString();
        this.detail = detail;
        this.amount = new BigDecimal(amount);
        this.transactionType = transactionType;
        this.category = category;
        this.finance = finance;
        this.identityCi = identityCi;
//        this.accessed = false;
    }


    public void setInstallment(int installmentMonth) {
        this.installmentMonth = installmentMonth;
        this.installmentDate = LocalDateTime.now();
    }

    public void setAccessed() {
        accessed = true;
    }
}
