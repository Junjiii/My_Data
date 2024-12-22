package mydata.mydata.domain.auth.entity;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class IdentitiesTest {

    @Autowired
    EntityManager em;

    @Test
    public void insertIdentities() throws Exception
    {
        // given
        Identities identity = new Identities("01022222222", "qwer1234-qwer1234");

        // when
        em.persist(identity);
        em.flush();
        em.clear();
        Identities findIdentity = em.find(Identities.class, identity.getId());

        // then
        assertThat(findIdentity.getId()).isEqualTo(identity.getId());
        assertThat(findIdentity.getCi()).isEqualTo(identity.getCi());
        assertThat(findIdentity.getPhoneNumber()).isEqualTo(identity.getPhoneNumber());
        assertThat(findIdentity.getCreatedDate()).isEqualTo(identity.getCreatedDate());
        assertThat(findIdentity.getLastModifiedDate()).isEqualTo(identity.getLastModifiedDate());
    }

}