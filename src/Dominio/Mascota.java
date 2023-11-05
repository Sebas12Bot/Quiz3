package Dominio;

public abstract class Mascota {
    protected String nombre;
    protected String sexo;
    protected int edad;
    protected boolean esterilizado;

    public Mascota(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.esterilizado = false;
    }

    public boolean estaEsterilizado() {
        return esterilizado;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", edad=" + edad +
                ", esterilizado=" + esterilizado +
                '}';
    }

    public String getNombre() {
        return this.nombre;
    }
}
