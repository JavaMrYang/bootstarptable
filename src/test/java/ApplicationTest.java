import com.tcloudata.MainApplication;
import com.tcloudata.config.BlogProperties;
import com.tcloudata.properties.JedisProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName
 * @Description TODO
 * @Author LiuYang
 * @Date 2019/1/4/004 9:59
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ApplicationTest {
    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.printf("%s,%s",blogProperties.getName(),blogProperties.getTitle());
        Class c=blogProperties.getClass();
        Field[] fields=c.getDeclaredFields();
        for (Field field:fields){
            String fieldName=field.getName();
            String tmpName=fieldName.substring(0,1);
            String methodName="get"+tmpName.toUpperCase()+fieldName.substring(1);
            Method method=c.getMethod(methodName,new Class<?>[]{});
            Object obj=method.invoke(blogProperties);
            System.out.printf("属性名:%s,属性值:%s \n",field.getName(),obj.toString());
        }
        //System.out.println(blogProperties.);
       // System.out.println(jedisProperties.getHost());
        Assert.assertEquals(blogProperties.getName(),"程序猿DD");
        Assert.assertEquals(blogProperties.getTitle(),"springboot teach");
    }
}
