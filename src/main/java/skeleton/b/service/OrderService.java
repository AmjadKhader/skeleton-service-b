package skeleton.b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skeleton.b.model.OrderEntity;
import skeleton.b.repo.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Transactional
    public void addOrder(String order, Long userId) {
        try {
            orderRepository.save(new OrderEntity(order, userId));
        } catch (Exception exception) {
            throw new RuntimeException("Error creating new order ...");
        }
    }

    @Transactional
    public void updateOrder(Long orderId, String order) {
        try {

            Optional<OrderEntity> user = orderRepository.findById(orderId);
            if (!user.isPresent()) {
                throw new RuntimeException("User was not found ...");
            }

            user.get().setOrderDescription(order);
            orderRepository.save(user.get());
        } catch (Exception exception) {
            throw new RuntimeException("Error updating order ...");
        }
    }

    @Transactional
    public void deleteOrder(Long OrderId) {
        try {
            orderRepository.deleteById(OrderId);
        } catch (Exception exception) {
            throw new RuntimeException("Error creating new user ...");
        }
    }

    public OrderEntity getOrder(Long orderId) {
        try {
            Optional<OrderEntity> order = orderRepository.findById(orderId);
            return order.orElse(null);
        } catch (Exception exception) {
            throw new RuntimeException("Error creating new user ...");
        }
    }


    public List<OrderEntity> getUserOrders(Long userId) {
        try {
            return orderRepository.findByUserId(userId);
        } catch (Exception exception) {
            throw new RuntimeException("Error creating new user ...");
        }
    }

}