package Array.Columnas;

import java.util.List;

import Array.ArrayCelda;
import Celda.Celda;

public class ColumnaNA extends Columna<String> {

    public ColumnaNA(ArrayCelda array){
        super(array);
    }

    public ColumnaNA(){
        super("");
    }

    public ColumnaNA(String nombre) {
        super(nombre, String.class);
    }

    public ColumnaNA(String nombre, List<Celda<?>> Celdas){
        super(nombre, Celdas);
    }

    @Override
    public void agregarValor(String valor) {
        throw new UnsupportedOperationException("No se puede agregar valores concretos a una celda NA.");
    }

    public String obtenerValor(int indice) {
        return null; 
    }
}
