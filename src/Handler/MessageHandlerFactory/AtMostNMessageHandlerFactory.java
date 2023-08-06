package Handler.MessageHandlerFactory;

import Handler.MessageHandler.AtMostNMessageHandler;
import Handler.MessageHandler.MessageHandler;
import PubSub.PubSub;

public class AtMostNMessageHandlerFactory implements MessageHandlerFactory {
    private int n;

    public AtMostNMessageHandlerFactory(int n) {
        this.n = n;
    }

    @Override
    public MessageHandler createMessageHandler(PubSub pubSub) {
        return new AtMostNMessageHandler(pubSub, n);
    }
}