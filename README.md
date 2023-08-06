# Pub-Sub System

This is a simple implementation of a Pub-Sub (Publisher-Subscriber) system in Java. The system allows messages to be published by publishers and delivered to multiple subscribers based on different patterns. The implementation supports the following patterns:

1. At least n - The message must be received by at least n subscribers.
2. At most n - The message must be received by at most n subscribers.
3. Alternate messages only - The messages are delivered to subscribers in an alternate fashion.

## Table of Contents

- [Overview](#overview)
- [How to Use](#how-to-use)
- [Patterns](#patterns)
- [Implementation Details](#implementation-details)
- [Sample Test](#sample-test)
- [Extending the System](#extending-the-system)

## Overview

The Pub-Sub system consists of the following main components:

- `PubSub`: The central class representing the Pub-Sub system. It handles message publishing, subscription, and message delivery to subscribers based on the specified pattern. The `PubSub` class utilizes different `MessageHandler` implementations to achieve different patterns.

- `Subscriber`: An interface that defines the contract for subscribers to implement. Subscribers will receive messages sent to the Pub-Sub system.

- `MessageHandler`: An interface representing the different message handling strategies. Each message handler implements a specific message delivery pattern.

- `MessageHandlerFactory`: An interface to create the appropriate `MessageHandler` based on the specified pattern.

## How to Use

1. Create an instance of `PubSub` with the desired `MessageHandlerFactory` implementation.
2. Subscribe subscribers to the Pub-Sub system using the `subscribe` method.
3. Publish messages using the `publish` method.
4. Start the message handling process using the `startMessageHandler` method.

## Patterns

The system supports the following patterns:

### 1. At least n Pattern

In this pattern, messages must be received by at least n subscribers. If there are more than n subscribers, all subscribers will receive the message.

### 2. At most n Pattern

In this pattern, messages must be received by at most n subscribers. If there are fewer than n subscribers, all subscribers will receive the message. If there are more than n subscribers, only the first n subscribers will receive the message.

### 3. Alternate Messages Only Pattern

In this pattern, subscribers will receive messages in an alternate fashion. The first subscriber to join will receive the first message, the second subscriber will receive the second message, and so on. If there are only two subscribers, they will receive messages alternately.

## Implementation Details

The implementation utilizes the Observer pattern for pub-sub functionality, the Factory method pattern for message handling, and use multithreading to handle message processing asynchronously.

## Sample Test

A sample test is provided in the `Main` class to demonstrate the behavior of the Pub-Sub system with different patterns. The test showcases how messages are delivered to subscribers based on the specified pattern.

## Extending the System

The Pub-Sub system is designed to be easily extensible. Additional patterns can be supported by implementing new `MessageHandler` and `MessageHandlerFactory` classes. You can create your custom message handling strategies and incorporate them into the Pub-Sub system.
