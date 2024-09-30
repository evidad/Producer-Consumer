/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumer;

import java.util.Random;

/**
 *
 * @author errol
 */
/**
 * Has a single Producer class object which is a thread and a single Consumer
 * class which is also a thread. Make the Producer object at random time
 * intervals, create Packet objects and place them in the Buffer object.
 *
 */
public class Producer implements Runnable {

    private Buffer myBuffer;

    Random random = new Random();

    public Producer(Buffer buffer) {
        this.myBuffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (myBuffer) {
                    while (myBuffer.getBufferSize() >= 70) {
                        myBuffer.wait();
                    }
                    Packet pkt = new Packet();
                    myBuffer.insertPkt(pkt);
                    myBuffer.notifyAll();
                }
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
