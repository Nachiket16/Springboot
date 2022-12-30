import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static  org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
public class CodeTest{

    @Test
    public void testSayHello(){
        Code code = new Code();
        assertEquals("Hello", code.Hello());
    }

}
