package org.example.service.config;

import org.example.core.entity.UserEntity;
import org.example.core.repo.RoleRepository;
import org.example.service.dto.UserAboutDto;
import org.example.service.dto.UserRegistrationDto;
import org.example.service.helpers.DtoToEntityConverter;
import org.example.service.helpers.EntityToDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

public class ConverterConfig {

    @Bean
    public Converter<UserRegistrationDto, UserEntity> userDtoToEntityConverter(){
        return new DtoToEntityConverter();
    }

    @Bean
    public Converter<UserEntity, UserAboutDto> userEntityToDtoConverter(){
        return new EntityToDtoConverter();
    }

}
