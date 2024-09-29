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
    
    public Packet() {};
    
    public Packet(String str) {
        this.str = str;
    }
    
    public String getStr() {
        return this.str;
    }
    
    public void setStr(String str) {
        this.str = str;
    }
}
