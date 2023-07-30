import org.example.core.DataEngineBoot;
import org.example.core.entity.RoleEntity;
import org.example.core.entity.UserEntity;
import org.example.core.repo.RoleRepository;
import org.example.core.repo.UserRepository;
import org.example.service.dto.UserAboutDto;
import org.example.service.dto.UserRegistrationDto;
import org.example.service.helpers.DtoToEntityConverter;
import org.example.service.helpers.EntityToDtoConverter;
import org.example.service.helpers.FieldHelper;
import org.example.service.impl.RoleService;
import org.example.service.impl.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(classes = DataEngineBoot.class)
public class UserTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    Converter<UserRegistrationDto, UserEntity> converterTo;

    Converter<UserEntity, UserAboutDto> converterFrom;


    UserService userService;
    RoleService roleService;

    @BeforeEach
    void init(){
        userService = new UserService(userRepository, converterFrom);
        converterTo = new DtoToEntityConverter();
        converterFrom = new EntityToDtoConverter();
        roleService = new RoleService(roleRepository);
    }


    @Test
    public void userCreationTest() {

        UserRegistrationDto newUser = new UserRegistrationDto("hello", "world", "java", "java@mail.com", "Administrator");

        String normalizedRole = normalize(newUser);

        FieldHelper helper = new FieldHelper();

        UserEntity user = new UserEntity(
                newUser.getSurname(),
                newUser.getName(),
                newUser.getMiddle_name(),
                newUser.getEmail(),
                roleService.getRole(normalizedRole),
                helper.getDt_create(),
                helper.getDt_update());

        System.out.println(user);

        System.out.println(converterFrom.convert(new UserEntity("java", "hello", "world", "java@mail.com",
                new RoleEntity("19290144", "ADMINISTRATOR"), LocalDateTime.now(), LocalDateTime.now())));

        userService.saveUser(user);

    }
    public static String normalize(UserRegistrationDto dto){
        return dto.getRole().toUpperCase().replace(" ", "_");
    }

    @Test
    public void findAllUsersTest(){
        List<UserEntity> users = this.userRepository.findAll();
        System.out.println(users.stream()
                .map(converterFrom::convert)
                .toList());
    }

}
