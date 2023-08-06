import Handler.MessageHandlerFactory.AlternateMessagesMessageHandlerFactory;
import Handler.MessageHandlerFactory.AtLeastNMessageHandlerFactory;
import Handler.MessageHandlerFactory.AtMostNMessageHandlerFactory;
import PubSub.PubSub;
import Subscriber.Subscriber;

public class App {
    public static void main(String[] args) throws Exception {
        PubSub pubSub;

        // Test At least n pattern
        pubSub = new PubSub(new AtLeastNMessageHandlerFactory(2));
        testPubSub(pubSub);
        System.out.println("Executed At Least N handler");

        // Test At most n pattern
        pubSub = new PubSub(new AtMostNMessageHandlerFactory(2));
        testPubSub(pubSub);
        System.out.println("Executed At Most N handler");
        
        // Test Alternate messages only pattern
        pubSub = new PubSub(new AlternateMessagesMessageHandlerFactory());
        testPubSub(pubSub);
        System.out.println("Executed Alternate Message handler");
    }
     private static void testPubSub(PubSub pubSub) {
        Subscriber subscriberA = message -> System.out.println("Subscriber A received message: " + message);
        Subscriber subscriberB = message -> System.out.println("Subscriber B received message: " + message);
        Subscriber subscriberC = message -> System.out.println("Subscriber C received message: " + message);

        pubSub.subscribe(subscriberA);
        pubSub.subscribe(subscriberB);
        pubSub.subscribe(subscriberC);

            // Start the message handler
        pubSub.startMessageHandler();

        for (int i = 1; i <= 10; i++) {
            pubSub.publish(i);
            sleep(1000); // Sleep for 1 second between each message
        }
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
