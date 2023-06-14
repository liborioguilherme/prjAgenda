import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

class Agenda {
    private List<ItemAgenda> itens;
    private List<Contato> contatos;

    public Agenda() {
        itens = new ArrayList<>();
        contatos = new ArrayList<>();
    }

    public void criarLembrete() {
        String titulo = JOptionPane.showInputDialog(null, "Digite o título do lembrete:", "Criar Lembrete", JOptionPane.PLAIN_MESSAGE);
        String descricao = JOptionPane.showInputDialog(null, "Digite a descrição do lembrete:", "Criar Lembrete", JOptionPane.PLAIN_MESSAGE);
        Lembrete lembrete = new Lembrete(titulo, descricao);
        itens.add(lembrete);
        JOptionPane.showMessageDialog(null, "Lembrete criado com sucesso!", "Criar Lembrete", JOptionPane.INFORMATION_MESSAGE);
    }

    public void criarEvento() {
        String titulo = JOptionPane.showInputDialog(null, "Digite o título do evento:", "Criar Evento", JOptionPane.PLAIN_MESSAGE);
        String descricao = JOptionPane.showInputDialog(null, "Digite a descrição do evento:", "Criar Evento", JOptionPane.PLAIN_MESSAGE);
        String data = JOptionPane.showInputDialog(null, "Digite a data do evento (DD/MM/AAAA):", "Criar Evento", JOptionPane.PLAIN_MESSAGE);
        String horario = JOptionPane.showInputDialog(null, "Digite o horário do evento:", "Criar Evento", JOptionPane.PLAIN_MESSAGE);
        Evento evento = new Evento(titulo, descricao, data, horario);
        itens.add(evento);
        JOptionPane.showMessageDialog(null, "Evento criado com sucesso!", "Criar Evento", JOptionPane.INFORMATION_MESSAGE);
    }

    public void criarTarefa() {
        String titulo = JOptionPane.showInputDialog(null, "Digite o título da tarefa:", "Criar Tarefa", JOptionPane.PLAIN_MESSAGE);
        String descricao = JOptionPane.showInputDialog(null, "Digite a descrição da tarefa:", "Criar Tarefa", JOptionPane.PLAIN_MESSAGE);
        String dataLimite = JOptionPane.showInputDialog(null, "Digite a data limite da tarefa (DD/MM/AAAA):", "Criar Tarefa", JOptionPane.PLAIN_MESSAGE);
        Tarefa tarefa = new Tarefa(titulo, descricao, dataLimite);
        itens.add(tarefa);
        JOptionPane.showMessageDialog(null, "Tarefa criada com sucesso!", "Criar Tarefa", JOptionPane.INFORMATION_MESSAGE);
    }

    public void criarContato() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do contato:", "Criar Contato", JOptionPane.PLAIN_MESSAGE);
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do contato:", "Criar Contato", JOptionPane.PLAIN_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "Digite o email do contato:", "Criar Contato", JOptionPane.PLAIN_MESSAGE);
        String endereco = JOptionPane.showInputDialog(null, "Digite o endereço do contato:", "Criar Contato", JOptionPane.PLAIN_MESSAGE);
        Contato contato = new Contato(nome, telefone, email, endereco);
        contatos.add(contato);
        JOptionPane.showMessageDialog(null, "Contato criado com sucesso!", "Criar Contato", JOptionPane.INFORMATION_MESSAGE);
    }

    public void consultarItens() {
        if (itens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há itens na agenda.", "Consultar Itens", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensagem = new StringBuilder();
            for (ItemAgenda item : itens) {
                mensagem.append("Tipo: ").append(item.getTipo()).append("\n");
                mensagem.append("Título: ").append(item.getTitulo()).append("\n");
                mensagem.append("Descrição: ").append(item.getDescricao()).append("\n");
                if (item instanceof Evento) {
                    Evento evento = (Evento) item;
                    mensagem.append("Data: ").append(evento.getData()).append("\n");
                    mensagem.append("Horário: ").append(evento.getHorario()).append("\n");
                } else if (item instanceof Tarefa) {
                    Tarefa tarefa = (Tarefa) item;
                    mensagem.append("Data Limite: ").append(tarefa.getDataLimite()).append("\n");
                }
                mensagem.append("--------------------\n");
            }
            JOptionPane.showMessageDialog(null, mensagem.toString(), "Itens na Agenda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void consultarContatos() {
        if (contatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há contatos na agenda.", "Consultar Contatos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensagem = new StringBuilder();
            for (Contato contato : contatos) {
                mensagem.append("Nome: ").append(contato.getNome()).append("\n");
                mensagem.append("Telefone: ").append(contato.getTelefone()).append("\n");
                mensagem.append("Email: ").append(contato.getEmail()).append("\n");
                mensagem.append("Endereço: ").append(contato.getEndereco()).append("\n");
                mensagem.append("--------------------\n");
            }
            JOptionPane.showMessageDialog(null, mensagem.toString(), "Contatos na Agenda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deletarItem() {
        if (itens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há itens na agenda para serem deletados.", "Deletar Item", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String[] opcoes = new String[itens.size()];
            for (int i = 0; i < itens.size(); i++) {
                ItemAgenda item = itens.get(i);
                opcoes[i] = item.getTipo() + ": " + item.getTitulo();
            }
            String escolha = (String) JOptionPane.showInputDialog(null, "Selecione o item que deseja deletar:", "Deletar Item", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            if (escolha != null) {
                for (int i = 0; i < itens.size(); i++) {
                    ItemAgenda item = itens.get(i);
                    if ((item.getTipo() + ": " + item.getTitulo()).equals(escolha)) {
                        itens.remove(i);
                        JOptionPane.showMessageDialog(null, "Item deletado com sucesso!", "Deletar Item", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }
        }
    }

    public void deletarContato() {
        if (contatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há contatos na agenda para serem deletados.", "Deletar Contato", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String[] opcoes = new String[contatos.size()];
            for (int i = 0; i < contatos.size(); i++) {
                Contato contato = contatos.get(i);
                opcoes[i] = contato.getNome();
            }
            String escolha = (String) JOptionPane.showInputDialog(null, "Selecione o contato que deseja deletar:", "Deletar Contato", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            if (escolha != null) {
                for (int i = 0; i < contatos.size(); i++) {
                    Contato contato = contatos.get(i);
                    if (contato.getNome().equals(escolha)) {
                        contatos.remove(i);
                        JOptionPane.showMessageDialog(null, "Contato deletado com sucesso!", "Deletar Contato", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }
        }
    }
}
	