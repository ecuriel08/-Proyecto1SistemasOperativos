package P1_Operativos_2021;

import java.util.concurrent.*;

public class Almacen {
    volatile int cantidad;

    public void guardar(){
        cantidad++;
    }

    public void extraer(int cuantos){
        cantidad = cantidad - cuantos;
    }
}

