package mk.ukim.finki.emt.ordermanagement.service.forms;


import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Data
public class OrderForm {

    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<OrderBookForm> items = new ArrayList<>();

}
