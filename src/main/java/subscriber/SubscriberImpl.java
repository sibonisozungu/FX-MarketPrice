package subscriber;

import service.PubSubService;

public class SubscriberImpl extends Subscriber{
    @Override
    public void addSubscriber(String instrumentName, PubSubService pubSubService) {
        pubSubService.addSubscriber(instrumentName, this);
    }

    @Override
    public void unSubscribe(String instrumentName, PubSubService pubSubService) {
        pubSubService.removeSubscriber(instrumentName, this);
    }

    @Override
    public void getMessagesForSubscriberOfInstrument(String instrumentName, PubSubService pubSubService) {
        pubSubService.getMessagesForSubscriberOfInstrument(instrumentName, this);
    }
}
