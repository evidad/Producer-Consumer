/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author errol
 */
// Create a class Buffer that internally uses some data structure to hold incoming packet objects 
// – it should have methods insertPkt and removePkt and should have methods to tell the user how many packets 
// are in the Buffer at any time e.g. size.
// Let the Buffer object keep growing until it reaches about 70 packets, then start a Consumer thread 
// that consumes packets from the Buffer.

public class Buffer {
    // Use ArrayList to store packets dynamically
    private List<Packet> buffer = new ArrayList<>();

    // Synchronized method to insert packets into the buffer
    public synchronized void insertPkt(Packet packet) {
        buffer.add(packet);
        System.out.println("Inserted packet: " + packet + ", Buffer size: " + buffer.size());
        notifyAll(); // Notify the consumer that a new packet is available
    }

    public synchronized Packet removePkt() {
        while (buffer.isEmpty()) {
            try {
                wait(); // Wait until a packet is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted: " + e.getMessage());
                return null;
            }
        }
        // Remove the first packet (index 0) from the ArrayList
        Packet packet = buffer.remove(0);
        notifyAll();
        System.out.println("Removed packet: " + packet + ", Buffer size: " + buffer.size());
        return packet;
    }

    public synchronized int getBufferSize() {
        return buffer.size();
    }
}
