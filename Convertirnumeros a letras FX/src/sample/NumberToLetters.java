package sample;

public class NumberToLetters {

    private final int MAX_VALUE = 9999;
    private int[] digitos;

    private final String[][] letters = {
            {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"},
            {"diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"},
            {"ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seicientos", "setecientos", "ochocientos", "novecientos"},
            {"mil", "dos mil", "tres mil", "cuatro mil", "cinco mil", "seis mil", "siete mil", "ocho mil", "nueve mil"}
    };

    private final String[][] especial = {
            {
                    "diez",
                    "once",
                    "doce",
                    "trece",
                    "catorce",
                    "quince",
                    "dieciséis",
                    "diecisiete",
                    "dieciocho",
                    "diecinueve"
            },
            {
                    "veinte",
                    "veintiuno",
                    "veintidós",
                    "veintitrés",
                    "veinticuatro",
                    "veinticinco",
                    "veintiséis",
                    "veintisiete",
                    "veintiocho",
                    "veintinueve"
            }
    };

    private void inicializaDigitos(int numero) {

        String numeroToString = Integer.toString(numero);

        digitos = new int[numeroToString.length()];
        int j = 0;
        for (int i = numeroToString.length() - 1; i > 0; i--) {
            digitos[j++] = Integer.parseInt(numeroToString.substring(i, i + 1));
        }

        digitos[j] = Integer.parseInt(numeroToString.substring(0, 1));

    }

    private String procesarDecenas() {

        if (1 == digitos.length) {
            return letters[0][digitos[0] - 1];
        } else if (digitos.length >= 2) {
            if ((1 == digitos[1] || 2 == digitos[1])) {
                return especial[digitos[1] - 1][digitos[0]];
            } else {
                StringBuilder sb = new StringBuilder();

                for (int i = 1; i >= 0; i--) {

                    if (0 == digitos[i]) {
                        continue;
                    }

                    sb.append(letters[i][digitos[i] - 1]);
                    sb.append(" y ");

                }
                return sb.substring(0, sb.length() - 2).toString();
            }
        }

        return null;

    }

    private String procesarHastaDecenas() {

        StringBuilder sb = new StringBuilder();
        for (int i = digitos.length - 1; i >= 2; i--) {

            if (0 == digitos[i]) {
                continue;
            }

            sb.append(letters[i][digitos[i] - 1]);

            sb.append(" ");
        }

        return sb.toString();

    }

    public String obtenerLetras() {

        StringBuilder sb = new StringBuilder();
        sb.append(procesarHastaDecenas());
        sb.append(procesarDecenas());
        return sb.toString();
    }

    public NumberToLetters(int numero) {

        if (0 > numero || MAX_VALUE < numero) {
            throw new IllegalArgumentException("Verifique el numero");
        }

        inicializaDigitos(numero);

    }



}
