public class SalaEstudio {
    private int numeroSala;
    private int capacidadMaxima;
    private boolean disponible;

    public SalaEstudio(int numeroSala, int capacidadMaxima, boolean disponible) {
        this.numeroSala = numeroSala;
        this.capacidadMaxima = capacidadMaxima;
        this.disponible = disponible;
    }

    public int getNumeroSala() { return numeroSala; }
    public void setNumeroSala(int numeroSala) { this.numeroSala = numeroSala; }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Sala " + numeroSala + " (" + (disponible ? "Disponible" : "Ocupada") + ")";
    }
}
