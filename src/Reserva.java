import java.time.LocalDateTime;

public class Reserva {
    private final Estudiante estudiante;
    private final SalaEstudio sala;
    private final LocalDateTime fechaHora;

    public Reserva(Estudiante estudiante, SalaEstudio sala, LocalDateTime fechaHora) {
        this.estudiante = estudiante;
        this.sala = sala;
        this.fechaHora = fechaHora;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public SalaEstudio getSala() { return sala; }
    public LocalDateTime getFechaHora() { return fechaHora; }

    @Override
    public String toString() {
        return "Reserva de " + estudiante.getNombre() + " en " + sala + " a las " + fechaHora;
    }
}
