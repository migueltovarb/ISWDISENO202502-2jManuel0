import java.util.ArrayList;

public class SistemaReservas {
    private final ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private final ArrayList<SalaEstudio> salas = new ArrayList<>();
    private final ArrayList<Reserva> reservas = new ArrayList<>();

    public void agregarEstudiante(Estudiante e) { estudiantes.add(e); }
    public void agregarSala(SalaEstudio s) { salas.add(s); }
    public void agregarReserva(Reserva r) { reservas.add(r); }

    public ArrayList<Estudiante> getEstudiantes() { return estudiantes; }
    public ArrayList<SalaEstudio> getSalas() { return salas; }
    public ArrayList<Reserva> getReservas() { return reservas; }
}
