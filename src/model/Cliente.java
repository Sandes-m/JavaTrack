package model;

/**
 * Classe que representa um cliente, que é uma Pessoa com informações adicionais de contato.
 * <p>
 * Contém atributos de endereço, e-mail principal e e-mail de recuperação.
 * Extende a classe Pessoa herdando nome, CPF, telefone e data de nascimento.
 */

public class Cliente extends Pessoa {

    /**
     * Atributos específicos do cliente:
     * - endereco: Objeto Endereco já preenchido com informações via API
     * - e-mail: E-mail principal do cliente
     * - emailDeRecuperacao: E-mail de recuperação (opcional)
     */
    private Endereco endereco;
    private String email;
    private String emailDeRecuperacao;

    /**
     * Construtor da classe Cliente.
     *
     * @param nome             Nome do cliente
     * @param cpf              CPF do cliente
     * @param telefone         Telefone do cliente
     * @param dataDeNascimento Data de nascimento do cliente
     * @param email            E-mail principal do cliente
     * @param endereco         Endereço completo do cliente
     */
    public Cliente(String nome, String cpf, String telefone, String dataDeNascimento, String email, Endereco endereco) {

        super(nome, cpf, telefone, dataDeNascimento);
        this.endereco = endereco;
        this.email = email;

    }

    /**
     * Getters e Setters
     * <p>
     * Métodos para acessar e modificar os atributos específicos do cliente.
     */
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailDeRecuperacao() {
        return emailDeRecuperacao;
    }

    public void setEmailDeRecuperacao(String emailDeRecuperacao) {
        this.emailDeRecuperacao = emailDeRecuperacao;
    }

    /**
     * Retorna uma representação em "String" do objeto Cliente,
     * incluindo informações herdadas da Pessoa e atributos adicionais.
     *
     * @return "String" com os dados do cliente
     */
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Data de Nascimento: " + getDataDeNascimento() + "\n"
                + "Telefone: " + getTelefone() + "\n"
                + getEndereco() + "\n"
                + "E-mail: " + getEmail() + "\n"
                + "E-mail de Recuperação: " +
                (getEmailDeRecuperacao() != null ? getEmailDeRecuperacao() : "E-mail de recuparção não informado")
                + "\n";
    }
}
