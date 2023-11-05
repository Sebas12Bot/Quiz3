package Dominio.Exception;

public class MascotaOperadaException extends RuntimeException{
    public MascotaOperadaException (){
        super("+DETALLES: \nLa mascota ya fue operada");
    }
}
