package co.sofka.traductor;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Diccionario {


    HashMap<String, String> palabras;
    ControlPersistencia persistencia;

    public Diccionario() throws FileNotFoundException {
        persistencia = new ControlPersistencia();
        llenarDiccionario();
    }

    private void llenarDiccionario() throws FileNotFoundException {
        List<String> lineasArchivo = persistencia.obtenerContenidoArchivo();
        palabras = new HashMap<>();

        lineasArchivo.forEach(p -> {
            String[] palabraSignificado = p.split("=");
            if (p.length() != 0)
                palabras.put(palabraSignificado[0], palabraSignificado[1]);
        });
    }

    public void mostrarPalabraSignificadoIngles(String palabraCastellano) {
        String significado = palabras.get(palabraCastellano);

        if (significado == null)
            System.out.println("La palabra no se encuentra registrada");
        else
            System.out.println("palabra: " + palabraCastellano + ", significado " + significado + "\n");
    }

    public void insertarNuevaPalabra(String palabraCastellano, String palabraIngles) {
        try {
            if (palabras.get(palabraCastellano) == null) {
                persistencia.escribirNuevaLinea(palabraCastellano.trim().toLowerCase()
                        + "=" + palabraIngles.trim().toLowerCase());

                agregarPalabraDicionario(palabraCastellano, palabraIngles);

                System.out.println("La palabra " + palabraCastellano + " y su significado " + palabraIngles
                        + " Se agregaron correctamente");
            } else {
                System.out.println("La palabra " + palabraCastellano + " ya se encuentra registrada");
            }

        } catch (Exception e) {
            System.out.println("Se presento un error al tratar de registrar la palabra " + palabraCastellano);
        }
    }

    private void agregarPalabraDicionario(String palabraCastellano, String palabraIngles) {
        palabras.put(palabraCastellano, palabraIngles);
    }

    public void mostarPalabrasRegistradas() {
        if (palabras.isEmpty())
            System.out.println("No existen palabras registradas");
        else
            palabras.forEach((k, v) -> System.out.println("palabra: " + k + ", significado " + v + "\n"));
    }

}
