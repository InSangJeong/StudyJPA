package study.jpa.Entity;

import lombok.*;
import study.jpa.Enum.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToOne  //Member FK 주인.
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)   //OrderItem의 Readonly
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member){
        if(this.member != null){
            this.member.getOrders().remove(this);
        }
        this.member = member;
        if(!member.getOrders().contains(this))//반복 호출 방지.
            member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        if(orderItem.getOrder() != this)//반복 호출 방지.
            orderItem.setOrder(this);
    }
}
