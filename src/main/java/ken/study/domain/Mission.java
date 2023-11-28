package ken.study.domain;

import ken.study.domain.common.BaseEntity;
import ken.study.domain.common.status.MissionStatus;
import ken.study.domain.mapping.MemberMission;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(nullable = false, length = 50)
    private String content;

    private Integer reward;

    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'PENDING'")
    private MissionStatus status;

    @OneToMany(mappedBy="mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    public void setRestaurant(Restaurant restaurant){
        if(this.restaurant != null)
            restaurant.getMissionList().remove(this);
        this.restaurant = restaurant;
        restaurant.getMissionList().add(this);
    }

}
