package Dominio;

import Dominio.Exception.MascotaNoOperableException;
import Dominio.Exception.MascotaOperadaException;

import java.util.ArrayList;
import java.util.List;

//En esta clase cometi errores de los que ya no me acuerdo salu2
public class Veterinaria {
    private String nombre;
    private List<Mascota> pacientes;

    private static final int AÑOS_MINIMO_MACHO = 1;
    private static final int MESES_MINIMOS_HEMBRA = 18;

    public Veterinaria(String nombre) {
        this.nombre = nombre;
        this.pacientes = new ArrayList<>();
    }

    //Debia retornar algo
    public void revisarMascota(String nombre, String sexo, int edad) {
        Mascota mascota;

        if ((sexo.equals("macho") && edad > AÑOS_MINIMO_MACHO) ||
                (sexo.equals("hembra") && edad > MESES_MINIMOS_HEMBRA)) {
            mascota = new MascotaApta(nombre, sexo, edad);
        } else {
            mascota = new MascotaNoApta(nombre, sexo, edad);
        }
        pacientes.add(mascota);
    }

    public List<MascotaApta> getPacientesAOperar() {
        List<MascotaApta> mascotasAptasAOperar = new ArrayList<>();
        for (Mascota mascota : pacientes) {
            if (!mascota.estaEsterilizado() &&mascota instanceof MascotaApta) {
                mascotasAptasAOperar.add((MascotaApta) mascota);
            }
        }
        return mascotasAptasAOperar;
    }

    public void operarATodos() {
        // Obtiene la lista de mascotas aptas para operar
        List<MascotaApta> mascotasAptasAOperar = getPacientesAOperar();
        // Itera las mascotas aptas
        for (MascotaApta mascota : mascotasAptasAOperar) {
            try {
                // Intenta realizar la operacion en cada mascota
                operar(mascota.getNombre());
            } catch (MascotaOperadaException | MascotaNoOperableException e) {
                // Maneja las excepcion
                e.printStackTrace();
            }
        }
    }

    public void operar(String nombre) throws MascotaOperadaException, MascotaNoOperableException {
        // Itera la lista de las mascotas
        for (Mascota mascota : pacientes) {
            // verifica el nombre de la mascota con el nombre que se espera
            if (mascota.getNombre().equals(nombre)) {
                // Si la mascota no cumple las condiciones del if
                if (!mascota.estaEsterilizado() && mascota instanceof Operable) {
                    ((Operable) mascota).operar();
                    return; // salida del metodo despues de la operacion
                } else {
                    // excepcion mascota no operable
                    throw new MascotaNoOperableException();
                }
            } else {
                // excepcion mascota operada
                throw new MascotaOperadaException();
            }
        }
        // Manda una excepcion si no encuentra la mascota
        throw new MascotaNoOperableException();
    }

}
