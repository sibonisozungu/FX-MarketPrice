package publisher;

import data.Message;
import service.PubSubService;

import java.util.List;

public class PublisherImpl implements Publisher {
    @Override
    public void publish(Message message, PubSubService pubSubService) {
        pubSubService.addMessageToQueue(message);
    }

    @Override
    public void publishNewRates(List<Message> messages, PubSubService pubSubService) {
        pubSubService.addCommission(messages);
    }
}
