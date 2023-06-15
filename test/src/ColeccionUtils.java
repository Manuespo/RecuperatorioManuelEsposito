import java.util.List;
import java.util.Map;

public class ColeccionUtils {
    public static int obtenerCantidadElementos(Map<String, List<Jugador>> coleccion, String clave, int numero) throws ExcepcionCantidadElementos {
        List<Jugador> elementos = coleccion.getOrDefault(clave, null);
        if (elementos != null) {
            int cantidad = elementos.size();
            if (cantidad >= numero) {
                int diferencia = cantidad - numero;
                throw new ExcepcionCantidadElementos("Colección: " + coleccion.getClass().getSimpleName() +
                        ", Clave: " + clave + ", Diferencia: " + diferencia, diferencia);
            }
            return cantidad;
        }
        return 0;
    }
}
