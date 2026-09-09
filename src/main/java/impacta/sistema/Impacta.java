package impacta.sistema;
import impacta.exceptions.*;
import impacta.modelo.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Impacta {
    private HashMap<String, Voluntario> voluntarios = new HashMap<>();
    private HashMap<Integer, AcaoSocioambiental> acoes = new HashMap<>();
    private int proximoId = 1;


    public boolean cadastrarVoluntario(String nome, String email, String matricula) throws EmailDuplicadoException {
        if (voluntarios.containsKey(email)) {
            throw new EmailDuplicadoException("Email já cadastrado");
        }

        voluntarios.put(email, new Voluntario(nome, email, matricula));

        return true;
    }

    public String exibirVoluntario(String email) throws EmailInexistenteException {
        if (!voluntarios.containsKey(email)) {
            throw new EmailInexistenteException("Email inexistente ou voluntário não cadastrado.");
        }

        return voluntarios.get(email).exibirDescricao();
    }

    public String[] listarVoluntarios() {
        List<Voluntario> lista = new ArrayList<>(voluntarios.values());

        Comparator<Voluntario> ranking = Comparator.comparingDouble(Voluntario::getPontuacaoAcumulada).reversed().thenComparing(Voluntario::getNome);
        lista.sort(ranking);

        String[] resultado = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            resultado[i] = lista.get(i).exibirDescricao();
        }

        return resultado;
    }

    public int cadastrarPlantio(String titulo, String descricao, String data, int maxVoluntarios, int qtdMudas) {
        int id = proximoId;

        LocalDateTime localDateTime = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        AcaoSocioambiental acao = new Plantio(maxVoluntarios, localDateTime, descricao, titulo, id, qtdMudas);
        acoes.put(id, acao);

        proximoId++;

        return id;
    }

    public int cadastrarMutirao(String titulo, String descricao, String data, int maxVoluntarios, int duracaoHoras) {
        int id = proximoId;

        LocalDateTime localDateTime = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        AcaoSocioambiental acao = new MutiraoReciclagem(maxVoluntarios, localDateTime, descricao, titulo, id, duracaoHoras);
        acoes.put(id, acao);

        proximoId++;

        return id;
    }

    public int cadastrarOficina(String titulo, String descricao, String data, int maxVoluntarios, int duracaoHoras, boolean kitMaterial) {
        int id = proximoId;

        LocalDateTime localDateTime = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        AcaoSocioambiental acao = new OficinaEcologica(maxVoluntarios, localDateTime, descricao, titulo, id, duracaoHoras, kitMaterial);
        acoes.put(id, acao);

        proximoId++;

        return id;
    }

    public boolean inscreverVoluntario(String email, int id) {
        if (!acoes.containsKey(id)) {
            throw new AcaoInexistenteException("Ação não encontrada!");
        }

        if (!voluntarios.containsKey(email)) {
            throw new EmailInexistenteException("Email inexistente!");
        }

        Voluntario voluntario = voluntarios.get(email);
        AcaoSocioambiental acao = acoes.get(id);

        if (acao.getVoluntarios().contains(voluntario)) {
            throw new InscricaoDuplicadaException("Você já está inscrito!");
        }

        if (acao.getVoluntarios().size() == acao.getMaxVoluntarios()) {
            throw new AcaoLotadaException("Ação lotada!");
        }

        acao.adicionarInscrito(voluntario);
        voluntario.registrarParticipacao(acao.pontuacao());

        return true;

    }

    public String exibirDetalhesAcao(int idAcao) {
        if (!acoes.containsKey(idAcao)) {
            throw new AcaoInexistenteException("Acao inexistente!");
        }

        return acoes.get(idAcao).detalhesComun();
    }
}
