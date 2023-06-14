
public class Lembrete extends ItemAgenda {
	
	
    public Lembrete(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public String getTipo() {
        return "Lembrete";
    }
}
