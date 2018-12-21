import com.tcloudata.MainApplication;
import com.tcloudata.domain.StudentDO;
import com.tcloudata.service.StudentService;
import com.tcloudata.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class StudentDaoTest {

    @Autowired
    private StudentServiceImpl studentService;
    @Before
    public void before(){

    }
    @Test
    public void test(){
        StudentDO studentDO=new StudentDO();
        studentDO.setName("张三");
        studentDO.setAge(24);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date=sdf.parse("1994-08-24 12:10:00");
            studentDO.setBirth(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        studentDO.setMajor("java");
        Arrays.asList("李四","王五","jack","mark").forEach(s->{
            studentDO.setName(s);
            studentService.insertStudent(studentDO);
        });
      // studentService.insertStudent(studentDO);
    }
}
