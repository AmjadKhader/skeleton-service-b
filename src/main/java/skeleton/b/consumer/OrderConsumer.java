package skeleton.b.consumer;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import skeleton.b.request.kafka.PlaceOrder;
import skeleton.b.request.kafka.UpdateOrder;
import skeleton.b.service.OrderService;

import java.util.Objects;

@Component
public class OrderConsumer {

    @Autowired
    OrderService orderService;

    @KafkaListener(topics = "orders-post", groupId = "order-group")
    public void consumePOST(String postObject) {
        PlaceOrder placeOrder = new Gson().fromJson(postObject, PlaceOrder.class);
        if (Objects.nonNull(placeOrder)) {
            orderService.addOrder(placeOrder.getOrder(), Long.valueOf(placeOrder.getId()));
        }
    }

    @KafkaListener(topics = "orders-put", groupId = "order-group")
    public void consumePUT(String puttObject) {
        UpdateOrder updateOrder = new Gson().fromJson(puttObject, UpdateOrder.class);
        if (Objects.nonNull(updateOrder)) {
            orderService.updateOrder(Long.valueOf(updateOrder.getId()), updateOrder.getOrder());
        }
    }

    @KafkaListener(topics = "orders-delete", groupId = "order-group")
    public void consumeDELETE(String id) {
        orderService.deleteOrder(Long.valueOf(id));
    }
}
