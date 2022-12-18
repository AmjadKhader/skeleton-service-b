package skeleton.b.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "order_details")
@NoArgsConstructor
public class OrderEntity implements Serializable {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "order_description")
    private String orderDescription;

    @Column(name = "user_id")
    private Long userId;

    public OrderEntity(String orderDescription, Long userId) {
        this.orderDescription = orderDescription;
        this.userId = userId;
    }
}
