package partie1;

import java.io.IOException;

import com.rabbitmq.client.Delivery;

@FunctionalInterface
public interface DeliverCallback {
	void hadle(String consumerTag , Delivery message) throws IOException ;
	
}
