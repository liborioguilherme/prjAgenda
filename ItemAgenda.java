
public abstract class ItemAgenda {
	 private String titulo;
	    private String descricao;

	    public ItemAgenda(String titulo, String descricao) {
	        this.titulo = titulo;
	        this.descricao = descricao;
	    }

	    public String getTitulo() {
	        return titulo;
	    }	

	    public String getDescricao() {
	        return descricao;
	    }

	    public abstract String getTipo();
	}


