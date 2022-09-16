import com.adtec.crowd.entity.po.OrderPO;
import com.adtec.crowd.mapper.OrderPOMapper;
import com.adtec.crowd.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-ex.xml"})

public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private OrderPOMapper orderPOMapper;
    @Autowired
    private OrderService orderService;

    @Test
    public void test() throws SQLException {
        OrderPO orderPO = new OrderPO(746, "xxxx", "xxxx", 5.0, 45, "x", "x", "x");
        orderPOMapper.insert(orderPO);
    }
    @Test
    public void testTx(){
        OrderPO orderPO = new OrderPO(969, "xxxx", "xxxx", 5.0, 45, "x", "x", "x");
        orderService.saveOrder(orderPO);
    }

}