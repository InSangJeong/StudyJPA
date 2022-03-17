package study.jpa.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//자동생성
    /*
     IDENTITY   : Insert후에 기본키 값을 조회 가능.
     SEQUENCE   : DB에서 지원하는 SEQUENCE를 사용(H2, Oracle, Postgresql)특정시퀀스로 ID값 설정할수 있도록 가능
     TABlE      : SEQUENCE랑 비슷한데 이건 여기에 클래스를 만들어서 적용하므로 모든 DB에 가능함
     Auto       : DB 방언에 따라 위 3개중 하나를 골라서 적용
     */
    private Long id;
}
