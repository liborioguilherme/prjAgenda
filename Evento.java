
public class Evento extends ItemAgenda {
	private String data;
    private String horario;

    public Evento(String titulo, String descricao, String data, String horario) {
        super(titulo, descricao);
        this.data = data;
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String getTipo() {
        return "Evento";
    }
}

