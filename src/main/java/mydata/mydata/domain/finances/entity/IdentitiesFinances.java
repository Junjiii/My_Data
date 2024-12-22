package mydata.mydata.domain.finances.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mydata.mydata.domain.auth.entity.Identities;
import mydata.mydata.domain.basetime.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdentitiesFinances extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "identity_finance_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "identity_ci", referencedColumnName = "ci")
    private Identities identityCi;

    @ManyToOne
    @JoinColumn(name = "finance_id")
    private Finances finance;

    private String accountNumber;

    public IdentitiesFinances(Identities identityCi, Finances finance, String accountNumber) {
        this.identityCi = identityCi;
        this.finance = finance;
        this.accountNumber = accountNumber;
    }
}
