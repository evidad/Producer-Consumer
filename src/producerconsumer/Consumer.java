/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumer;

/**
 *
 * @author errol
 */
// Has a single Producer class object which is a thread and a single Consumer class which is also a thread.
public class Consumer implements Runnable{
    
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
                // Remove packets from the buffer
                Packet pkt = myBuffer.removePkt();

                // Simulate some processing time
                processPacket(pkt);
                
                myBuffer.notifyAll();
                
                }

                // Sleep for a short time to simulate processing delay
                Thread.sleep(100); // Sleep for 500 milliseconds
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Re-interrupt the thread
        }
    }

    // Method to simulate packet processing
    private void processPacket(Packet pkt) {
        System.out.println("Consumer " + bufferID + " processing " + pkt);
        // Add more packet processing logic here if needed
    }
}
