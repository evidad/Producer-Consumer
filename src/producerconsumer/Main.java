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

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Producer producer = new Producer(buffer);
        executorService.execute(producer);

        Consumer consumer1 = new Consumer(buffer, 1);
        executorService.execute(consumer1);

        Consumer consumer2 = new Consumer(buffer, 2);
        executorService.execute(consumer2);
    }
}
