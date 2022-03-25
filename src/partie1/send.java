package partie1;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory ; 

// importing JSON libraries
import org.json.simple.JSONObject;

public class send {
	private final static String QUEUE_NAME = "hello" ;
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try(Connection connection = factory.newConnection(); 
			Channel channel = connection.createChannel()) 
		{
			channel.queueDeclare(QUEUE_NAME,false,false, false,null);
			// send a JSON objet :
			// String message = "Hello World" ;
			JSONObject obj = new JSONObject();    
			
		      obj.put("name", new String("Hadil"));
		      obj.put("age", new Integer(21));
		      
			channel.basicPublish("",QUEUE_NAME,null,obj.toJSONString().getBytes());
			System.out.println(" [x] Sent '"+ obj.toJSONString()+"'");
		}
	}
}
