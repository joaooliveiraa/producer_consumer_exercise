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
public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        
        start(producer, consumer);
    }

    public static void start(Producer p, Consumer c) {
        p.start();
        c.start();
    }

}
