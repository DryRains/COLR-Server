package ken.study.service.MemberService;

import ken.study.domain.Member;
import ken.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member signUpMember(MemberRequestDTO.SignUpDto request);
}
