public class Estudiante {
    private String nombre;
    private String codigoInstitucional;
    private String programaAcademico;

    public Estudiante(String nombre, String codigoInstitucional, String programaAcademico) {
        this.nombre = nombre;
        this.codigoInstitucional = codigoInstitucional;
        this.programaAcademico = programaAcademico;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigoInstitucional() { return codigoInstitucional; }
    public void setCodigoInstitucional(String codigoInstitucional) { this.codigoInstitucional = codigoInstitucional; }

    public String getProgramaAcademico() { return programaAcademico; }
    public void setProgramaAcademico(String programaAcademico) { this.programaAcademico = programaAcademico; }

    @Override
    public String toString() {
        return nombre + " (" + codigoInstitucional + ")";
    }
}
