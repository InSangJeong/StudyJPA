package study.jpa.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jpa.Entity.Member;
import study.jpa.Entity.Order;
import study.jpa.Entity.OrderItem;
import study.jpa.Enum.OrderStatus;
import study.jpa.Service.MemberService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    MemberService memberService;

    public HelloController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
    @GetMapping("/sample1")
    public String tryCRUD(){
        List<OrderItem> orderItems = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        OrderItem orderItem = OrderItem.builder()
                .orderPrice(1000)
                .count(1)
                .build();

        orderItems.add(orderItem);


        Order order = Order.builder()
                .orderItems(orderItems)
                .status(OrderStatus.ORDER)
                .build();
        orders.add(order);

        Member member = Member.builder()
                .name("Test").street("11st").orders(orders).city("Seoul").build();


        order.setMember(member);
        order.addOrderItem(orderItem);

        memberService.addMember(member);

        return "done";
    }
}
