package org.java.upskilling.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThreads {
    
    private static int NUMBER_OF_PRODUCERS = 4;
    private static int NUMBER_OF_CONSUMERS = Runtime.getRuntime().availableProcessors();
    private static int POISON_PILL_VALUE = Integer.MAX_VALUE;
    private static int NUMBER_OF_POISONS = NUMBER_OF_CONSUMERS / NUMBER_OF_PRODUCERS;
    
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        
        for (int index = 0; index < NUMBER_OF_PRODUCERS; index++) {
            new Thread(new Producer(blockingQueue, getName("Producer", index), POISON_PILL_VALUE, NUMBER_OF_POISONS)).start();
        }
        
        for (int index = 0; index < NUMBER_OF_CONSUMERS; index++) {
            new Thread(new Consumer(blockingQueue, getName("Consumer", index), POISON_PILL_VALUE)).start();
        }
    }

    private static String getName(String type, int index) {
        return type + index;
    }
}
