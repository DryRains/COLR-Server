package ken.study.service.MemberMissionService;

import ken.study.domain.mapping.MemberMission;
import ken.study.web.dto.MemberMissionRequest;

public interface MemberMissionCommandService {
    MemberMission acceptMission(String token, MemberMissionRequest.AcceptMissionDto request);
}
