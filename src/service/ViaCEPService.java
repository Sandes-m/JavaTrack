package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.EnvVarNotFoundException;
import model.Endereco;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe responsável por buscar informações de endereço a partir de um CEP.
 * <p>
 * Utiliza a API ViaCEP e realiza a conversão do JSON retornado em objetos da classe Endereco.
 */
public class ViaCEPService {

    /**
     * Busca o endereço correspondente ao CEP informado utilizando a API ViaCEP.
     * <p>
     * A URL da API deve estar configurada na variável de ambiente "VIACEP_URL".
     * Caso a variável não esteja definida, uma exceção EnvVarNotFoundException é lançada.
     *
     * @param cep CEP do endereço a ser localizado
     * @return objeto Endereco preenchido com os dados da API ou null se não encontrado
     * @throws EnvVarNotFoundException se a variável de ambiente da API não estiver configurada
     * @throws RuntimeException        se houver falha na requisição HTTP
     */
    public Endereco buscarEndereco(String cep) {

        // Variável de ambiente para a URL base da API ViaCEP
        String viaCepApi = System.getenv("VIACEP_URL");

        // Verifica se a variável de ambiente está configurada
        if (viaCepApi == null || viaCepApi.isEmpty()) {
            throw new EnvVarNotFoundException("Váriavel de ambiente (VIACEP_URL) não configurada nesse dispositivo");
        }

        // Monta a URL completa para a requisição
        String url = viaCepApi + cep
                .replace("-", "") + "/json/";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Executa a requisição HTTP e trata os diferentes retornos
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();

                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();

                Endereco enderecoLocalizado = gson.fromJson(json, Endereco.class);

                return enderecoLocalizado;

            } else if (response.statusCode() == 404) {
                System.out.println("\nEndereço não localizado!" + response.statusCode());
                return null;
            } else {
                System.out.println("\nError " + response.statusCode());
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException("Falha na requisição HTTP", e);

        }

    }

}
