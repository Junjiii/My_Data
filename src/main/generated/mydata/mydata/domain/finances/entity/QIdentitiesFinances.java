package mydata.mydata.domain.finances.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIdentitiesFinances is a Querydsl query type for IdentitiesFinances
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIdentitiesFinances extends EntityPathBase<IdentitiesFinances> {

    private static final long serialVersionUID = -893595531L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIdentitiesFinances identitiesFinances = new QIdentitiesFinances("identitiesFinances");

    public final mydata.mydata.domain.basetime.QBaseTimeEntity _super = new mydata.mydata.domain.basetime.QBaseTimeEntity(this);

    public final StringPath accountNumber = createString("accountNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final QFinances finance;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final mydata.mydata.domain.identities.entity.QIdentities identityCi;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public QIdentitiesFinances(String variable) {
        this(IdentitiesFinances.class, forVariable(variable), INITS);
    }

    public QIdentitiesFinances(Path<? extends IdentitiesFinances> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIdentitiesFinances(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIdentitiesFinances(PathMetadata metadata, PathInits inits) {
        this(IdentitiesFinances.class, metadata, inits);
    }

    public QIdentitiesFinances(Class<? extends IdentitiesFinances> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.finance = inits.isInitialized("finance") ? new QFinances(forProperty("finance")) : null;
        this.identityCi = inits.isInitialized("identityCi") ? new mydata.mydata.domain.identities.entity.QIdentities(forProperty("identityCi")) : null;
    }

}

