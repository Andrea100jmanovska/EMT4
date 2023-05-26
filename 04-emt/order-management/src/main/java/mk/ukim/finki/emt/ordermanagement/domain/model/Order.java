package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.*;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.orm.hibernate5.HibernateTemplate;


import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity<OrderId> {

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<OrderBook> orderBookList;

    public Order(java.util.@NotNull Currency currency){
        super(OrderId.randomId(OrderId.class));
    }

    public Money totalAmount(){
        return  orderBookList.stream().map(OrderBook::subtotal).reduce(new Money(currency,0), Money::add);
    }

    public OrderBook addBook(@NonNull Book book, int qty){
        Objects.requireNonNull(book,"book must not be null");
        var item = new OrderBook(book.getId(),book.getPrice,qty);
        orderBookList.add(item);
        return item;
    }
    public void removeBook(@NonNull OrderBookId orderBookId){
        Objects.requireNonNull(orderBookId,"Order Book must not be null");
        orderBookList.removeIf(v->v.getId().equals(orderBookId));
    }
}
