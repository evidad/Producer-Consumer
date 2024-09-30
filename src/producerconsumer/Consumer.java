/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumer;

/**
 *
 * @author errol
 */
/**
 * Has a single Producer class object which is a thread and a single Consumer
 * class which is also a thread.
 */
public class Consumer implements Runnable {

    private Buffer myBuffer;
    private int consumerID;

    public Consumer(Buffer buffer, int ID) {
        this.myBuffer = buffer;
        this.consumerID = ID;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (myBuffer) {
                    while (myBuffer.getBufferSize() <= 50) {
                        myBuffer.wait();
                    }

                    Packet pkt = myBuffer.removePkt();
                    System.out.println("Consumer " + consumerID + " removed packet: ID: " + pkt.getId() + ", buffer size: " + myBuffer.getBufferSize());
                    myBuffer.notifyAll();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
