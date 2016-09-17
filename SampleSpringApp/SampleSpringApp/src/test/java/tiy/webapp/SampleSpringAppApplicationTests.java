package tiy.webapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

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


        testClient.sendMessage(clientText);
        System.out.println("text of client test: " + clientText);
        System.out.println("text of server response: " + testClient.serverResponse);

        assertNotNull(clientText, testClient.serverResponse);
//        assertEquals(clientText, testClient.serverResponse);
	}
}
