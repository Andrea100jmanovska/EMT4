package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class BookId extends DomainObjectId {
    protected BookId() {
        super(BookId.randomId(BookId.class).getId());
    }

    public BookId(String uuid) {
        super(uuid);
    }

}
