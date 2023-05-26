package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.BookId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name="order_book")
@Getter
public class OrderBook extends AbstractEntity<OrderBookId> {

    private Money bookPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id",column = @Column(name = "book_id", nullable = false))
    private BookId bookId;

    private OrderBook() {
        super(DomainObjectId.randomId(OrderBookId.class));
    }

    public OrderBook(@NonNull BookId bookId,@NonNull Money bookPrice, int qty) {
        super(DomainObjectId.randomId(OrderBookId.class));
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.quantity = qty;
    }


    public Money subtotal(){
        return bookPrice.multiply(quantity);
    }
}
