package ProtutorConsumidor;

/**
 *
 * @author Joao_2
 */
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    private int item;

    private Semaphore semFull;
    private Semaphore semEmpy;

    public Buffer() {
        this.semFull = new Semaphore(8);
        this.semEmpy = new Semaphore(1);
    }

    public void insert(int novoItem) {
        try {
            semEmpy.acquire();

            this.item = novoItem;
            System.out.println("Produzido > " + this.item);

            semFull.release();
        } catch (Exception ex) {
            // System.out.println("Erro ao inserir:" + ex.getMessage());
        }
    }

    public void remove() {
        try {
            semFull.acquire();
            System.out.println("Consumido > " + this.item);

            semEmpy.release();
        } catch (Exception ex) {
            //   System.out.println("Erro ao inserir:" + ex.getMessage());
        }
    }
    
    public void await(){
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
