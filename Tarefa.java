public class Tarefa extends ItemAgenda {
	private String dataLimite;

	public Tarefa(String titulo, String descricao, String dataLimite) {
		super(titulo, descricao);
		this.dataLimite = dataLimite;
	}

	public String getDataLimite() {
		return dataLimite;
	}

	@Override
	public String getTipo() {
		return "Tarefa";
	}
}
