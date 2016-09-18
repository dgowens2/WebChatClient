package tiy.webapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleSpringAppApplicationTests {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
	public void testSendMessage() throws Exception {
        String clientText = "Test Message";

        WebChatClient testClient = new WebChatClient();
        System.out.println("Client initialized");

//        testClient.sendMessage("xx " + clientText);
        testClient.sendMessage(clientText);

        System.out.println("text of client test: " + clientText);
        System.out.println("text of server response: " + testClient.serverResponse);

        assertEquals(clientText, testClient.serverResponse);
	}
}
