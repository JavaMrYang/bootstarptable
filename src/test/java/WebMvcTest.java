import com.tcloudata.controller.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @ClassName
 * @Description TODO
 * @Author LiuYang
 * @Date 2019/1/4/004 11:31
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class WebMvcTest {
    private MockMvc mockMvc;
    @Before
    public void setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

    @Test
    public void testIndexController(){
        RequestBuilder request=null;
        //request=request.buildRequest();

    }
}
