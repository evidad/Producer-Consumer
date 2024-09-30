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
    private int bufferID;

    public Consumer(Buffer buffer, int ID) {
        this.myBuffer = buffer;
        this.bufferID = ID;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (myBuffer) {
                    while (myBuffer.getBufferSize() < 70) {
                        myBuffer.wait();
                    }
                    Packet pkt = myBuffer.removePkt();
                    processPacket(pkt);
                    myBuffer.notifyAll();
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void processPacket(Packet pkt) {
        System.out.println("Consumer " + bufferID + " processing " + pkt);
    }
}
