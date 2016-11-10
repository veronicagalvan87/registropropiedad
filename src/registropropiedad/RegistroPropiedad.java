/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropropiedad;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class RegistroPropiedad {

    static ArrayList<Finca> fincas = new ArrayList<Finca>();

    public static void rellenarDatos() {

        Urbano u;
        for (int i = 0; i < 100; i++) {
            u = new Urbano();
            u.setDireccion("BADAJOZ ");
            u.setNum_registro(92893938 + i);
            u.setSuperficie(3000 + i);
            Propietario p = new Propietario();
            p.setNombre("John " + i);
            p.setEmail("j.gonzalez@gmail.com " + i);
            p.setMovil(638999777);
            u.setPropietario(p);
            fincas.add(u);

        }

        Rustico r;
        for (int i = 0; i < 100; i++) {
            r = new Rustico();
            r.setCultivo("arroz,trigo y cereales ");
            r.setNum_registro(837393827);
            r.setSuperficie(6000);
            Propietario p = new Propietario();
            p.setNombre("Arya " + i);
            p.setMovil(683928888);
            p.setEmail("a.lopez@gmail.com" + i);
            r.setPropietario(p);
            fincas.add(r);

        }

    }

    /*
    Borra la finca que esta en esa posicion.
     */
    public static void borrar(int pos) {
        fincas.remove(pos);
    }

    /*Recibe una posicion del vector de Fincas y borra la finca que esta en esa posicion.*/
    public static void borrar(ArrayList vector, int pos) {

        vector.remove(pos);
    }

    /*Recibe un numero de registro, lo busca en el vector de Fincas y borra la finca*/
    public static void borrar(String Num_registro) {
        int pos = 0;
        int encontrado = 0;
        while ((pos < fincas.size()) && (encontrado == 0)) {
            if (Num_registro.equals(fincas.get(pos).getNum_registro())) {
                fincas.remove(pos);
                encontrado = 1;
            }
            pos = pos + 1;
        }

    }

    /*Hace todo: borra las dos fincas y añade la nueva. El nuevo propietario es el de la inca una.*/
    public static void unir(ArrayList<Finca> vector, int pos) {
        vector.remove(pos);

    }

    public static void unir(ArrayList<Finca> vector, int pos1, int pos2) {

        Finca finc1 = vector.get(pos1);
        Finca finc2 = vector.get(pos2);

        if (finc1.getClass() == finc2.getClass()) { //si son del mismo tipo
            Finca nueva = null;
            if (!(finc1 instanceof Urbano)) {//es rústico
                nueva = new Urbano();
                ((Urbano) nueva).setDireccion("Nueva dirección ");
            } else if (finc1 instanceof Rustico) {//es urbano
                nueva = new Rustico();
                ((Rustico) nueva).setCultivo("Nuevo cultipo");
            }

            nueva.setSuperficie(finc1.getSuperficie() + finc2.getSuperficie());
            nueva.setNum_registro("9999");
            nueva.setPropietario(finc1.getPropietario());

            vector.remove(pos1);
            vector.remove(finc2); //análogo
            vector.add(nueva);
        }
    }

    public static void unir(ArrayList<Finca> vector, Finca finc1, Finca finc2) {
        
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        rellenarDatos();

    }
}