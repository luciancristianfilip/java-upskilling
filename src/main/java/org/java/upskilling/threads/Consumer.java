package org.java.upskilling.threads;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    
    private BlockingQueue<Integer> queue;
    private final String name;
    private final int poisonPill;

    public Consumer(BlockingQueue<Integer> queue, String name, int poisonPill) {
        this.queue = queue;
        this.name = name;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Integer number = queue.take();
                if (number.equals(poisonPill)) {
                    System.out.println("["+ name +"] Received poison pill!");
                    return;
                }

                System.out.println("["+ name +"] take [" + number + "]");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
