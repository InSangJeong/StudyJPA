package study.jpa.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.jpa.Enum.RoleType;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="MEMBER")
@Getter
@Setter
@NoArgsConstructor
@Access(AccessType.FIELD) // JPA가 필드에 직접 접근한다. PROPERTY로 설정시 Getter를 사용해서만 접근한다.
public class Member {

    @Id
    @Column(name="ID")
    private String id;
    @Column(name="NAME", nullable = false, length = 10)
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)//Enum 이름을 DB에 저장. ORDINAL 설정시 순서로 저장.
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob    //길이 제한이 없음.
    private String description;

    //@Transient    매핑안함. 객체에 임시로 값 저장할때 사용.


}
