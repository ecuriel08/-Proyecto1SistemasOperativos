package P1_Operativos_2021;
import java.util.concurrent.TimeUnit;
public class Sout extends Thread{
  private Almacen almBrazo;
  private Almacen almPierna;
  private Almacen almCuerpo;
  private Almacen almBoton;
  private Almacen almPana;
  private Almacen dias;
  private int dia;

  public Sout(Almacen pana, Almacen brazo, Almacen pierna, Almacen cuerpo, Almacen boton, int dia, Almacen dias){
    this.almBrazo = brazo;
    this.almPierna = pierna;
    this.almCuerpo = cuerpo;
    this.almBoton = boton;
    this.almPana = pana;
    this.dia = dia;
    this.dias = dias;
  }

  @Override
  public void run(){
    int seconds = 1;
    while(true){
      if(seconds > dia){
        seconds = 1;
      }
       try {
            System.out.println(almBoton.cantidad + " - " + almBrazo.cantidad + " - " + almPierna.cantidad + " - " + almCuerpo.cantidad + " - " + almPana.cantidad + " (" + seconds + ") " + "[ " + dias.cantidad + " ]");
            seconds++;
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
      
    }
  }
}
