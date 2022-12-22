package service;

import data.Message;
import subscriber.Subscriber;
import subscriber.SubscriberImpl;

import java.util.*;

public class PubSubService {

    Map<String, Set<Subscriber>> subscribersInstrumentMap = new HashMap<>();

    Queue<Message> messageQueue = new LinkedList<>();
    public void addMessageToQueue(Message message) {
        messageQueue.add(message);
    }

    public void addSubscriber(String instrumentName, Subscriber subscriber) {
        Set<Subscriber> subscribers;
        if(subscribersInstrumentMap.containsKey(instrumentName)){
            subscribers = subscribersInstrumentMap.get(instrumentName);
        }else{
            subscribers = new HashSet<>();
        }
        subscribers.add(subscriber);
        subscribersInstrumentMap.put(instrumentName,subscribers);
    }

    public void removeSubscriber(String instrumentName, Subscriber subscriber) {
        if(subscribersInstrumentMap.containsKey(instrumentName)){
            Set<Subscriber> subscribers = subscribersInstrumentMap.get(instrumentName);
            subscribers.remove(subscriber);
            subscribersInstrumentMap.put(instrumentName,subscribers);
        }
    }
    public void getMessagesForSubscriberOfInstrument(String instrumentName, Subscriber subscriber) {

        if(messageQueue.isEmpty()){
            System.out.println("No messages from publishers to display");
        }else{
            while(!messageQueue.isEmpty()){
                Message message = messageQueue.remove();
                if(message.getInstrumentName().equalsIgnoreCase(instrumentName)){

                    Set<Subscriber> subscribersOfInstrument = subscribersInstrumentMap.get(instrumentName);

                    for(Subscriber subscribers: subscribersOfInstrument){
                        //add broadcast message to subscriber message queue
                        List<Message> subscriberMessages = subscribers.getSubscriberMessages();
                        subscriberMessages.add(message);
                        subscribers.setSubscriberMessages(subscriberMessages);
                    }
                }

            }
        }
    }
    //Send messages about an instrument for subscriber at any point
    public void broadcast(){
        if(messageQueue.isEmpty()){
            System.out.println("No messages from publishers to display");
        }else{
            while(!messageQueue.isEmpty()){
                Message message = messageQueue.remove();
                String topic = "message.getTopic()";

                Set<Subscriber> subscribersOfInstrument = subscribersInstrumentMap.get(topic);

                for(Subscriber subscriber: subscribersOfInstrument){
                    List<Message> subscriberMessages = subscriber.getSubscriberMessages();
                    subscriberMessages.add(message);
                    subscriber.setSubscriberMessages(subscriberMessages);
                }
            }
        }
    }

    public void addCommission(List<Message> messages){

        for(Message message: messages){
            Message msg = new Message();
            msg = message;
            float bid = Float.parseFloat(message.getBid());
            float ask = Float.parseFloat(message.getAsk());

            float newPercentOfBId = (bid * (float)0.01);

            float newAsk = ask + newPercentOfBId;
            float newBid = bid - newPercentOfBId;

            msg.setBid(Float.toString(newBid));
            msg.setAsk(Float.toString(newAsk));
    System.out.println(msg.toString());
        }
    }
}
