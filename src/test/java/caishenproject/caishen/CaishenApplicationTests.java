package caishenproject.caishen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaishenApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void tets1(){
       assertThat(1,is(1));
    }

}
