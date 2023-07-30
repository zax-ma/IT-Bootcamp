import org.example.core.DataEngineBoot;
import org.example.core.entity.RoleEntity;
import org.example.core.repo.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DataEngineBoot.class)
public class RoleEntityTest {

    @Autowired
    RoleRepository repo;

    @Test
    public void findByNameTest(){

        RoleEntity role = repo.findByName("ADMINISTRATOR");
        System.out.println(role);

        try {
            role = repo.findByName("ADMINISTRATOR");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(role);
    }


}
