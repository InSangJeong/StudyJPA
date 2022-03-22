package study.jpa.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<Category>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public void addOrderItem(OrderItem orderItem){
        // FK관리는 OrderItem 클래스가 한다.
        this.orderItems.add(orderItem); //Readonly
        if(orderItem.getItem() != this)// 반복호출 막기위해 확인.
            orderItem.setItem(this);   //연관관계 저장을 위해서 Owner에게 추가한다.
    }

}
