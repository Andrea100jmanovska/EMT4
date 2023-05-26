package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.exeptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.exeptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderBook;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderBookId;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderBookForm;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderId placeOrder(OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addBook(OrderId orderId, OrderBookForm orderBookForm) throws OrderIdNotExistException;

    void deleteBook(OrderId orderId, OrderBookId orderBookId) throws OrderIdNotExistException,OrderItemIdNotExistException;

}
