package PubSub;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Handler.MessageHandler.MessageHandler;
import Handler.MessageHandlerFactory.MessageHandlerFactory;
import Subscriber.Subscriber;

public class PubSub {
    private final Set<Subscriber> subscribers = Collections.synchronizedSet(new LinkedHashSet<>());
    private final BlockingQueue<Integer> messageQueue = new LinkedBlockingQueue<>();
    private final MessageHandler messageHandler;

    public PubSub(MessageHandlerFactory messageHandlerFactory) {
        this.messageHandler = messageHandlerFactory.createMessageHandler(this);
    }

    public void publish(int message) {
        messageQueue.add(message);
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public int getMessage() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return 0;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void startMessageHandler() {
        new Thread(messageHandler::handleMessages).start();
    }
}
