package mk.ukim.finki.emt.ordermanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Book;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderBookForm {

    @NotNull
    private Book book;

    @Min(1)
    private int quantity = 1;
}
