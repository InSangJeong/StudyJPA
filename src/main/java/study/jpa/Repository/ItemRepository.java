package study.jpa.Repository;


import org.springframework.data.repository.CrudRepository;
import study.jpa.Entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {}

