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
        List<MascotaApta> mascotasAptasAOperar = getPacientesAOperar();
        for (MascotaApta mascota : mascotasAptasAOperar) {
            try {
                operar(mascota.getNombre());
            } catch (MascotaOperadaException | MascotaNoOperableException e) {
                e.printStackTrace();
            }
        }
    }

    public void operar(String nombre) throws MascotaOperadaException, MascotaNoOperableException {
        for (Mascota mascota : pacientes) {
            if (mascota.getNombre().equals(nombre)) {
                if (!mascota.estaEsterilizado() && mascota instanceof Operable) {
                    ((Operable) mascota).operar();
                    return;
                } else {
                    throw new MascotaNoOperableException();
                }
                } else {
                    throw new MascotaOperadaException();
                }
            }
        throw new MascotaNoOperableException();
    }

}
