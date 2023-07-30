import org.example.core.DataEngineBoot;
import org.example.core.entity.RoleEntity;
import org.example.core.entity.UserEntity;
import org.example.core.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(classes = DataEngineBoot.class)
public class UserEntityTest {

    @Autowired
    UserRepository repo;

    @Test
    public void saveUserTest(){


        UserEntity user = new UserEntity("zaxarevich",
                "maria",
                "aleksandrovna",
                "maria@mail.com",
                new RoleEntity("1437a54b-2c77-42ff-84c1-aca35378045f","ADMINISTRATOR"),
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
