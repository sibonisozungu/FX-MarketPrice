package subscriber;

import data.Message;
import service.PubSubService;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {

    private List<Message> subscriberMessages = new ArrayList<>();

    public List<Message> getSubscriberMessages() {
        return subscriberMessages;
    }

    public void setSubscriberMessages(List<Message> subscriberMessages) {
        this.subscriberMessages = subscriberMessages;
    }

    public abstract void addSubscriber(String instrumentName, PubSubService pubSubService);

    public abstract void unSubscribe(String instrumentName, PubSubService pubSubService);

    public abstract void getMessagesForSubscriberOfInstrument(String instrumentName, PubSubService pubSubService);

    public void printMessages(){
        for(Message message : subscriberMessages){
            System.out.println("Message Instrument -> "+message.getInstrumentName());
        }
    }
}
