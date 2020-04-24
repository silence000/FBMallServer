import com.excmmy.RunProductsServer;
import com.excmmy.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // 加载配置文件，创建Spring容器，进行对象注入
@SpringBootTest(classes= {RunProductsServer.class}) // 指定RunUserBoot.class启动类
public class DBTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test1() {
        System.out.println(productMapper.getProductListByKeyword("鸡"));
    }
}
