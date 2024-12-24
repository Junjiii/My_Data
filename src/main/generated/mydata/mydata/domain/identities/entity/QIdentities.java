package mydata.mydata.domain.identities.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QIdentities is a Querydsl query type for Identities
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIdentities extends EntityPathBase<Identities> {

    private static final long serialVersionUID = -64090817L;

    public static final QIdentities identities = new QIdentities("identities");

    public final mydata.mydata.domain.basetime.QBaseTimeEntity _super = new mydata.mydata.domain.basetime.QBaseTimeEntity(this);

    public final StringPath ci = createString("ci");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath phoneNumber = createString("phoneNumber");

    public QIdentities(String variable) {
        super(Identities.class, forVariable(variable));
    }

    public QIdentities(Path<? extends Identities> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIdentities(PathMetadata metadata) {
        super(Identities.class, metadata);
    }

}

