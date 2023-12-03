package ken.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import ken.study.apiPayload.ApiResponse;
import ken.study.converter.MemberConverter;
import ken.study.domain.Member;
import ken.study.service.MemberService.MemberCommandService;
import ken.study.web.dto.MemberRequest;
import ken.study.web.dto.MemberResponse;
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

    @Operation(summary = "회원 가입", description = "요구되는 정보들을 기입하여 회원 가입합니다.")
    @PostMapping("/signUp")
    public ApiResponse<MemberResponse.SignUpResultDTO> signUp(@RequestBody @Valid MemberRequest.SignUpDTO request){
        Member member = memberCommandService.signUpMember(request);
        return ApiResponse.onSuccess(MemberConverter.toSignUpResultDTO(member));
    }
}
