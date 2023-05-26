package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Book implements ValueObject {

    private final BookId id;
    private final String bookTitle;
    private final String bookAuthor;
    private final Money price;
    private final int sales;


    private Book(){
        this.id = BookId.randomId(BookId.class);
        this.bookTitle = "";
        this.bookAuthor = "";
        this.price = Money.valueOf(Currency.MKD,0);
        this.sales = 0;
    }

    @JsonCreator
    public Book(@JsonProperty("id") BookId id,
                @JsonProperty("bookTitle") String bookTitle,
                @JsonProperty("bookAuthor") String bookAuthor,
                @JsonProperty("price") Money price,
                @JsonProperty("sales") int sales) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.price = price;
        this.sales = sales;
    }


}
