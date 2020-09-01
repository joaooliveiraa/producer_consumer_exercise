/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtutorConsumidor;

/**
 *
 * @author Joao_2
 */
public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            this.buffer.remove();
        }
    }

}
