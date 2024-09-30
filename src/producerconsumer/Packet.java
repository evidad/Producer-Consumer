/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumer;

/**
 *
 * @author errol
 */
// Contains a simple string
public class Packet {

    private String str;
    private int id;

    private static int counter = 0;

    public Packet() {
        this.id = ++counter;
        this.str = String.valueOf(id);
    }
   
    public String getStr() {
        return this.str;
    }
    
    public int getId() {
        return this.id;
    }
}
