/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        // Create an ExecutorService with a fixed pool of 3 threads (1 producer, 2 consumers)
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Start the producer thread using ExecutorService
        Producer producer = new Producer(buffer);
        executorService.execute(producer); // Submit the producer task

        // Start two consumer threads using ExecutorService
        Consumer consumer1 = new Consumer(buffer, 1);
        executorService.execute(consumer1); // Submit the first consumer task

        Consumer consumer2 = new Consumer(buffer, 2);
        executorService.execute(consumer2); // Submit the second consumer task

    }
    
}
