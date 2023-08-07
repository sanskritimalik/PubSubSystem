package Handler.MessageHandler;

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
            for (Subscriber subscriber : pubSub.getSubscribers()) {
                subscriber.receiveMessage(message);
                count++;
                if (count >= n) {
                    break;
                }
            }
        }
    }
}