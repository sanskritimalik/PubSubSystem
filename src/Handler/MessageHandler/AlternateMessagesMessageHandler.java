package Handler.MessageHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import PubSub.PubSub;
import Subscriber.Subscriber;

public class AlternateMessagesMessageHandler implements MessageHandler {
    private final PubSub pubSub;
    private int alternateCounter = 0;
    public AlternateMessagesMessageHandler(PubSub pubSub) {
        this.pubSub = pubSub;
    }

    @Override
    public void handleMessages() {
        Set<Subscriber> subscribers = pubSub.getSubscribers();
        int numSubscribers = subscribers.size();
        if (numSubscribers == 0) {
            return;
        }

        List<Subscriber> activeSubscribers = new ArrayList<>(subscribers);
        Collections.reverse(activeSubscribers);
        while (true) {
            int message = pubSub.getMessage();
            Subscriber subscriber = activeSubscribers.get(alternateCounter % numSubscribers);
            alternateCounter++;
            subscriber.receiveMessage(message);
        }
    }
}