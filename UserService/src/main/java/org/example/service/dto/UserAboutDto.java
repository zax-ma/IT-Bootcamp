package org.example.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
public class UserAboutDto {

    @JsonProperty("fio")
    private String fio;

    @JsonProperty("email")
    private String email;

    @JsonProperty("role")
    private String role;

}
