package testIdentifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class IdentifierTest {

    private Identifier identifier;

    @BeforeEach
    void setUp() {

        identifier = new Identifier();
    }


    @Test
    @DisplayName("TC1 - Identificador com 1 letra ('S') deve ser Valido")
    void tc1_identificadorComUmaLetra() {
        // Setup: dado de entrada definido pela planilha (Test Data = "S")
        String entrada = "S";

        // Invocation: executa o metodo validador com a entrada do caso de teste
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: resultado esperado = Valido (true)
        assertTrue(resultado, "Identificador de 1 letra deveria ser valido");
    }

    @Test
    @DisplayName("TC2 - Somente letras ('model') deve ser Valido")
    void tc2_somenteLetras() {
        // Setup
        String entrada = "model";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment
        assertTrue(resultado, "Identificador composto apenas por letras deveria ser valido");
    }

    @Test
    @DisplayName("TC3 - Letras e digitos ('p2p') deve ser Valido")
    void tc3_letrasEDigitos() {
        // Setup
        String entrada = "p2p";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment
        assertTrue(resultado, "Identificador com letra inicial seguida de letras/digitos deveria ser valido");
    }

    @Test
    @DisplayName("TC4 - Identificador com 6 caracteres ('abcdef') deve ser Valido")
    void tc4_identificadorComSeisCaracteres() {
        // Setup
        String entrada = "abcdef";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: valor limite superior da classe valida (6 caracteres)
        assertTrue(resultado, "Identificador com exatamente 6 caracteres deveria ser valido");
    }


    @Test
    @DisplayName("TC5 - Identificador com 7 caracteres ('abcdefg') deve ser Invalido")
    void tc5_identificadorComSeteCaracteres() {
        // Setup
        String entrada = "abcdefg";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: valor limite logo acima do maximo permitido (7 caracteres)
        assertFalse(resultado, "Identificador com 7 caracteres deveria ser invalido");
    }


    @Test
    @DisplayName("TC6 - Identificador vazio ('') deve ser Invalido")
    void tc6_identificadorVazio() {
        // Setup
        String entrada = "";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: valor limite inferior (0 caracteres)
        assertFalse(resultado, "Identificador vazio deveria ser invalido");
    }


    @Test
    @DisplayName("TC7 - Inicia com digito ('100tidez') deve ser Invalido")
    void tc7_iniciaComDigito() {
        // Setup
        String entrada = "100tidez";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: viola a regra de caractere inicial (deve ser letra)
        assertFalse(resultado, "Identificador iniciado por digito deveria ser invalido");
    }

    @Test
    @DisplayName("TC8 - Contem simbolo especial ('Te@st') deve ser Invalido")
    void tc8_contemSimboloEspecial() {
        // Setup
        String entrada = "Te@st";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: viola a regra de tipos de caracteres permitidos
        assertFalse(resultado, "Identificador com simbolo especial deveria ser invalido");
    }


    @Test
    @DisplayName("TC9 - Contem espaco ('abc def') deve ser Invalido")
    void tc9_contemEspaco() {
        // Setup
        String entrada = "abc def";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment
        assertFalse(resultado, "Identificador contendo espaco deveria ser invalido");
    }


    @Test
    @DisplayName("TC10 - Comeca com espaco (' 6seven') deve ser Invalido")
    void tc10_comecaComEspaco() {
        // Setup: dado de entrada exatamente como consta na planilha
        // (primeiro caractere e um espaco em branco)
        String entrada = " 6seven";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: viola a regra de caractere inicial (deve ser letra)
        assertFalse(resultado, "Identificador iniciado por espaco deveria ser invalido");
    }


    @Test
    @DisplayName("TC11 - Muito grande ('stringmuitogrande') deve ser Invalido")
    void tc11_muitoGrande() {
        // Setup
        String entrada = "stringmuitogrande";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: excede o comprimento maximo permitido
        assertFalse(resultado, "Identificador com mais de 6 caracteres deveria ser invalido");
    }

    @Test
    @DisplayName("TC12 - Contem hifen ('abc-12') deve ser Invalido")
    void tc12_contemHifen() {
        // Setup
        String entrada = "abc-12";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment
        assertFalse(resultado, "Identificador com hifen deveria ser invalido");
    }

    @Test
    @DisplayName("TC13 - Contem underscore ('abc_12') deve ser Invalido")
    void tc13_contemUnderscore() {
        // Setup
        String entrada = "abc_12";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment
        assertFalse(resultado, "Identificador com underscore deveria ser invalido");
    }

    @Test
    @DisplayName("TC14 - Letras maiusculas ('ABC123') deve ser Valido")
    void tc14_letrasMaiusculas() {
        // Setup
        String entrada = "ABC123";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment
        assertTrue(resultado, "Identificador com letras maiusculas e digitos deveria ser valido");
    }


    @Test
    @DisplayName("TC15 - 6 caracteres validos ('a12345') deve ser Valido")
    void tc15_seisCaracteresValidos() {
        // Setup
        String entrada = "a12345";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: letra inicial + digitos, no limite superior de comprimento
        assertTrue(resultado, "Identificador com 6 caracteres (letra + digitos) deveria ser valido");
    }


    @Test
    @DisplayName("TC16 - Formado somente por numeros ('123456') deve ser Invalido")
    void tc16_somenteNumeros() {
        // Setup
        String entrada = "123456";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment: viola a regra de caractere inicial (deve ser letra, nao digito)
        assertFalse(resultado, "Identificador formado somente por numeros deveria ser invalido");
    }

    // Caso adicional
    @Test
    @DisplayName("Valor limite - 0 caracteres deve ser Invalido")
    void valorLimite_zeroCaracteres() {
        // Setup
        String entrada = "";

        // Invocation
        boolean resultado = identifier.validateIdentifier(entrada);

        // Assessment
        assertFalse(resultado, "Limite inferior (0 caracteres) deveria ser invalido");
    }
}
