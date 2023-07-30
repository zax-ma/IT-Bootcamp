package org.example.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.core.entity.UserEntity;
import org.example.service.api.IUserService;
import org.example.service.dto.PageDto;
import org.example.service.dto.UserAboutDto;
import org.example.service.dto.UserRegistrationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final IUserService service;

    private final Converter<UserRegistrationDto, UserEntity> converter;

    public UserController(IUserService service, Converter<UserRegistrationDto, UserEntity> converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<?> create(@RequestBody UserRegistrationDto dto){
        log.info("Request for new user creation");
        UserEntity newUser = this.converter.convert(dto);
        service.saveUser(newUser);
        return ResponseEntity
                .status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/info")
    public ResponseEntity<Page<UserAboutDto>> getUserInfo(@PageableDefault(page = 0,
                                                                size = 10,
                                                                sort = "email",
                                                                direction = Sort.Direction.ASC) Pageable pageable){
        log.info("Request for user info");
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserPage(pageable));
    }
}
