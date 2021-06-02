package P1_Operativos_2021;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

public class Gerente extends Thread {
  private Almacen pana;
  private Almacen dias;
  private int tiempoDormirSecs;
  private int tiempoDia;
  private int diaDespachos;
  Semaphore contador;
  Semaphore semJefe;
  Semaphore semGerente;
  
  public Gerente(Almacen pana, Almacen dias, int tiempoDia, int tiempoDormirHoras, Semaphore semGerente, Semaphore semJefe, Semaphore contador, int diaDespachos){
      this.pana = pana;
      this.dias = dias;
      this.tiempoDia = tiempoDia;
      this.tiempoDormirSecs = (tiempoDia*tiempoDormirHoras)/24;
      this.semGerente = semGerente;
      this.semJefe = semJefe;
      this.contador = contador;
      this.diaDespachos = diaDespachos;
  }

  @Override		
  public void run() {
    while(true){
        try{
          Interfaz.gerenteTrabajando = false;
          TimeUnit.SECONDS.sleep(tiempoDormirSecs);
          this.semGerente.acquire();
          this.contador.acquire();
          if(dias.cantidad == diaDespachos){
               dias.extraer(dias.cantidad);
               Interfaz.panasTotales += pana.cantidad;
               pana.extraer(pana.cantidad);
               this.contador.release();
               this.semJefe.release(diaDespachos);
          } else {
              this.contador.release();
              Interfaz.gerenteTrabajando = true;
              TimeUnit.SECONDS.sleep(tiempoDia - tiempoDormirSecs);
          }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }
  }
}