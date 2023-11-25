package ken.study.converter;

import ken.study.domain.Member;
import ken.study.domain.common.type.GenderType;
import ken.study.web.dto.MemberRequestDTO;
import ken.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.SignUpResultDTO toSignUpResultDTO(Member member){
        return MemberResponseDTO.SignUpResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.SignUpDto request){
        GenderType gender = null;

        switch (request.getGender()){
            case 1:
                gender = GenderType.MALE;
                break;
            case 2:
                gender = GenderType.FEMALE;
                break;
            case 3:
                gender = GenderType.NONE;
                break;
        }

        return Member.builder()
                .name(request.getName())
                .nickName(request.getNickName())
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(gender)
                .birthDate(request.getBirthDate())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .memberFoodList(new ArrayList<>())
                .build();
    }
}
