package impacta.modelo;

public class Voluntario {
    private String nome;
    private String email;
    private String matricula;
    private int qntAcoes = 0;
    private double pontuacaoAcumulada = 0;

    public Voluntario(String nome, String email, String matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPontuacaoAcumulada() {
        return pontuacaoAcumulada;
    }

    public int getQntAcoes() {
        return qntAcoes;
    }

    public String exibirDescricao() {
        String detalhes = nome + "\nAções: " + qntAcoes + "\nPontuação: " + pontuacaoAcumulada;
        return detalhes;
    }

    public void registrarParticipacao(double pontosDaAcao) {
        qntAcoes+= 1;
        pontuacaoAcumulada += pontosDaAcao;
    }

}
