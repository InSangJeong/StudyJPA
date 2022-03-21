package study.jpa.Entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="ITEM_ID") //FK를 관리하므로 양방향 매핑시 주인이 된다.
    private Item item;

    @ManyToOne
    @JoinColumn(name="ORDER_ID") //FK를 관리하므로 양방향 매핑시 주인이 된다.
    private Order order;

    private int orderPrice;
    private int count;

    public void setItem(Item Item){
        this.item = Item;
        if(!item.getOrderItems().contains(this))
            item.addOrderItem(this);
    }

    public void setOrder(Order order){
        this.order = order;
        if(!order.getOrderItems().contains(this))
            order.addOrderItem(this);
    }
}
