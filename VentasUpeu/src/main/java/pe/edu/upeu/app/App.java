package pe.edu.upeu.app;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.core.Menu;
import pe.edu.upeu.dao.ClientesDao;
import pe.edu.upeu.dao.ProductosDao;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;

/**
 * Hello world!
 *
 */
public class App{

    static LeerTeclado teclado=new LeerTeclado();
    static Console cons=System.console();

    static Menu rep=new Menu(); 
    static UtilsX util=new UtilsX();
    static public void crearArchivo(String nombre){
           LeerArchivo la=new LeerArchivo(nombre);
            try {
                List list = new ArrayList<String>();
                list.add("P001	Papa fritas	porcion	2.5	30");
                list.add("P002	Gaseosa	litros	3	48");
                la.escribir(list);    
                
                List listaLectura=la.leer();
                System.out.println("Contenido de Productos");
                System.out.println(listaLectura);
                
            } catch (Exception e) {
                System.out.println("Error al escribir registros");
            }
    }

    static void menuOpciones(){
        System.out.println( "*********************Bienvenidos al Sistema********************" );
        
        char opcion='S';
        int numeroAlgoritmo=1;
        do{
            String datos="Seleccion la opción que desea:\n"+

            "1=Imprimir Productos \n"+
            "2=Crear Nuevo cliente \n"+

            "3=Agregar Producto \n";

            ProductosDao daoProd;
            ClientesDao clientesDao;
            numeroAlgoritmo=teclado.leer(0, datos);
            switch(numeroAlgoritmo){

             
                case 1: rep.imprimirMatriz(rep.menuOpciones());break;
                case 2: {
                    clientesDao=new ClientesDao();
                    clientesDao.crearCliente();
                    clientesDao.reportarClientes();
                }break;
 
                case 3: { 
                    daoProd=new ProductosDao();
                    daoProd.agregarProducto();
                    daoProd.reportarProductos();
                }break;
                                                                     
                default : System.out.println("La opción que selecciono no existe"); 
            }
            opcion=teclado.leer(' ', "Desea probar otras opciones? SI=S, NO=N");
            util.clearConsole();
            System.out.println(datos);
        }while(opcion=='S' || opcion=='s');

    }

    static boolean login(){
        String usuario=teclado.leer("", "Ingrese el Usuario:");
        System.out.println("Ingrese su clave:");
        char[] clave=cons.readPassword();
        if(usuario.equals("pollito") && String.valueOf(clave).equals("13579")){
            menuOpciones();
            return true;
        }else{ 
            System.err.println("Intente Nuevamente ...!!!");
            login();
            return false;}        
    }


    public static void main( String[] args ){        
        
        util.clearConsole();
        System.out.println("-----Ingrese su usuario y clave para acceder al Sistema---");
        login();

    }
}
