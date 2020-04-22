import com.excmmy.RunUsersServer;
import com.excmmy.mapper.CartListMapper;
import com.excmmy.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // 加载配置文件，创建Spring容器，进行对象注入
@SpringBootTest(classes= {RunUsersServer.class}) // 指定RunUserBoot.class启动类
public class DBTest {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CartListMapper cartListMapper;

    @Test
    public void test1() {
        System.out.println("Hello SpringCloud");
    }

    @Test
    public void test2() {
        System.out.println(usersMapper.getUserByUsernameAndUserpass("excmmy1", "exc123"));
    }

    @Test
    public void test3() {
        System.out.println(cartListMapper.getCartListByUserId(1));
    }
}
