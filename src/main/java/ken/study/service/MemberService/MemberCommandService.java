package ken.study.service.MemberService;

import ken.study.domain.Member;
import ken.study.web.dto.MemberRequest;

public interface MemberCommandService {
    Member signUpMember(MemberRequest.SignUpDTO request);
}
