package Handler.MessageHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import PubSub.PubSub;
import Subscriber.Subscriber;

public class AtMostNMessageHandler implements MessageHandler {
    private final PubSub pubSub;
    private final int n;

    public AtMostNMessageHandler(PubSub pubSub,int n) {
        this.pubSub = pubSub;
        this.n = n;
    }

    @Override
    public void handleMessages() {
        while (true) {
            int message = pubSub.getMessage();
            int count = 0;
            List<Subscriber> subscribers = new ArrayList<>(pubSub.getSubscribers());
            Collections.reverse(subscribers);
            for (Subscriber subscriber : subscribers) {
                subscriber.receiveMessage(message);
                count++;
                if (count >= n) {
                    break;
                }
            }
        }
    }
}