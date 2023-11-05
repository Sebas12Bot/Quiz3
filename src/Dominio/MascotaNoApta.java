package Dominio;

public class MascotaNoApta extends Mascota implements Operable{
    public MascotaNoApta(String nombre, String sexo, int edad) {
        super(nombre, sexo, edad);
    }

    @Override
    public String toString() {
        System.out.println("MascotaNoApta");
        return super.toString();
    }

    @Override
    public void operar() {
        esterilizado = true;
    }
}
