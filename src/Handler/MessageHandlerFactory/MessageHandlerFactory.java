package Handler.MessageHandlerFactory;

import Handler.MessageHandler.MessageHandler;
import PubSub.PubSub;

public interface MessageHandlerFactory {
    MessageHandler createMessageHandler(PubSub pubSub);
}

