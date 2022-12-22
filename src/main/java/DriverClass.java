import data.Message;
import publisher.Publisher;
import publisher.PublisherImpl;
import service.PubSubService;
import subscriber.Subscriber;
import subscriber.SubscriberImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverClass {

    public static void main(String[] args) {

        Publisher pub1 = new PublisherImpl();
        Publisher pub2 = new PublisherImpl();

        Subscriber sub1 = new SubscriberImpl();
        Subscriber sub2 = new SubscriberImpl();

        PubSubService pubSubService = new PubSubService();

        Message message1 = getMessage("106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001");
        Message message2 = getMessage("107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002");
        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);

        pub1.publishNewRates(messages,pubSubService);

        pub1.publish(message1,pubSubService);
        pub2.publish(message2,pubSubService);

        sub1.addSubscriber("Test", pubSubService);
        sub2.addSubscriber("Test2", pubSubService);


    }

    public static Message getMessage(String msg){
        List<String> splitterMessage = new ArrayList<>(Arrays.asList(msg.split(",")));
        Message message = new Message();
        message.setUniqueId(splitterMessage.get(0));
        message.setInstrumentName(splitterMessage.get(1));
        message.setBid(splitterMessage.get(2));
        message.setAsk(splitterMessage.get(3));
        message.setTimestamp(splitterMessage.get(4));
        return message;
    }
}
