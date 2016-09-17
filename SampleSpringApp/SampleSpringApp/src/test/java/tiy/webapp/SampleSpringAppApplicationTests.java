package tiy.webapp;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleSpringAppApplicationTests {

//	@Test
//	public void testSendMessage() throws Exception {
//		Connection conn = DriverManager.getConnection(WebChatClient.CLIENT_URL);
//
//		String todoText = "Test Message";
//
//		WebChatClient client = new WebChatClient();
//
//		client.sendMessage("text from client");
//
//		// make sure we can retrieve the todo we just created
//		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM todos where text = ?");
//		stmt.setString(1, todoText);
//		ResultSet results = stmt.executeQuery();
//		assertNotNull(results);
//		// count the records in results to make sure we get what we expected
//		int numResults = 0;
//		while (results.next()) {
//			numResults++;
//		}
//
//		assertEquals(1, numResults);
//
//		todoDatabase.deleteToDo(conn, todoText);
//		// make sure we remove the test user we added earlier
//		todoDatabase.deleteUser(conn, username);
//
//		// make sure there are no more records for our test todo
//		results = stmt.executeQuery();
//		numResults = 0;
//		while (results.next()) {
//			numResults++;
//		}
//		assertEquals(0, numResults);
//	}
//	assertEquals(0, numResults);
//	@Test
//	public void contextLoads() {
//	}

}
