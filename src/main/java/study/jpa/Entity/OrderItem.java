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

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;

    private int orderPrice;
    private int count;

    public void setItem(Item Item){
        this.item = Item;

    }

}
