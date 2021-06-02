package P1_Operativos_2021;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

public class Productor extends Thread {
    double productosDiarios;
    double tiempoProd;
    private Almacen storage;
    Semaphore mutex;
    Semaphore semCons;
    Semaphore semProd;
    boolean exit = true;
    
    public Productor(Almacen storage, float dias, float prod, int tiempoDia, Semaphore semCons, Semaphore semProd, Semaphore mutex){
      this.storage = storage;
      this.productosDiarios = prod/dias;
      this.tiempoProd = tiempoDia/this.productosDiarios;
      this.mutex = mutex;
      this.semCons = semCons;
      this.semProd = semProd;
    }
    
    @Override
    public void run() {
      while(exit){
        try {
          this.semProd.acquire();
          this.mutex.acquire();
          TimeUnit.SECONDS.sleep((long)this.tiempoProd);
          storage.guardar();
          this.mutex.release();
          this.semCons.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
      }
    }
}
