
package P1_Operativos_2021;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

public class Ensamblador extends Thread {
  private Almacen almBrazo;
  private Almacen almPierna;
  private Almacen almCuerpo;
  private Almacen almBoton;
  private Almacen almPana;
  private int cantBrazo;
  private int cantPierna;
  private int cantCuerpo;
  private int cantBoton;
  private int tiempoProd;
  Semaphore mutex;
  Semaphore semProdBoton;
  Semaphore semProdBrazo;
  Semaphore semProdPierna;
  Semaphore semProdCuerpo;
  Semaphore semCons;
  boolean exit = true;
  
  public Ensamblador(Semaphore semCons, Semaphore mutex, Semaphore semProdBoton, Semaphore semProdBrazo, Semaphore semProdPierna, Semaphore semProdCuerpo, Almacen pana, Almacen brazo, Almacen pierna, Almacen cuerpo, Almacen boton, int cantBrazo,int cantPierna,int cantCuerpo,int cantBoton, int tiempoProd){
      this.almBrazo = brazo;
      this.almPierna = pierna;
      this.almCuerpo = cuerpo;
      this.almBoton = boton;
      this.almPana = pana;
      this.cantBrazo = cantBrazo;
      this.cantPierna = cantPierna;
      this.cantCuerpo = cantCuerpo;
      this.cantBoton = cantBoton;
      this.tiempoProd = tiempoProd;
      this.semProdBoton = semProdBoton;
      this.semProdBrazo = semProdBrazo;
      this.semProdPierna = semProdPierna;
      this.semProdCuerpo = semProdCuerpo;
      this.semCons = semCons;
      this.mutex = mutex;
  }

  @Override		
  public void run() {
    while(exit){
      {
        try{
          this.semCons.acquire();
          this.mutex.acquire();
          if(almBrazo.cantidad >= cantBrazo && almPierna.cantidad >= cantPierna && almCuerpo.cantidad >= cantCuerpo && almBoton.cantidad >= cantBoton){
            almBrazo.extraer(2);
            almPierna.extraer(2);
            almCuerpo.extraer(1);
            almBoton.extraer(8);
            this.mutex.release();
            this.semProdBoton.release(8);
            this.semProdBrazo.release(2);
            this.semProdPierna.release(2);
            this.semProdCuerpo.release(1);
            TimeUnit.SECONDS.sleep(tiempoProd);
            almPana.guardar();
          } else {
            this.mutex.release(); 
          }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        
      }
    }
  }
}