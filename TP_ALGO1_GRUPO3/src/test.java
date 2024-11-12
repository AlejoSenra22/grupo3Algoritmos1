import java.io.IOException;
import java.util.Arrays;



public class test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        
        Tabla tabla = new Tabla("/home/tareas/Downloads/grupo3Algoritmos1/TP_ALGO1_GRUPO3/src/carga.csv", true);
        


        tabla.aNumerica("Edad");

        tabla.info(); // informacion basica


        ///////////// ACCESO INDEXADO
        Tabla indexar = tabla.copiaProfunda();
        Tabla fila = indexar.obtenerFila(1);
        Tabla columna = indexar.obtenerColumna("Edad");
        String celda = indexar.obtenerValorString(0, 0);
        System.out.println("ACCESO INDEXADO");
        System.out.println(fila);
        System.out.println(columna);
        System.out.println(celda);



        ////////////SELECCION
        System.out.println("SELECCION");
        tabla.seleccionar(2, 4, null);

        // FILTRADO Y COPIA INDEPENDIENTE
        Tabla tabla2 = tabla.copiaProfunda();
        tabla2.and(tabla2.condicion("Ciudad","==", "Nueva York"),
        tabla2.condicion("Edad",">=", 30));
        

        System.out.println(tabla2);

        Tabla filtrada = tabla.filtrar("Edad", Tabla.condicion(">",30));
        System.out.println(filtrada);
        
        /////// CONCATENACION
        System.out.println("CONCATENACION");
        Tabla concatenada = Tabla.concatenar(tabla, tabla);
        System.out.println(concatenada);


        ///////// ORDENAMIENTO
        System.out.println("ORDENAMIENTO");
        Tabla ordenada = tabla.copiaProfunda();
        ordenada.ordenarPorColumnas(Arrays.asList("Edad"), false);
        System.out.println(ordenada);

        ///////// IMPUTACION
        System.out.println("IMPUTACION");
        Tabla imputada = tabla.copiaProfunda();
        imputada.imputarNA("Edad", 0);
        System.out.println(imputada);


        //////////  MUESTREO
        System.out.println("MUESTREO");
        tabla.muestreo(25);

    }
}
