package study.jpa.Entity;

import lombok.Getter;
import study.jpa.Enum.DeliveryStatus;

import javax.persistence.*;

@Entity
@Getter
public class Delivery {

    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")    //Order와 1:1 매핑.
    private Order order;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void setOrder(Order order){
        this.order = order;

        if(order.getDelivery() != this)
            order.setDelivery(this);
    }

}
