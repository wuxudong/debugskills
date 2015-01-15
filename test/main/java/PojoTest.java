import com.mrkid.entity.Pojo;
import com.mrkid.service.PojoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-persist.xml", "/application-context.xml"})
public class PojoTest {
    @Autowired
    private PojoService pojoService;

    @Test
    @Transactional
    @Rollback(value = false)
    public void test() {
        Pojo pojo = new Pojo();
        pojo.setId(36l);

        pojo.setName("yes");

        pojoService.save(pojo);


    }


}