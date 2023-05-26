package mk.ukim.finki.emt.ordermanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.exeptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.exeptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderBookId;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.repository.OrderRepositorty;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderBookForm;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.xml.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepositorty orderRepositorty;
    private final Validator validator;


    @Override
    public OrderId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm,"order must not be null.");
        var constraintViolations = validator.validate(orderForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
        }


    }



    @Override
    public List<Order> findAll() {
        return orderRepositorty.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return orderRepositorty.findById(id);
    }

    @Override
    public void addBook(OrderId orderId, OrderBookForm orderBookForm) throws OrderIdNotExistException {

    }

    @Override
    public void deleteBook(OrderId orderId, OrderBookId orderBookId) throws OrderIdNotExistException, OrderItemIdNotExistException {

    }

    private Order toDomainObject(OrderForm orderForm){
        var order = new Order (orderForm.getCurrency());
    }
}
