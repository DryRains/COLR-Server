package ken.study.repository;

import ken.study.domain.Member;
import ken.study.domain.Mission;
import ken.study.domain.common.status.MemberMissionStatus;
import ken.study.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberAndMissionAndStatus(Member member, Mission mission, MemberMissionStatus memberMissionStatus);
}
