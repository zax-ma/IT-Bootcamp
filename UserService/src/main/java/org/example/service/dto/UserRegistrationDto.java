package org.example.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.core.entity.RoleEntity;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class UserRegistrationDto {

    @JsonProperty("surname")
    @NotBlank
    @NotEmpty
    @Size(max = 40)
    @Pattern(regexp = "^\\w+")
    private String surname;

    @JsonProperty("name")
    @NotBlank
    @NotEmpty
    @Size(max = 20)
    @Pattern(regexp = "^\\w+")
    private String name;

    @JsonProperty("middle_name")
    @NotBlank
    @NotEmpty
    @Size(max = 40)
    @Pattern(regexp = "^\\w+")
    private String middle_name;

    @JsonProperty("email")
    @NotBlank
    @NotEmpty
    @Size(max = 50)
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")  //^[a-zA-Z0-9_!#$%&'*+/=?``{|}~^.-]+@[a-zA-Z0-9.-]+$
    private String email;

    @JsonProperty("role")
    @NotBlank
    @NotEmpty
    private String role;

    @ToString
    @NoArgsConstructor
    public static class UserBuilder{

        private String surname;
        private String name;
        private String middle_name;
        private String email;
        private String role;

        public static UserBuilder create(){
            return new UserBuilder();
        }

        public UserBuilder setSurname(String surname){
            this.surname = surname;
            return this;
        }

        public UserBuilder setName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder setMiddleName(String middle_name){
            this.middle_name = middle_name;
            return this;
        }

        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public UserBuilder setRole(String role){
            this.role = role;
            return this;
        }

        public UserRegistrationDto build(){
            return new UserRegistrationDto(surname, name, middle_name, email, role);
        }

    }


}
