package Handler.MessageHandler;

import PubSub.PubSub;
import Subscriber.Subscriber;

public class AtLeastNMessageHandler implements MessageHandler {
    private final PubSub pubSub;
    private final int n;

    public AtLeastNMessageHandler(PubSub pubSub, int n) {
        this.pubSub = pubSub;
        this.n = n;
    }

    @Override
    public void handleMessages() {
        while (true) {
            int message = pubSub.getMessage();
            if (pubSub.getSubscribers().size() >= n) {
                for (Subscriber subscriber : pubSub.getSubscribers()) {
                    subscriber.receiveMessage(message);
                }
            }
        }
    }
}