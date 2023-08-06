package Handler.MessageHandlerFactory;

import Handler.MessageHandler.AlternateMessagesMessageHandler;
import Handler.MessageHandler.MessageHandler;
import PubSub.PubSub;

public class AlternateMessagesMessageHandlerFactory implements MessageHandlerFactory {
    @Override
    public MessageHandler createMessageHandler(PubSub pubSub) {
        return new AlternateMessagesMessageHandler(pubSub);
    }
}
