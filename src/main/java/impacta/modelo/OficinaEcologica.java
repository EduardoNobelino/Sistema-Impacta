package impacta.modelo;

import java.time.LocalDateTime;

public class OficinaEcologica extends AcaoSocioambiental {
    private int duracaoHoras;
    private boolean kitMaterial;

    public OficinaEcologica(int maxVoluntarios, LocalDateTime data, String descricao, String titulo, int id, int duracaoHoras, boolean kitMaterial) {
        super(maxVoluntarios, data, descricao, titulo, id);
        this.duracaoHoras = duracaoHoras;
        this.kitMaterial = kitMaterial;
    }

    @Override
    public int pontuacao() {
        int pontos =  3 * duracaoHoras;

        if (kitMaterial) {
            pontos += 10;
        }

        return pontos;
    }

    @Override
    public String atributosExtras() {
        String extra = " \nDuracao em horas:  " + duracaoHoras + "\nOferece Kit Material Educacional?" + (kitMaterial ? "Sim" : "Não");
        return extra;
    }
}
