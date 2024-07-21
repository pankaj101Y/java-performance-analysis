package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * analysis tool: fast thread
 *
 * ps aux | grep 'java' | grep 'ThreadDump'
 * jstack <pid>
 *
 */
public class ThreadDump {

    public static void main(String[] args) throws InterruptedException {

        IntStream.range(0, 100)
                .parallel()
                .mapToObj(i -> {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                System.out.println("new thread"+i);
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                    thread.start();
                    return thread;
                }).forEach(x-> {
                    try {
                        x.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

    }
}
