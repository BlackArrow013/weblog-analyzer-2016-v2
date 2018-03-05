import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Esta clase analiza los accesos al servidor. Se compondrá de dos métodos, uno
 * que importará un documento de texto con los accesos al servidor y otro que 
 * obtendrá qué hora tiene más accesos.
 * 
 * @author (Jorge Jaular Lasaga) 
 * @version (05/03/2018)
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;  
    
    /**
     * El constructor de la clase. Crea un analizador de accesos al servidor.
     */
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }
    
    /**
     * Este método permite cargar los datos de acceso al servidor.
     * 
     * @param nombreArchivo Se introduce el nombre del archivo que servirá para cargar los datos.
     */
    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();                              
                Acceso accesoActual = new Acceso(lineaLeida);                            
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }
    
    /**
     * Este método comprueba a qué hora se produjeron más conexiones o accesos al servidor. Devuelve la hora con más conexiones, y en caso de empate devuelve la hora más alta. Si no hay conexiones
     * devuelve -1.
     * @return horaConMasAccesos Devuelve la hora con más conexiones, o -1 en caso de no haber importado datos. 
     */
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;        
        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];
    
            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }
            
            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }
            
            valorADevolver = horaDeAccesosMasAlto;                      
        }
        
        return valorADevolver;
    }   
    
    /**
     * Muestra la web más solicitada por la gente.
     * @return webMasSolicitada Devuelve como cadena la web más solicitada.
     */
    public String paginaWebMasSolicitada() 
    {
        return "";
    }
    
    /**
     * Muestra la IP del cliente con más accesos exitosos.
     * @return clienteConMasAccesos Devuelve el cliente con más accesos.
     */
    public String clienteConMasAccesosExitosos()
    {
        return "";
    }
}
