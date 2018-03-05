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
    public Acceso(String acceso)
    {
        String[] elementosAcceso = acceso.split(" ");
        ip = elementosAcceso[0];
        ano = Integer.parseInt(elementosAcceso[1].substring(1, elementosAcceso[1].length()));
        mes = Integer.parseInt(elementosAcceso[2]);
        dia = Integer.parseInt(elementosAcceso[3]);
        hora = Integer.parseInt(elementosAcceso[4]);
        minutos = Integer.parseInt(elementosAcceso[5].substring(0, elementosAcceso[5].length() - 1));
        url = elementosAcceso[6];
        codigoHTTP = Integer.parseInt(elementosAcceso[7]);
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public int getAno() 
    {
        return ano;
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public int getHora()
    {
        return hora;
    }
    
    public int getMinutos()
    {
        return minutos;
    }
    
    public String getUrl()
    {
        return url;
    }
    
    public int getCodigoHTTP()
    {
        return codigoHTTP;
    }
}