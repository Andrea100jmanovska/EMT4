package mk.ukim.finki.emt.bookcatalog.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.bookcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name="book")
@Getter
public class Book extends AbstractEntity<BookId> {

    private String bookTitle;

    private String bookAuthor;


    private int sales = 0;
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;

    private Book() {
        super(BookId.randomId(BookId.class));
    }

    public static Book build(String bookTitle, String bookAuthor, Money price, int sales) {
        Book b = new Book();
        b.price = price;
        b.bookTitle = bookTitle;
        b.bookAuthor = bookAuthor;
        b.sales = sales;
        return b;
    }

    public void addSales(int qty) {
        this.sales = this.sales + qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty;
    }

}
