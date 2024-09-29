/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package producerconsumer;

/**
 *
 * @author errol
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Start the producer thread
        Producer producer = new Producer(buffer);
        Thread producerThread = new Thread(producer);
        producerThread.start();

        // Continuously monitor the buffer size
        new Thread(() -> {
            while (true) {
                // Start the consumer when the buffer size reaches 70
                if (buffer.getBufferSize() >= 70) {
                    System.out.println("Starting consumer...");
                    Consumer consumer = new Consumer(buffer, 1);
                    Thread consumerThread = new Thread(consumer);
                    consumerThread.start();
                    
                    Consumer consumer2 = new Consumer(buffer, 2);
                    Thread consumerThread2 = new Thread(consumer2);
                    consumerThread2.start();
                    
                    break; // Only start the consumer once
                }
            }
        }).start();
    }
    
}
