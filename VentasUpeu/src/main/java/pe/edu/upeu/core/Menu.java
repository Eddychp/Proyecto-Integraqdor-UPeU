package pe.edu.upeu.core;

public class Menu {
   
    public Object[][] menuOpciones(){

        Object[][] data=new Object[][]{
            {1, "pollo a la braza", 1, 20 },
            {2, "pollo broster", 1, 20 },
            {3, "mixto de pollo", 1, 30 },
            {4, "gaseosa", 1, 8.50 }
        };        
        return data;
    }

    public void imprimirMatriz(Object[][] data){
        String[] columnas=new String[] {"ID", "Producto", "Cantidad", "Precio" };
        System.out.println(columnas[0]+"\t"+columnas[1]+"\t"+columnas[2]+"\t"+columnas[3]);
        for (Object[] objects : data) {
            System.out.println(objects[0]+"\t"+objects[1]+"\t"+objects[2]+"\t"+objects[3]);
        }
    }

}