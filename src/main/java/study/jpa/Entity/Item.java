package study.jpa.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ORDER_ITEM_ID")
    private List<OrderItem> orderItems;

    private String name;
    private int price;
    private int stockQuantity;

}
