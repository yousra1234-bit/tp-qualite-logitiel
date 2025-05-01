package tp3.exo2;



public class OrderController {
    private final OrderService orderService;

    // Injection via le constructeur
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order createNewOrder(Order order) {
        return orderService.createOrder(order);
    }
}
