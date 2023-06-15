import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ColeccionesOrdenadas {
    private Map<String, List<Jugador>> coleccionColorOjos;
    private Map<String, List<Jugador>> coleccionPosicion;

    public ColeccionesOrdenadas() {
        coleccionColorOjos = new LinkedHashMap<>();
        coleccionPosicion = new LinkedHashMap<>();
    }

    public void agregarJugador(Jugador jugador) {
        String eyeColor = jugador.getEyeColor();
        if (coleccionColorOjos.containsKey(eyeColor)) {
            coleccionColorOjos.get(eyeColor).add(jugador);
        } else {
            List<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugador);
            coleccionColorOjos.put(eyeColor, jugadores);
        }

        String position = jugador.getPosition();
        if (coleccionPosicion.containsKey(position)) {
            coleccionPosicion.get(position).add(jugador);
        } else {
            List<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugador);
            coleccionPosicion.put(position, jugadores);
        }
    }

    public List<Jugador> obtenerJugadoresPorColorOjos(String colorOjos) {
        return coleccionColorOjos.getOrDefault(colorOjos, new ArrayList<>());
    }

    public List<Jugador> obtenerJugadoresPorPosicion(String posicion) {
        return coleccionPosicion.getOrDefault(posicion, new ArrayList<>());
    }

    public void listarJugadoresPorColorOjos() {
        for (Map.Entry<String, List<Jugador>> entry : coleccionColorOjos.entrySet()) {
            String colorOjos = entry.getKey();
            List<Jugador> jugadores = entry.getValue();

            System.out.println("Color de ojos: " + colorOjos);
            for (Jugador jugador : jugadores) {
                System.out.println("Nombre: " + jugador.getName() + ", Posición: " + jugador.getPosition());
            }
            System.out.println();
        }
    }

    public void listarJugadoresPorPosicion() {
        for (Map.Entry<String, List<Jugador>> entry : coleccionPosicion.entrySet()) {
            String posicion = entry.getKey();
            List<Jugador> jugadores = entry.getValue();

            System.out.println("Posición: " + posicion);
            for (Jugador jugador : jugadores) {
                System.out.println("Nombre: " + jugador.getName() + ", Color de ojos: " + jugador.getEyeColor());
            }
            System.out.println();
        }
    }

    public int contarJugadoresPorColorOjos(String colorOjos) {
        List<Jugador> jugadores = coleccionColorOjos.getOrDefault(colorOjos, new ArrayList<>());
        return jugadores.size();
    }

    public Map<String, List<Jugador>> getColeccionColorOjos() {
        return coleccionColorOjos;
    }

    public void setColeccionColorOjos(Map<String, List<Jugador>> coleccionColorOjos) {
        this.coleccionColorOjos = coleccionColorOjos;
    }

    public Map<String, List<Jugador>> getColeccionPosicion() {
        return coleccionPosicion;
    }

    public void setColeccionPosicion(Map<String, List<Jugador>> coleccionPosicion) {
        this.coleccionPosicion = coleccionPosicion;
    }

}
