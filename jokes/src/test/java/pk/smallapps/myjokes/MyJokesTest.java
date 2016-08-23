package pk.smallapps.myjokes;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.IOException;

public class MyJokesTest extends TestCase{
    @Test
    public void testfile(){
        MyJokes myJokes = new MyJokes();
        try {
            myJokes.getRandomJoke();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}