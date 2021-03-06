import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Esta clase analiza los accesos al servidor. Se compondr� de dos m�todos, uno
 * que importar� un documento de texto con los accesos al servidor y otro que 
 * obtendr� qu� hora tiene m�s accesos.
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
     * Este m�todo permite cargar los datos de acceso al servidor.
     * 
     * @param nombreArchivo Se introduce el nombre del archivo que servir� para cargar los datos.
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
     * Este m�todo comprueba a qu� hora se produjeron m�s conexiones o accesos al servidor. Devuelve la hora con m�s conexiones, y en caso de empate devuelve la hora m�s alta. Si no hay conexiones
     * devuelve -1.
     * @return horaConMasAccesos Devuelve la hora con m�s conexiones, o -1 en caso de no haber importado datos. 
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
     * Muestra la web m�s solicitada por la gente.
     * @return webMasSolicitada Devuelve como cadena la web m�s solicitada.
     */
    public String paginaWebMasSolicitada() 
    {
        String webMasSolicitada = null;
        if (!accesos.isEmpty()) {
            int numeroVisitasPaginaMasVisitada = 0;
            for (int i = 0; i < accesos.size(); i++) {
                Acceso accesoActual = accesos.get(i);
                int numeroVisitasPaginaComparada = 0;
                if (accesoActual.getUrl() != webMasSolicitada) {
                    for (int j = i; j < accesos.size(); j++) {
                        Acceso accesoAComparar = accesos.get(j);
                        if (accesoActual.getUrl().equals(accesoAComparar.getUrl())) {
                            numeroVisitasPaginaComparada++;                            
                        }
                    }
                    if (numeroVisitasPaginaComparada > numeroVisitasPaginaMasVisitada) {
                        numeroVisitasPaginaMasVisitada = numeroVisitasPaginaComparada;
                        webMasSolicitada = accesoActual.getUrl();
                    }
                }
            }
        }
        return webMasSolicitada;
    }

    /**
     * Muestra la IP del cliente con m�s accesos exitosos.
     * @return clienteConMasAccesos Devuelve el cliente con m�s accesos.
     */
    public String clienteConMasAccesosExitosos()
    {
        String IPClienteConMasAccesosExitosos = null;
        if (!accesos.isEmpty()) {
            ArrayList<Acceso> accesosExitosos = new ArrayList<>();
            ArrayList<Integer> listaUltimoNumeroIP = new ArrayList<>();
            int IPConMayorNumeroDeConexiones = 0;
            for (Acceso accesoActual : accesos) {
                if (accesoActual.getCodigoHTTP() == 200) {
                    accesosExitosos.add(accesoActual);
                    int ultimoValorIP = Integer.parseInt(accesoActual.getIp().substring(10, accesoActual.getIp().length()));
                    listaUltimoNumeroIP.add(ultimoValorIP);
                }
            }

            for (int i = 0; i < listaUltimoNumeroIP.size(); i++) {
                int numeroActual = listaUltimoNumeroIP.get(i);
                int IPNumeroConexionesAComparar = 0;
                for (int j = i + 1; j < listaUltimoNumeroIP.size(); j++) {
                    int numeroAComparar = listaUltimoNumeroIP.get(j);
                    if (numeroAComparar == numeroActual) {
                        IPNumeroConexionesAComparar++;
                    }
                }
                if (IPNumeroConexionesAComparar > IPConMayorNumeroDeConexiones) {
                    IPConMayorNumeroDeConexiones = IPNumeroConexionesAComparar;
                    IPClienteConMasAccesosExitosos = accesosExitosos.get(i).getIp();
                }
            }
        }
        return IPClienteConMasAccesosExitosos;
    }
}
