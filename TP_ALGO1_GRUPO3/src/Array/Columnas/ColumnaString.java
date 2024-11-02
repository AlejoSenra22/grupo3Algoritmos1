package Array.Columnas;

import java.util.List;

import Celda.Celda;

public class ColumnaString extends Columna<String> {

    public ColumnaString(String nombre) {
        super(nombre, String.class);
    }
    
    public ColumnaString(String nombre, List<Celda<?>> Celdas) {
        super(nombre, Celdas);
    }
    

    @Override
    public void agregarValor(String valor) {
        validarTipo(valor); // Validar el tipo
        super.agregarValor(valor);
    }
}
