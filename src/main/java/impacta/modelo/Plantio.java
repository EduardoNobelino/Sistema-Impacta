package impacta.modelo;

import java.time.LocalDateTime;

public class Plantio extends AcaoSocioambiental {
    private int qtdMudas = 0;

    public Plantio(int maxVoluntarios, LocalDateTime data, String descricao, String titulo, int id, int qtdMudas) {
        super(maxVoluntarios, data, descricao, titulo, id);
        this.qtdMudas = qtdMudas;
    }

    @Override
    public int pontuacao() {
        int pontos = 5 + 2 * qtdMudas;
        return pontos;
    }

    @Override
    public String atributosExtras() {
        String extra = " \nQuantidade de Mudas: " + qtdMudas;
        return extra;
    }
}
