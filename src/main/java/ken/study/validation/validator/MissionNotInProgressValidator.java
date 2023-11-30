package ken.study.validation.validator;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.apiPayload.exception.handler.MissionHandler;
import ken.study.domain.Member;
import ken.study.domain.Mission;
import ken.study.domain.common.status.MemberMissionStatus;
import ken.study.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MissionNotInProgressValidator {

    private final MemberMissionRepository memberMissionRepository;

    public void validate(Member member, Mission mission){
        if (memberMissionRepository.existsByMemberAndMissionAndStatus(member, mission, MemberMissionStatus.STARTED)) {
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_IN_PROGRESS);
        }
    }
}

