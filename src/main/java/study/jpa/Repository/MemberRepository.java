package study.jpa.Repository;

import org.springframework.data.repository.CrudRepository;
import study.jpa.Entity.Member;


public interface MemberRepository extends CrudRepository<Member, String> {


}
