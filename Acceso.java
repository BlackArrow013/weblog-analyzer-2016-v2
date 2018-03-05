/**
 * Esta clase representa un acceso al servidor. Se podrá consultar la ip desde donde se consulta, la fecha y hora, la URL consultada y el código HTTP del sitio web.
 * author (Jorge Jaular Lasaga)
 * version (05/03/2018)
 */
public class Acceso
{
    private String ip;
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;  
    private String url;
    private int codigoHTTP;
    
    /**
     * Constructor de la clase Acceso. Lee los datos del acceso al servidor.
     * @param acceso De tipo String, son los datos de acceso.
     */
    public Acceso(String acceso)
    {
        String[] elementosAcceso = acceso.split(" ");
        ip = elementosAcceso[0];
        // Este substring quita el primer corchete de apertura.
        ano = Integer.parseInt(elementosAcceso[1].substring(1, elementosAcceso[1].length()));
        mes = Integer.parseInt(elementosAcceso[2]);
        dia = Integer.parseInt(elementosAcceso[3]);
        hora = Integer.parseInt(elementosAcceso[4]);
        // Este substring quita el último corchete de cierre.
        minutos = Integer.parseInt(elementosAcceso[5].substring(0, elementosAcceso[5].length() - 1));
        url = elementosAcceso[6];
        codigoHTTP = Integer.parseInt(elementosAcceso[7]);
    }
    
    /**
     * Muestra la IP del lugar visitado.
     * @return ip Devuelve la IP.
     */
    public String getIp()
    {
        return ip;
    }
    
    /**
     * Muestra el año de acceso.
     * @return ano Devuelve el año de acceso en formato numérico.
     */    
    public int getAno() 
    {
        return ano;
    }
    
    /**
     * Muestra el mes de acceso.
     * @return mes Devuelve el mes de acceso en formato numérico.
     */
    public int getMes()
    {
        return mes;
    }
    
    /**
     * Muestra el día de acceso.
     * @return dia Devuelve el día de acceso en formato numérico.
     */
    public int getDia()
    {
        return dia;
    }
    
    /**
     * Muestra la hora de acceso al servidor.
     * @return hora Devuelve la hora de acceso.
     */
    public int getHora()
    {
        return hora;
    }
    
    /**
     * Muestra el minuto de acceso al servidor.
     * @return minutos Devuelve el minuto de acceso.
     */
    public int getMinutos()
    {
        return minutos;
    }
    
    /**
     * Muestra la URL visitada.
     * @return url Devuelve una cadena del lugar visitado.
     */    
    public String getUrl()
    {
        return url;
    }
    
    /**
     * Muestra el código HTTP del lugar visitado por la persona.
     * @return codigoHTTP Devuelve el código HTTP del lugar visitado en formato numérico.
     */
    public int getCodigoHTTP()
    {
        return codigoHTTP;
    }
}