package P1_Operativos_2021;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

public class Jefe extends Thread {
    int tiempoDia;
    int tiempoTrabajoHoras;
    int tiempoTrabajoSecs;
    private Almacen dias;
    Semaphore contador;
    Semaphore semGerente;
    Semaphore semJefe;
    
    public Jefe(Almacen dias, int tiempoDia, int tiempoTrabajoHoras, Semaphore semGerente, Semaphore semJefe, Semaphore contador){
      this.dias = dias;
      this.tiempoDia = tiempoDia;
      this.tiempoTrabajoSecs = (tiempoDia*tiempoTrabajoHoras)/24;
      this.contador = contador;
      this.semGerente = semGerente;
      this.semJefe = semJefe;
    }
    
    @Override
    public void run() {
      while(true){
        try {
          this.semJefe.acquire();
          this.contador.acquire();
          dias.guardar();
          Interfaz.jefeTrabajando = true;
          System.out.println("<<<< Trabajando >>>>");
          TimeUnit.SECONDS.sleep(tiempoTrabajoSecs);
          this.contador.release();
          this.semGerente.release();
          Interfaz.jefeTrabajando = false;
          System.out.println("<<<< Durmiendo >>>>");
          TimeUnit.SECONDS.sleep(tiempoDia - tiempoTrabajoSecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
      }
    }
}
