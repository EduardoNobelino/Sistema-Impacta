package impacta.modelo;

import java.time.LocalDateTime;

public class MutiraoReciclagem extends AcaoSocioambiental {
    private int duracaoHoras;

    public MutiraoReciclagem(int maxVoluntarios, LocalDateTime data, String descricao, String titulo, int id, int duracaoHoras) {
        super(maxVoluntarios, data, descricao, titulo, id);
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public int pontuacao() {
        int pontos = 4 * duracaoHoras;
        return pontos;
    }

    @Override
    public String atributosExtras() {
        String extra = " \nDuração em horas:  " + duracaoHoras;
        return extra;
    }
}
