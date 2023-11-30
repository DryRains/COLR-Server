package ken.study.apiPayload.code.status;

import ken.study.apiPayload.code.BaseErrorCode;
import ken.study.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // General Error Response (barely used)
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "권한이 없습니다."),

    // Member Error
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4004", "사용자가 없습니다."),

    // Restaurant Error
    RESTAURANT_NOT_FOUND(HttpStatus.NOT_FOUND, "RESTAURANT4004", "식당이 없습니다." ),

    // Review Error
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW4004", "리뷰가 없습니다."),

    // Test Error
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트용 임시 에러입니다."),

    // Food Error
    FOOD_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD4004", "음식 카테고리가 없습니다."),

    // Mission Error
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4004", "미션이 없습니다."),
    MISSION_NOT_ACTIVE(HttpStatus.BAD_REQUEST, "MISSION4000", "이용 가능한 미션이 아닙니다."),
    MISSION_ALREADY_IN_PROGRESS(HttpStatus.BAD_REQUEST, "MISSION4000_1", "해당 유저가 이미 진행중인 미션입니다."),

    // Owner Error
    OWNER_TOKEN_NOT_VALID(HttpStatus.FORBIDDEN, "OWNER4003", "인가된 가게 주인의 토큰이 아닙니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
