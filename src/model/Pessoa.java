package model;

/**
 * Classe que representa uma pessoa com informações básicas de cadastro.
 * <p>
 * Contém atributos como nome, CPF, data de nascimento e telefone,
 * além de métodos para acessar e alterar esses dados.
 */
public class Pessoa {

    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private String telefone;

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome             Nome completo
     * @param cpf              CPF válido contendo apenas números
     * @param telefone         Número de telefone
     * @param dataDeNascimento Data de nascimento
     */
    public Pessoa(String nome, String cpf, String telefone, String dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * @return o nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getters e Setters
     * <p>
     * Métodos para acessar (get) e modificar (set) os atributos da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna uma representação em "String" do objeto Pessoa, com todas as informações formatadas.
     *
     * @return "String" com os dados da pessoa
     */
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Data de Nascimento: " + getDataDeNascimento() + "\n"
                + "Telefone: " + getTelefone() + "\n";
    }

}
