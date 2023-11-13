package ken.study.domain.mapping;


import ken.study.domain.Member;
import ken.study.domain.Mission;
import ken.study.domain.common.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'STARTED'")

    private LocalDateTime completedAt;

}
