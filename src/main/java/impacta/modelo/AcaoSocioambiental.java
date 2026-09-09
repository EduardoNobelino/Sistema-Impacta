package impacta.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class AcaoSocioambiental {
    private String titulo;
    private String descricao;
    private LocalDateTime data;
    private int maxVoluntarios;
    private ArrayList<Voluntario> voluntarios = new ArrayList<>();
    private int id;

    public AcaoSocioambiental(int maxVoluntarios, LocalDateTime data, String descricao, String titulo, int id) {
        this.maxVoluntarios = maxVoluntarios;
        this.data = data;
        this.descricao = descricao;
        this.titulo = titulo;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getMaxVoluntarios() {
        return maxVoluntarios;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public abstract int pontuacao();

    public abstract String atributosExtras();

    public void adicionarInscrito(Voluntario voluntario) {
        voluntarios.add(voluntario);
    }

    public String detalhesComun() {
        String nomeInscritos = "";

        for (int i = 0; i < voluntarios.size(); i++) {
            nomeInscritos = nomeInscritos + voluntarios.get(i).getNome() + "\n";
        }

        String detalhes = "- Título: " + titulo + " \nDescrição: " + descricao + " \nData: " + data + " \nPontuação: " + pontuacao() + "\nInscritos:\n" + nomeInscritos + atributosExtras();

        return detalhes;
    }

}
