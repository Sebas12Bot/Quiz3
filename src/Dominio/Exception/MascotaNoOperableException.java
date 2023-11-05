package Dominio.Exception;

public class MascotaNoOperableException extends RuntimeException{
    public MascotaNoOperableException (){
        super("+DETALLES: \nLa mascota no es operable o no se encontro el nombre de la mascota");
    }
}
