package Array;

import Celda.*;
import java.util.ArrayList;
import java.util.List;



public class ArrayCelda implements util.ImputarFaltantes {
    protected List<Celda<?>> celdas;
    protected String nombre;

    public ArrayCelda(String nombre) {
        this.celdas = new ArrayList<>();
        this.nombre = nombre;
    }

    public ArrayCelda(List<Celda<?>> celdas){
        this.celdas = celdas;
    }

    @SuppressWarnings("unchecked")
    public <T> T obtenerValor(int indice) {
        if (indice < 0 || indice >= celdas.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        Celda<?> celda = celdas.get(indice);
        if (celda instanceof CeldaNA) {
            return null;
        }
        return (T) celda.obtenerValor();
    }
    
    public Integer obtenerTamaño() {
        return celdas.size();
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }
    
    public void agregarCelda(Celda<?> celda) {
        celdas.add(celda);
    }
    
    public void agregarValor(Number valor) {
        celdas.add(new CeldaNumber(valor)); 
    }

    public void agregarValor(Boolean valor) {
        celdas.add(new CeldaBoolean(valor)); 
    }

    public void agregarValor(String valor) {
        celdas.add(new CeldaString(valor)); 
    }

    public void agregarValor() {
        celdas.add(new CeldaNA()); 
    }

    public void establecerCeldas(List<Celda<?>> nuevasCeldas) {
        this.celdas = nuevasCeldas;
    }

    public ArrayCelda copiaProfunda() {
        ArrayCelda nuevaArray = new ArrayCelda(String.valueOf(this.nombre));
        for (Celda<?> celda : celdas) {
            nuevaArray.celdas.add(celda.copiaProfunda());
        }
        return nuevaArray;
    }

    public List<Celda<?>> obtenerCeldas(){
        return this.celdas;
    }

    public void imputarNA(Number nuevoValor) {
        for (int i = 0; i < celdas.size(); i++) {
            if (celdas.get(i) instanceof CeldaNA) {
                celdas.set(i, new CeldaNumber(nuevoValor));
            }
        }
    }

    public void imputarNA(Boolean nuevoValor) {
        for (int i = 0; i < celdas.size(); i++) {
            if (celdas.get(i) instanceof CeldaNA) {
                celdas.set(i, new CeldaBoolean(nuevoValor));
            }
        }
    }

    public void imputarNA(String nuevoValor) {
        for (int i = 0; i < celdas.size(); i++) {
            if (celdas.get(i) instanceof CeldaNA) {
                celdas.set(i, new CeldaString(nuevoValor));
            }
        }
    }

  
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ArrayCelda)) {
            return false;
        }
        ArrayCelda otroArrayCelda = (ArrayCelda) obj;
        return this.celdas.equals(otroArrayCelda.celdas);
    }

    @Override
    public int hashCode() {
        return 31 * celdas.hashCode();
    }
}
