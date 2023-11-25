package ken.study.domain.mapping;

import ken.study.domain.Food;
import ken.study.domain.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberFoodList().remove(this);
        this.member = member;
        member.getMemberFoodList().add(this);
    }

    public void setFood(Food food){
        this.food = food;
    }

}
