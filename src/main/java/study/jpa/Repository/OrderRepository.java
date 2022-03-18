package study.jpa.Repository;

import org.springframework.data.repository.CrudRepository;
import study.jpa.Entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {}
