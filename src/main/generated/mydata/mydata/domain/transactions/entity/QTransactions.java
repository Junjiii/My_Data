package mydata.mydata.domain.transactions.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransactions is a Querydsl query type for Transactions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransactions extends EntityPathBase<Transactions> {

    private static final long serialVersionUID = -1091463567L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransactions transactions = new QTransactions("transactions");

    public final mydata.mydata.domain.basetime.QBaseTimeEntity _super = new mydata.mydata.domain.basetime.QBaseTimeEntity(this);

    public final BooleanPath accessed = createBoolean("accessed");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final mydata.mydata.domain.categories.entity.QCategories category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath detail = createString("detail");

    public final mydata.mydata.domain.finances.entity.QFinances finance;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final mydata.mydata.domain.identities.entity.QIdentities identityCi;

    public final DateTimePath<java.time.LocalDateTime> installmentDate = createDateTime("installmentDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> installmentMonth = createNumber("installmentMonth", Integer.class);

    public final StringPath invoiceSerialNumber = createString("invoiceSerialNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final EnumPath<TransactionType> transactionType = createEnum("transactionType", TransactionType.class);

    public QTransactions(String variable) {
        this(Transactions.class, forVariable(variable), INITS);
    }

    public QTransactions(Path<? extends Transactions> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransactions(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransactions(PathMetadata metadata, PathInits inits) {
        this(Transactions.class, metadata, inits);
    }

    public QTransactions(Class<? extends Transactions> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new mydata.mydata.domain.categories.entity.QCategories(forProperty("category")) : null;
        this.finance = inits.isInitialized("finance") ? new mydata.mydata.domain.finances.entity.QFinances(forProperty("finance")) : null;
        this.identityCi = inits.isInitialized("identityCi") ? new mydata.mydata.domain.identities.entity.QIdentities(forProperty("identityCi")) : null;
    }

}

