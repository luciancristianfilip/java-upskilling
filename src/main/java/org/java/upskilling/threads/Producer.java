package org.java.upskilling.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private static final int NUMBERS_TO_GENERATE = 100;
    
    private BlockingQueue<Integer> queue;
    private final String name;
    private final int poisonPillValue;
    private final int numberOfPoisons;

    public Producer(BlockingQueue<Integer> queue, String name, int poisonPillValue, int numberOfPoisons) {
        this.queue = queue;
        this.name = name;
        this.poisonPillValue = poisonPillValue;
        this.numberOfPoisons = numberOfPoisons;
    }

    @Override
    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void generateNumbers() throws InterruptedException {
        addRandomNumberToQueue();
        addPoisonPillsToQueue(numberOfPoisons, poisonPillValue);
    }

    private void addRandomNumberToQueue() throws InterruptedException {
        for (int i = 0; i < NUMBERS_TO_GENERATE; i++) {
            queue.put(ThreadLocalRandom.current().nextInt(NUMBERS_TO_GENERATE));
        }
    }

    private void addPoisonPillsToQueue(int numberOfPoisons, int poisonPillValue) throws InterruptedException {
        for (int i = 0; i < numberOfPoisons; i++) {
            System.out.println("["+ name +"] Add poison pill ["+ poisonPillValue +"], index ["+ i +"], totalPoisons ["+ numberOfPoisons +"]");
            queue.put(poisonPillValue);
        }
    }
}
