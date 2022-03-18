package study.jpa.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ORDER_ITEM")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;
/*
    @Column(name="ITEM_ID")
    private Long itemId;
    @Column(name="ORDER_ID")
    private Long orderId;
*/
    /*
    @OneToMany
    private List<Item> item;
    @OneToMany
    private List<Order> order;
    */
    private int orderPrice;
    private int count;

}
