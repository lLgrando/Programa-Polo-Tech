public class QuadradoPosProva {

    public static void main(String[] args) {
        verificador();
    }

    // somatorio das linhas
    public static int[] somatorioPorLinhas(int[][] matriz) {
        int[] somaLinhas = new int[matriz.length];
        int numero = somaLinhas.length - 1;
        int numero2 = somaLinhas.length - 1;

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                somaLinhas[linha] += matriz[linha][coluna];
            }
        }

        boolean linhasVerificacao = false;
        for (int k = somaLinhas.length - 1; k > -1; k--) {
            if (somaLinhas[numero] == somaLinhas[numero2]) {
                linhasVerificacao = true;
            } else {
                linhasVerificacao = false;
            }
            numero--;
        }
        return somaLinhas;
    }

    // somatorio das colunas
    public static int[] somatorioPorColuna(int[][] matriz) {
        int[] somaColunas = new int[matriz[0].length];
        int numero = somaColunas.length - 1;
        int numero2 = somaColunas.length - 1;

        for (int i = 0; i < matriz.length; i++) {
            int somaColuna = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                somaColuna += matriz[j][i];
            }
            somaColunas[i] = somaColuna;
        }

        boolean colunasVerificacao = false;
        for (int k = somaColunas.length - 1; k > -1; k--) {
            if (somaColunas[numero] == somaColunas[numero2]) {
                colunasVerificacao = true;
            } else {
                colunasVerificacao = false;
            }
            numero--;
        }
        return somaColunas;
    }

    // somatorio diagonal
    public static int somatorioDiagonalUm(int[][] matriz) {
        int somatorio = 0;

        for (int i = 0, k = 0; i < matriz.length; i++, k++) {
            somatorio += matriz[i][k];
        }
        return somatorio;
    }

    // somatorio diagonal
    public static int somatorioDiagonalDois(int[][] matriz) {
        int somatorio = 0;

        for (int i = matriz.length - 1; i > -1; i--) {
            somatorio += matriz[i][i];
        }
        return somatorio;
    }

    // verificar se é um quadrado mágico
    public static void verificador() {
        int[][] matriz = matriz1();

        int[] linhas = somatorioPorLinhas(matriz);
        int[] coluna = somatorioPorColuna(matriz);
        int diagonalUm = somatorioDiagonalUm(matriz);
        int diagonalDois = somatorioDiagonalDois(matriz);

        boolean verificacaoTrue = false;
        boolean verificacaoFail = true;
        int[] somatorio = new int[(linhas.length + coluna.length + 2)];

        // adiciona as duas diagonais nas posições 0 e 1 do array.
        somatorio[0] = diagonalUm;
        somatorio[1] = diagonalDois;

        int k = 2;
        int l = 0;
        for (int i = 0; i < linhas.length; i++) {
            somatorio[k] = linhas[i];
            k++;
        }

        for (int i = 0; i < coluna.length; i++) {
            somatorio[k] = linhas[i];
            k++;
            l = k;
        }

        for (int o = 0; o < somatorio.length; o++) {
            if (somatorio[k - 1] == somatorio[l - 1]) {
                verificacaoTrue = true;
            } else {
                verificacaoFail = false;
            }
            l--;
        }

        System.out.println("#######################################################");

        if (verificacaoTrue == verificacaoFail) {
            System.out.println("E um quadrado perfeito.");
        } else {
            System.out.println("NAO e um quadrado perfeito.");
        }

        System.out.println();
        System.out.print("Numeros: ");
        for (int valor : somatorio) {
            System.out.print(valor + ", ");
        }

        System.out.println();
        System.out.println("#######################################################");

    }

    public static int[][] matriz1() {
        int[][] matriz = {
                { 20, 6, 7, 17 },
                { 9, 15, 14, 12 },
                { 13, 11, 10, 16 },
                { 8, 18, 19, 5 }
        };
        return matriz;
    }

    public static int[][] matriz2() {
        int[][] matriz = {
                { 1, 1 },
                { 1, 1 }
        };
        return matriz;
    }

    public static int[][] matriz3() {
        int[][] matriz = {
                { 1, 14, 15, 4 },
                { 12, 7, 6, 9 },
                { 8, 11, 10, 5 },
                { 13, 2, 3, 16 }
        };
        return matriz;
    }
}