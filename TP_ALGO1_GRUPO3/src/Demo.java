import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void espacio(){
        System.out.println("\n\n");
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {





        ///////////// DESCARGA CSV
        String rutaDeCarga = "C:\\Users\\MAURICIO\\Downloads\\DEMO\\grupo3Algoritmos1\\TP_ALGO1_GRUPO3\\src\\Plastic Waste Around the World.csv";
        Tabla tabla = new Tabla(rutaDeCarga, true);
        System.out.println(tabla);
        espacio();


        /////////////// INFO
        System.out.println("INFO");
        tabla.info(); // informacion basica
        espacio();
        

        /////////////// VISUALIZAR y SELLECCION
        System.out.println("VISUALIZAR");
        tabla.visualizar(0, 5, 10);
        tabla.seleccionar(2, 4, null);
        espacio();
        tabla.head(3);
        espacio();
        tabla.tail(3);
        espacio();

        //////////  MUESTREO
        System.out.println("MUESTREO");
        tabla.muestreo(5);
        espacio();
        



        ///////////// ACCESO INDEXADO // Columna // Fila // Celda
        Tabla indexar = tabla.copiaProfunda();
        Tabla fila = indexar.obtenerFila(1);
        Tabla columna = indexar.obtenerColumna("Country");
        String celda = indexar.obtenerValorString(0, 0);
        System.out.println("ACCESO INDEXADO");
        System.out.println(fila);
        System.out.println(columna);
        System.out.println(celda);
        espacio();


        ////////////////// OTRAS FORMAS DE CREAR TABLAS
        System.out.println("OTRAS FORMAS DE CREAR TABLAS \n");
        /// Por CSV
        Tabla tablacsv = new Tabla("C:\\Users\\MAURICIO\\Downloads\\DEMO\\grupo3Algoritmos1\\TP_ALGO1_GRUPO3\\src\\test.csv", true);
        System.out.println("Por CSV \n" + tablacsv);
        /// Por Listas
        List<List<Object>> listaDeFilas = new ArrayList<>();
        listaDeFilas.add(Arrays.asList("Nombre", "Edad", "Pais"));  
        listaDeFilas.add(Arrays.asList("Alice", 30, "España"));
        listaDeFilas.add(Arrays.asList("Bob", 25, "Francia"));
        listaDeFilas.add(Arrays.asList("Charlie", 35, "España"));

        Tabla tablaLista = new Tabla(listaDeFilas, true);
        System.out.println("Por listas \n" + tablaLista);
        espacio();
        /// Por Matrices
        // Matriz de datos con encabezado
        Object[][] matriz = {
            {"Nombre", "Edad", "Ciudad"},  // Encabezado
            {"Alice", 30, "Madrid"},
            {"Bob", 25, "París"},
            {"Charlie", 35, "Valencia"}
        };

        Tabla tablaMatriz = new Tabla(matriz, true);
        System.out.println("Por Matriz \n" + tablaMatriz);
        espacio();


        /////////////////////// CASTEO E IMPUTACION 
        System.out.println("CASTEO E IMPUTACION: \n \n");
        System.out.println("Tabla a tratar: \n" + tablacsv);
        System.out.println("Composición de la tabla: \n");
        tablacsv.testeo();
        tablacsv.aNumerica("Edad");
        System.out.println("\n Edad convertida a numérica \n" + tablacsv);
        tablacsv.imputarNA("Edad", 0);
        System.out.println("NA imputadas \n" + tablacsv);



        /////////////////////// MODIFICACION
        /// Por asignacion de celdas y columnas
        System.out.println("ASIGNACION Y PRUEBA COPIA PROFUNDA \n");
        Tabla copiaMatriz = tablaMatriz.copiaProfunda();
        copiaMatriz.insertarColumna(tablaLista.obtenerColumna("Pais"));
        List<List<Object>> otraColumna = new ArrayList<>();
        otraColumna.add(Arrays.asList("TieneDeudas"));  
        otraColumna.add(Arrays.asList(true));
        otraColumna.add(Arrays.asList(false));
        otraColumna.add(Arrays.asList( false));
        copiaMatriz.insertarColumna(new Tabla(otraColumna, true));
        copiaMatriz.eliminarColumna("Edad");
        copiaMatriz.eliminarFila(2);
        copiaMatriz.definirValor(0, 1, "Juan");
        System.out.println("Copia alterada \n" + copiaMatriz);
        System.out.println("Original \n" + tablaMatriz);





        // ////////////// CARGA CSV
        // System.out.println("CARGA CSV");
        // String rutaDeGuardado = "";
        // columna.guardarComoCSV(rutaDeGuardado);
        // espacio();




        // FILTRAD
        System.out.println("FILTRADO \n");
        Tabla filtrada = tabla.filtrar("Main_Sources", Tabla.condicion("==","Packaging_Industrial"));
        System.out.println("Main_Sources == ´Packaging:Industrial´ \n" + filtrada);

        System.out.println("FILTRADO MULTIPLE\n");
        Tabla tabla2 = tabla.copiaProfunda();

        System.out.println("Ciudad == China AND Recycling_Rate >= 10 \n");
        tabla2.and(tabla2.condicion("Country","==", "China"),
        tabla2.condicion("Recycling_Rate",">=", 10));
        System.out.println(tabla2);

        System.out.println("Country == Argentina OR Country == Mexico OR Total_Plastic_Waste_MT == null");
        Tabla tabla3 = tabla.copiaProfunda();
        tabla3.or(tabla3.condicion("Country","==", "Argentina"), 
                    tabla3.condicion("Country", "==", "Mexico"),
                    tabla3.condicion("Total_Plastic_Waste_MT", "==", null));
        System.out.println(tabla3);
        espacio();


        
        /////// CONCATENACION
        System.out.println("CONCATENACION \n");
        System.out.println("Cantidad de filas originales:" + tabla.numeroFilas() + "\n");
        Tabla concatenada = Tabla.concatenar(tabla, tabla);
        System.out.println("Cantidad de filas ahora:" + concatenada.numeroFilas() + "\n");



        ///////// ORDENAMIENTO
        System.out.println("ORDENAMIENTO");
        concatenada.ordenarPorColumnas(Arrays.asList("Country"), false);
        concatenada.head(15);





    }
}
