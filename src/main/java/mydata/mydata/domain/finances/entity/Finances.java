package mydata.mydata.domain.finances.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mydata.mydata.domain.basetime.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Finances extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "finance_id")
    private Long id;
    private String name;

    private String imageURL;

    @Enumerated(EnumType.STRING)
    private FinanceType financeType;

    public Finances(String name, String imageURL, FinanceType financeType) {
        this.name = name;
        this.imageURL = imageURL;
        this.financeType = financeType;
    }

}
