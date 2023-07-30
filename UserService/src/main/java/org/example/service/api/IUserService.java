package org.example.service.api;

import org.example.core.entity.UserEntity;
import org.example.service.dto.UserAboutDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    void saveUser(UserEntity userEntity);

    Page<UserAboutDto> getUserPage(Pageable page);

    List<UserAboutDto> findAllUsers();


}
