import org.example.core.DataEngineBoot;
import org.example.core.entity.RoleEntity;
import org.example.core.entity.UserEntity;
import org.example.core.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest(classes = DataEngineBoot.class)
public class UserEntityTest {

    @Autowired
    UserRepository repo;

    @Test
    public void saveUserTest(){

        Set<RoleEntity> roles = new HashSet<>();
        roles.add(new RoleEntity("e6907099-d6c7-4c34-941b-8607d7943284","ADMINISTRATOR"));

        UserEntity user = new UserEntity("e6907022-d6c7-4c34-941b-8607d7943284","zaxarevich",
                "maria",
                "aleksandrovna",
                "maria@mail.com",
                new RoleEntity("e6907099-d6c7-4c34-941b-8607d7943284","ADMINISTRATOR"),
                LocalDateTime.now(),
                LocalDateTime.now());

        repo.save(user);
    }

    @Test
    public void existByMailTest(){

        boolean exist = false;
        exist = repo.existsByEmail("maria@mail.com");

        Assertions.assertTrue(exist);

    }

    @Test
    public void findByEmailTest(){
        UserEntity user = repo.findByEmail("maria@mail.com");
        System.out.println(user);
    }

}
