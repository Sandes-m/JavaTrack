package model;

/**
 * Classe responsável por representar os dados de endereço de um cliente.
 * <p>
 * Os dados são recebidos da API ViaCEP e armazenados nos atributos correspondentes.
 * Também permite adicionar número e complemento do endereço, que não são retornados diretamente da API.
 */
public class Endereco {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    private String numero;
    private String complemento;

    /**
     * Construtor para criar um endereço com número e complemento.
     *
     * @param numero      número residencial
     * @param complemento complemento do endereço
     */
    public Endereco(String numero, String complemento) {
        this.numero = numero;
        this.complemento = complemento;
    }

    /**
     * Getters e Setters
     * <p>
     * Métodos para acessar e modificar os atributos específicos do endereço.
     */
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Retorna uma representação em "String" do objeto Endereço, com todas as informações formatadas.
     *
     * @return "String" com os dados do endereço
     */
    @Override
    public String toString() {
        return "Endereço: " + getLogradouro() + "\n"
                + "Número: " + getNumero() + "\n"
                + "Bairro: " + getBairro() + "\n"
                + "Complemento: " + getComplemento() + "\n"
                + "Cidade: " + getLocalidade() + "\n"
                + "Estado: " + getUf() + "\n";
    }
}
