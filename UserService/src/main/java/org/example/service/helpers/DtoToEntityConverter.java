package org.example.service.helpers;

import lombok.NoArgsConstructor;
import org.example.core.entity.RoleEntity;
import org.example.core.entity.UserEntity;
import org.example.core.repo.RoleRepository;
import org.example.service.dto.UserRegistrationDto;

import org.example.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@NoArgsConstructor
public class DtoToEntityConverter implements Converter<UserRegistrationDto, UserEntity> {
    @Autowired
    private RoleService service;

    @Override
    public UserEntity convert(UserRegistrationDto source) {

        String normalizedRole = normalize(source);

        FieldHelper helper = new FieldHelper();

        return new UserEntity(
                helper.getUuid().toString(),
                source.getSurname(),
                source.getName(),
                source.getMiddle_name(),
                source.getEmail(),
                service.getRole(normalizedRole),
                helper.getDt_create(),
                helper.getDt_update());
    }

    public static String normalize(UserRegistrationDto dto){
        return dto.getRole().toUpperCase().replace(" ", "_");
    }



}
