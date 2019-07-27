import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/applicationContext.xml")
public class TestDemo {

    @Test
    public void run1(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String admin = passwordEncoder.encode("user");
        System.out.println(admin);
    }
}
