package ken.study.web.dto;

import ken.study.validation.annotation.ExistFoods;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class SignUpDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birthDate;
        @Size(min=13, max=13)
        String phoneNumber;
        @Size(min=5, max=50)
        String address;
        @Email
        String email;
        @NotBlank
        String password;
        @NotBlank
        String nickName;
        @ExistFoods
        List<Long> preferFoods;
    }
}
