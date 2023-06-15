import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        ColeccionesOrdenadas colecciones = new ColeccionesOrdenadas();
        try {
            File file = new File("jugadores.json");
            ObjectMapper mapper = new ObjectMapper();
            Jugador[] lista = mapper.readValue(file, Jugador[].class);

            for (Jugador j : lista) {
                colecciones.agregarJugador(j);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            int cantidadAzul = ColeccionUtils.obtenerCantidadElementos(colecciones.getColeccionColorOjos(), "Azul", 3);
            System.out.println("Cantidad de jugadores con ojos azules: " + cantidadAzul);
        } catch (ExcepcionCantidadElementos e) {
            System.out.println("Se encontraron más jugadores de los esperados en la colección: " + e.getMessage());
            System.out.println("Diferencia: " + e.getDiferencia());
        }
        double sueldoMinimo = 2000.0;

        List<Jugador> jugadoresFiltrados = new ArrayList<>();
        for (Jugador jugador : colecciones.getColeccionPosicion()) {
            double balance = Double.parseDouble(jugador.getBalance());
            if (balance > sueldoMinimo) {
                jugadoresFiltrados.add(jugador);
            }
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("jugadores.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(jugadoresFiltrados);
            objectOut.close();
            System.out.println("Los jugadores se han guardado en el archivo jugadores.bin.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}