package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {

    @Test
    public void test1(){
        fail();
    }


    @Test
    public void test2(){
        int x = 2/0;
    }

    @Test
    public void test3(){
        try{
            fail();
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
}
