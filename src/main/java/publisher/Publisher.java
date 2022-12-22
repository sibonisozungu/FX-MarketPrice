package publisher;

import data.Message;
import service.PubSubService;

import java.util.List;

public interface Publisher {
    void publish(Message message, PubSubService pubSubService);
    void publishNewRates(List<Message> messages, PubSubService pubSubService);
}
