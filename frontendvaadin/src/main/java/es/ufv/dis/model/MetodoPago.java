package es.ufv.dis.front.final2025.model;

public class MetodoPago {
    private long numeroTarjeta;
    private String nombreAsociado;

    public MetodoPago(int numeroTarjeta, String nombreAsociado) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreAsociado = nombreAsociado;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getNombreAsociado() {
        return nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
    }

    @Override
    public String toString() {
        return "MetodoPago{" +
                "numeroTarjeta=" + numeroTarjeta +
                ", nombreAsociado='" + nombreAsociado + '\'' +
                '}';
    }
}
