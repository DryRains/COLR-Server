package ken.study.service.MemberMissionService;

import ken.study.apiPayload.code.status.ErrorStatus;
import ken.study.apiPayload.exception.handler.MemberHandler;
import ken.study.apiPayload.exception.handler.MissionHandler;
import ken.study.domain.Member;
import ken.study.domain.Mission;
import ken.study.domain.mapping.MemberMission;
import ken.study.repository.MemberMissionRepository;
import ken.study.repository.MemberRepository;
import ken.study.repository.MissionRepository;
import ken.study.validation.validator.MissionNotInProgressValidator;
import ken.study.web.dto.MemberMissionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    private final MissionNotInProgressValidator missionNotInProgressValidator;

    @Override
    @Transactional
    public MemberMission acceptMission(String token, MemberMissionRequest.AcceptMissionDto request) {

        //(임시) token -> member validation
        Long memberId = Long.parseLong(token);
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        missionNotInProgressValidator.validate(member, mission);

        MemberMission memberMission = MemberMission.builder().build();
        memberMission.setMember(member);
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
    }
}
