/**
 * Classe que gerencia a lógica do jogo Batalha Naval
 * Controla os tabuleiros, validação de jogadas e sistema de turnos
 */
public class BatalhaNavalLogic {
    private static final int TAMANHO_TABULEIRO = 10;
    private static final int AGUA = 0;
    private static final int NAVIO = 1;
    private static final int ACERTO = 2;
    private static final int ERRO = 3;
    public static final String MSG_TIRO = "TIRO";
    public static final String MSG_ACERTO = "ACERTO";
    public static final String MSG_ERRO = "ERRO";

    private int[][] meuTabuleiro;
    private int[][] tabuleiroInimigo;
    private int[][] estadoTabuleinoMeu;
    private int[][] estadotabuleiroInimigo;

    private boolean minhaVez;
    private int naviosDestruidos;
    private int naviosInimigosDestruidos;

    public BatalhaNavalLogic() {
        inicializarTabuleiros();
    }

    private void inicializarTabuleiros() {
        meuTabuleiro = new int[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        tabuleiroInimigo = new int[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        estadoTabuleinoMeu = new int[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        estadotabuleiroInimigo = new int[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];

        preencherComAgua(meuTabuleiro);
        preencherComAgua(tabuleiroInimigo);
        preencherComAgua(estadoTabuleinoMeu);
        preencherComAgua(estadotabuleiroInimigo);

        minhaVez = true;
        naviosDestruidos = 0;
        naviosInimigosDestruidos = 0;
    }

    private void preencherComAgua(int[][] tabuleiro) {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = AGUA;
            }
        }
    }

    /**
     * Posiciona um navio no tabuleiro
     * @param linha Linha inicial do navio
     * @param coluna Coluna inicial do navio
     * @param tamanho Tamanho do navio
     * @param horizontal true para horizontal, false para vertical
     * @return true se foi posicionado com sucesso
     */
    public boolean posicionarNavio(int linha, int coluna, int tamanho, boolean horizontal) {
        if (!validarPosicaoNavio(linha, coluna, tamanho, horizontal)) {
            return false;
        }

        if (horizontal) {
            for (int j = coluna; j < coluna + tamanho; j++) {
                meuTabuleiro[linha][j] = NAVIO;
            }
        } else {
            for (int i = linha; i < linha + tamanho; i++) {
                meuTabuleiro[i][coluna] = NAVIO;
            }
        }

        return true;
    }

    private boolean validarPosicaoNavio(int linha, int coluna, int tamanho, boolean horizontal) {
        if (horizontal) {
            if (coluna + tamanho > TAMANHO_TABULEIRO) return false;
            for (int j = coluna; j < coluna + tamanho; j++) {
                if (meuTabuleiro[linha][j] != AGUA) return false;
            }
        } else {
            if (linha + tamanho > TAMANHO_TABULEIRO) return false;
            for (int i = linha; i < linha + tamanho; i++) {
                if (meuTabuleiro[i][coluna] != AGUA) return false;
            }
        }
        return true;
    }

    /**
     * Verifica a jogada na posição indicada
     * @param linha Linha do ataque
     * @param coluna Coluna do ataque
     * @return 0 para erro, 1 para acerto, -1 para jogada inválida
     */
    public int verificarJogada(int linha, int coluna) {
        if (estadotabuleiroInimigo[linha][coluna] != AGUA) {
            return -1; // Já foi atacado
        }

        if (tabuleiroInimigo[linha][coluna] == NAVIO) {
            estadotabuleiroInimigo[linha][coluna] = ACERTO;
            naviosInimigosDestruidos++;
            System.out.println("[LOCAL] Acerto em (" + linha + ", " + coluna + ")!");
            return 1; // Acerto
        } else {
            estadotabuleiroInimigo[linha][coluna] = ERRO;
            System.out.println("[LOCAL] Erro em (" + linha + ", " + coluna + ")!");
            return 0; // Erro
        }
    }

    /**
     * Simula o turno do inimigo (com IA aleatória)
     */
    public void turnoInimigo() {
        int linha, coluna;
        boolean posicaoValida;

        do {
            linha = (int) (Math.random() * TAMANHO_TABULEIRO);
            coluna = (int) (Math.random() * TAMANHO_TABULEIRO);
            posicaoValida = estadoTabuleinoMeu[linha][coluna] == AGUA;
        } while (!posicaoValida);

        if (meuTabuleiro[linha][coluna] == NAVIO) {
            estadoTabuleinoMeu[linha][coluna] = ACERTO;
            naviosDestruidos++;
            System.out.println("[INIMIGO] Acertou em (" + linha + ", " + coluna + ")!");
        } else {
            estadoTabuleinoMeu[linha][coluna] = ERRO;
            System.out.println("[INIMIGO] Errou em (" + linha + ", " + coluna + ")!");
        }
    }

    // Placeholder para enviar jogada via Socket
    public void enviarJogadaSocket(int linha, int coluna) {
        System.out.println("[SOCKET] Enviando jogada: (" + linha + ", " + coluna + ")");
        // TODO: Implementar envio via Socket quando conectar em rede
    }

    // Placeholder para receber jogada via Socket
    public void receberJogadaSocket() {
        System.out.println("[SOCKET] Aguardando jogada do adversário...");
        // TODO: Implementar recebimento via Socket quando conectar em rede
    }

    public int[][] getMeuTabuleiro() {
        return meuTabuleiro;
    }

    public int[][] getTabuleiroInimigo() {
        return tabuleiroInimigo;
    }

    public int[][] getEstadoTabuleinoMeu() {
        return estadoTabuleinoMeu;
    }

    public int[][] getEstadoTabuleiroInimigo() {
        return estadotabuleiroInimigo;
    }

    public boolean isMinhaVez() {
        return minhaVez;
    }

    public void setMinhaVez(boolean minhaVez) {
        this.minhaVez = minhaVez;
    }

    public int getNaviosDestruidos() {
        return naviosDestruidos;
    }

    public int getNaviosInimigosDestruidos() {
        return naviosInimigosDestruidos;
    }

    public boolean verificarVitoria() {
        return naviosInimigosDestruidos >= 17; // 17 células de navios
    }

    public boolean verificarDerrota() {
        return naviosDestruidos >= 17;
    }

    public static int getTamanhoDaTabuleiro() {
        return TAMANHO_TABULEIRO;
    }

    public static int getAGUA() {
        return AGUA;
    }

    public static int getNAVIO() {
        return NAVIO;
    }

    public static int getACERTO() {
        return ACERTO;
    }

    public static int getERRO() {
        return ERRO;
    }
}
