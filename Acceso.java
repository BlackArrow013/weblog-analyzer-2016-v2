public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;    
    public Acceso(String acceso)
    {
        String[] elementosAcceso = acceso.split(" ");
        ano = Integer.parseInt(elementosAcceso[0]);
        mes = Integer.parseInt(elementosAcceso[1]);
        dia = Integer.parseInt(elementosAcceso[2]);
        hora = Integer.parseInt(elementosAcceso[3]);;
        minutos = Integer.parseInt(elementosAcceso[4]);
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
}