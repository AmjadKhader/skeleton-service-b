package skeleton.b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skeleton.b.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/user/{user_id}", produces = "application/json")
    public ResponseEntity<?> getUserOrders(@PathVariable("user_id") String userId) {
        try {
            return new ResponseEntity<>(orderService.getUserOrders(Long.valueOf(userId)), HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{order_id}", produces = "application/json")
    public ResponseEntity<?> getOrder(@PathVariable("order_id") String orderId) {
        try {
            return new ResponseEntity<>(orderService.getOrder(Long.valueOf(orderId)), HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{user_id}/{order_id}", produces = "application/json")
    public ResponseEntity<?> getUserOrder(@PathVariable("user_id") String userId, @PathVariable("order_id") String orderId) {
        try {
            return new ResponseEntity<>(orderService.getUserOrder(Long.valueOf(userId), Long.valueOf(orderId)), HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
