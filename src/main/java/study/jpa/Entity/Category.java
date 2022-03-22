package study.jpa.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id @GeneratedValue
    @Column(name="CATEGORY_ID")
    private Long id;

    private String name;

    @ManyToMany     //개인적으로 중간 엔티티를 따로 생성해서 1:다 로 관리하는게 더 나아보임.
    @JoinTable(name = "CATEGORY_ITEM",//양방향 ManyToMany 매핑을 위해 중간 테이블을 생성하고 양쪽 ID 입력
    joinColumns = @JoinColumn(name="CATEGORY_ID"),
    inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<Item>();

    //카테고리 계층구조 구성 필드
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<Category>();

    //연관관계 메소드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }

    public void addItem(Item item){
        this.items.add(item);
    }

}
