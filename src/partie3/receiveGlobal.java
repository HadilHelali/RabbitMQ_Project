package partie3;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory ; 
import com.rabbitmq.client.GetResponse;

public class receiveGlobal {
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection(); 
		
		Channel MQ1 = connection.createChannel();
		Channel MQ2 = connection.createChannel();
		
		GetResponse response = MQ1.basicGet("MQ1" , true);
		if(response == null) {
			GetResponse response2 = MQ2.basicGet("MQ2" , true);
			String message2 = new String(response2.getBody(),"UTF-8");
			System.out.println(message2);
			System.out.println(" [x] Receive section 2 '" + message2);
		}
		else {
			String message = new String(response.getBody(),"UTF-8");
			System.out.println(message);
			System.out.println(" [x] Receive section 1 '" + message);

		}
	}
	}