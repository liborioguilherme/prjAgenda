import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        while (true) {
            String[] opcoes = { "Criar", "Consultar", "Deletar", "Sair" };
            String escolha = (String) JOptionPane.showInputDialog(null, "Selecione uma opção:", "Agenda", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == null || escolha.equals("Sair")) {
                JOptionPane.showMessageDialog(null, "Encerrando a agenda...", "Agenda", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            switch (escolha) {
                case "Criar":
                    criarItem(agenda);
                    break;
                case "Consultar":
                    consultarItens(agenda);
                    break;
                case "Deletar":
                    deletarItem(agenda);
                    break;
            }
        }
    }

    public static void criarItem(Agenda agenda) {
        String[] opcoes = { "Lembrete", "Evento", "Tarefa", "Contato" };
        String escolha = (String) JOptionPane.showInputDialog(null, "Selecione o tipo de item que deseja criar:", "Criar Item", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha != null) {
            switch (escolha) {
                case "Lembrete":
                    agenda.criarLembrete();
                    break;
                case "Evento":
                    agenda.criarEvento();
                    break;
                case "Tarefa":
                    agenda.criarTarefa();
                    break;
                case "Contato":
                    agenda.criarContato();
                    break;
            }
        }
    }

    public static void consultarItens(Agenda agenda) {
        agenda.consultarItens();
    }

    public static void deletarItem(Agenda agenda) {
        String[] opcoes = { "Item", "Contato" };
        String escolha = (String) JOptionPane.showInputDialog(null, "Selecione o tipo de informação que deseja deletar:", "Deletar", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha != null) {
            switch (escolha) {
                case "Item":
                    agenda.deletarItem();
                    break;
                case "Contato":
                    agenda.deletarContato();
                    break;
            }
        }
    }
}
