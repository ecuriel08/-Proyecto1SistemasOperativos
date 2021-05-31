package P1_Operativos_2021;

public class Productor {
    int type;
    int id;
    int cantidadOutput;
    int almacenLimit;
    int duracionDia;
    
    public Productor(int type, int count, int cantidadOutput, int almacenLimit ){
      this.type = type;
      this.id = count;
      this.cantidadOutput = cantidadOutput;
      this.almacenLimit = almacenLimit;
    }
}

