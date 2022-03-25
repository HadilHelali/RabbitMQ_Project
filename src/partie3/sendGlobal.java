package partie3;

import com.rabbitmq.client.Connection;

import org.json.simple.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory ; 


public class sendGlobal {

		private final static String QUEUE_NAME = "TextGlobal" ;
		
		public static void main(String[] args) throws Exception {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			try(Connection connection = factory.newConnection(); 
				Channel channel = connection.createChannel()) 
			{
				channel.queueDeclare(QUEUE_NAME,false,false, false,null);
				JSONObject obj = new JSONObject();    
				
			      obj.put("Text", "Hello Section 2");
			      obj.put("Section", 2);
			      
				channel.basicPublish("",QUEUE_NAME,null,obj.toJSONString().getBytes());
				System.out.println(" [x] Sent '"+ obj.toJSONString()+"'");
			}
		}
	}
