package service;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class NationalityService {

    /**
     * Classe responsável por identificar a nacionalidade do número de telefone.
     * <p>
     * Utiliza a biblioteca libphonenumber do Google para analisar o número e determinar se é brasileiro ou estrangeiro,
     * a sua principal função é validar o número antes de prosseguir com o cadastro do usuário.
     */
    private final PhoneNumberUtil phoneUtil;

    public NationalityService() {
        this.phoneUtil = PhoneNumberUtil.getInstance();
    }

    /**
     * Verifica se o número informado pertence a um país estrangeiro.
     *
     * @param numero número de telefone informado pelo usuário (deve conter o código do país, ex: +5511999999999)
     * @return true se o número for estrangeiro e false se for brasileiro
     * @throws NumberParseException caso o número não contenha código de país ou seja inválido
     */
    public boolean isForeignNumber(String numero) throws NumberParseException {

        Phonenumber.PhoneNumber numeroConvertido = phoneUtil.parse(numero, null);
        String codigoRegional = phoneUtil.getRegionCodeForNumber(numeroConvertido);
        if (codigoRegional == null) {
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE,
                    "AVISO: Número inválido ou sem código do país");
        }

        return !codigoRegional.equals("BR");

    }

}
