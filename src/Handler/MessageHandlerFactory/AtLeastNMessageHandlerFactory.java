package Handler.MessageHandlerFactory;

import Handler.MessageHandler.AtLeastNMessageHandler;
import Handler.MessageHandler.MessageHandler;
import PubSub.PubSub;

public class AtLeastNMessageHandlerFactory implements MessageHandlerFactory {
    private int n;

    public AtLeastNMessageHandlerFactory(int n) {
        this.n = n;
    }

    @Override
    public MessageHandler createMessageHandler(PubSub pubSub) {
        return new AtLeastNMessageHandler(pubSub, n);
    }
}
