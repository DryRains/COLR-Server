package ken.study.web.controller;

import com.google.common.net.HttpHeaders;
import io.swagger.v3.oas.annotations.Operation;
import ken.study.apiPayload.ApiResponse;
import ken.study.converter.MissionConverter;
import ken.study.domain.Mission;
import ken.study.service.MissionService.MissionCommandService;
import ken.study.validation.annotation.ExistRestaurant;
import ken.study.web.dto.MissionRequest;
import ken.study.web.dto.MissionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class MissionController {

    private final MissionCommandService missionCommandService;

    @Operation(summary = "[가게 주인] 미션 생성", description = "가게 주인이 자신의 특정 가게에 미션을 생성합니다.")
    @PostMapping("/restaurants/{restaurantId}/missions")
    public ApiResponse<MissionResponse.CreateMissionResultDTO> createMission(@ExistRestaurant @PathVariable("restaurantId") Long restaurantId,
                                                                             @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                             @RequestBody @Valid MissionRequest.CreateMissionDto request){
        Mission mission = missionCommandService.createMission(restaurantId, token, request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }
}
