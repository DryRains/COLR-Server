package ken.study.web.controller;

import ken.study.apiPayload.ApiResponse;
import ken.study.converter.MemberConverter;
import ken.study.domain.Member;
import ken.study.service.MemberService.MemberCommandService;
import ken.study.web.dto.MemberRequestDTO;
import ken.study.web.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/signUp")
    public ApiResponse<MemberResponseDTO.SignUpResultDTO> join(@RequestBody @Valid MemberRequestDTO.SignUpDto request){
        Member member = memberCommandService.signUpMember(request);
        return ApiResponse.onSuccess(MemberConverter.toSignUpResultDTO(member));
    }
}
