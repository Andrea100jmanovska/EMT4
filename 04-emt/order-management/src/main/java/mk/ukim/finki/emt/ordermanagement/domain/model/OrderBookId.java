package mk.ukim.finki.emt.ordermanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OrderBookId extends DomainObjectId {
    private OrderBookId() {
        super(OrderBookId.randomId(OrderBookId.class).getId());
    }

    protected OrderBookId(String uuid) {
        super(uuid);
    }

}
