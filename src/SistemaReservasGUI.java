import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class SistemaReservasGUI extends JFrame {
    private final SistemaReservas sistema = new SistemaReservas();

    private final JTextField txtNombre = new JTextField();
    private final JTextField txtCodigo = new JTextField();
    private final JTextField txtPrograma = new JTextField();

    private final JTextField txtNumeroSala = new JTextField();
    private final JTextField txtCapacidad = new JTextField();
    private final JCheckBox chkDisponible = new JCheckBox("Disponible");

    private final JTextArea txtSalida = new JTextArea();

    public SistemaReservasGUI() {
        setTitle("Sistema de Reservas UCC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        // Panel de entradas
        JPanel panelInputs = new JPanel(new GridLayout(7, 2, 5, 5));
        panelInputs.setBorder(BorderFactory.createTitledBorder("Agregar Datos"));

        panelInputs.add(new JLabel("Nombre Estudiante:"));
        panelInputs.add(txtNombre);

        panelInputs.add(new JLabel("Código Institucional:"));
        panelInputs.add(txtCodigo);

        panelInputs.add(new JLabel("Programa Académico:"));
        panelInputs.add(txtPrograma);

        panelInputs.add(new JLabel("Número de Sala:"));
        panelInputs.add(txtNumeroSala);

        panelInputs.add(new JLabel("Capacidad Máxima:"));
        panelInputs.add(txtCapacidad);

        panelInputs.add(chkDisponible);
        JButton btnGuardar = new JButton("Guardar Datos");
        panelInputs.add(btnGuardar);

        // Área de salida
        txtSalida.setEditable(false);
        txtSalida.setBorder(BorderFactory.createTitledBorder("Historial"));
        JScrollPane scroll = new JScrollPane(txtSalida);

        add(panelInputs);
        add(scroll);

        btnGuardar.addActionListener(e -> guardarDatos());
    }

    private void guardarDatos() {
        try {
            Estudiante est = new Estudiante(
                    txtNombre.getText(),
                    txtCodigo.getText(),
                    txtPrograma.getText()
            );
            SalaEstudio sala = new SalaEstudio(
                    Integer.parseInt(txtNumeroSala.getText()),
                    Integer.parseInt(txtCapacidad.getText()),
                    chkDisponible.isSelected()
            );
            Reserva r = new Reserva(est, sala, LocalDateTime.now());

            sistema.agregarEstudiante(est);
            sistema.agregarSala(sala);
            sistema.agregarReserva(r);

            txtSalida.append(r.toString() + "\n");

            txtNombre.setText("");
            txtCodigo.setText("");
            txtPrograma.setText("");
            txtNumeroSala.setText("");
            txtCapacidad.setText("");
            chkDisponible.setSelected(false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaReservasGUI().setVisible(true));
    }
}
