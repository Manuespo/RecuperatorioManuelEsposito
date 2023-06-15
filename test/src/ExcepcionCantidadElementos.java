public class ExcepcionCantidadElementos extends Exception {
    private int diferencia;

    public ExcepcionCantidadElementos(String mensaje, int diferencia) {
        super(mensaje);
        this.diferencia = diferencia;
    }

    public int getDiferencia() {
        return diferencia;
    }
}
