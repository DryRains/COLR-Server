package ken.study.web.controller;

import com.google.common.net.HttpHeaders;
import io.swagger.v3.oas.annotations.Operation;
import ken.study.apiPayload.ApiResponse;
import ken.study.converter.MemberMissionConverter;
import ken.study.domain.mapping.MemberMission;
import ken.study.service.MemberMissionService.MemberMissionCommandService;
import ken.study.web.dto.MemberMissionRequest;
import ken.study.web.dto.MemberMissionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/missions")
public class MemberMissionController {

   private final MemberMissionCommandService memberMissionCommandService;

    @Operation(summary = "[회원] 미션 수락", description = "회원이 요청한 missionId에 해당하는 미션을 수락합니다.")
    @PostMapping
    public ApiResponse<MemberMissionResponse.AcceptMissionResultDTO> acceptMission(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                                   @Valid @RequestBody MemberMissionRequest.AcceptMissionDto request){
        MemberMission memberMission = memberMissionCommandService.acceptMission(token, request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAcceptMissionResultDTO(memberMission));
    }
}
