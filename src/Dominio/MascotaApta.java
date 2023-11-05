package Dominio;

public class MascotaApta extends Mascota implements Operable{
    public MascotaApta(String nombre, String sexo, int edad) {
        super(nombre, sexo, edad);
    }

    @Override
    public String toString() {
        System.out.println("MascotaApta");
        return super.toString();
    }

    @Override
    public void operar() {
        esterilizado = true;
    }
}
