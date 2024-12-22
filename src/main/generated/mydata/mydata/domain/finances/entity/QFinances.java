package mydata.mydata.domain.finances.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFinances is a Querydsl query type for Finances
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFinances extends EntityPathBase<Finances> {

    private static final long serialVersionUID = 1921369721L;

    public static final QFinances finances = new QFinances("finances");

    public final mydata.mydata.domain.basetime.QBaseTimeEntity _super = new mydata.mydata.domain.basetime.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final EnumPath<FinanceType> financeType = createEnum("financeType", FinanceType.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageURL = createString("imageURL");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public QFinances(String variable) {
        super(Finances.class, forVariable(variable));
    }

    public QFinances(Path<? extends Finances> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFinances(PathMetadata metadata) {
        super(Finances.class, metadata);
    }

}

