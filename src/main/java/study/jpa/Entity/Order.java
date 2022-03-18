package study.jpa.Entity;

import lombok.*;
import study.jpa.Enum.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ORDER_ITEM_ID")
    private List<OrderItem> orderItems;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
