package org.example.service.helpers;

import lombok.ToString;
import org.example.core.entity.UserEntity;
import org.example.service.dto.UserAboutDto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoConverter implements Converter<UserEntity, UserAboutDto> {

    @Override
    public UserAboutDto convert(UserEntity source) {

        return new UserAboutDto(
                source.getSurname() + " " + source.getName() + " " + source.getMiddle_name(),
                source.getEmail(),
                source.getRole().getName());
    }
}
