package co.sofka.traductor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControlPersistencia {
    private static final String nombreArchivo = "palabras.txt";
    private List<String> lineasArchivo = new ArrayList<>();

    public List<String> obtenerContenidoArchivo() {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(nombreArchivo);
            bufferedReader = new BufferedReader(fileReader);

            String contenidoLinea = bufferedReader.readLine();
            while (contenidoLinea != null) {
                lineasArchivo.add(contenidoLinea);
                contenidoLinea = bufferedReader.readLine();
            }

            return lineasArchivo;
        } catch (Exception e) {
            System.out.println("Problemas al localizar el archivo palabras.txt");
            e.printStackTrace();
            return new ArrayList<>();

        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void escribirNuevaLinea(String contenido) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nombreArchivo, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + contenido);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
