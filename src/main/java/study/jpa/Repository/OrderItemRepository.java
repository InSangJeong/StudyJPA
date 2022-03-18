package study.jpa.Repository;

import org.springframework.data.repository.CrudRepository;
import study.jpa.Entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {}
