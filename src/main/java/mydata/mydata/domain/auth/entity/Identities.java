package mydata.mydata.domain.auth.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mydata.mydata.domain.basetime.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Identities extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "identity_id")
    private Long id;
    private String phoneNumber;

    @Column(unique = true)
    private String ci;

    public Identities(String phoneNumber, String ci) {
        this.phoneNumber = phoneNumber;
        this.ci = ci;
    }
}
