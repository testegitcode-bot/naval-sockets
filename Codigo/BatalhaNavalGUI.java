import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Interface gráfica do jogo Batalha Naval usando Swing
 * Apresenta dois tabuleiros 10x10 lado a lado
 */
public class BatalhaNavalGUI extends JFrame {
    private BatalhaNavalLogic logica;
    private JButton[][] botoesMeuTabuleiro;
    private JButton[][] botoesTabuleiroInimigo;
    private JLabel labelStatus;
    private JLabel labelTurno;
    private JButton botaoNovoJogo;
    private JButton botaoSair;

    private static final int TAMANHO_TABULEIRO = 10;
    private static final int TAMANHO_BOTAO = 40;

    private Color corAgua = new Color(65, 105, 225); // Azul Royal
    private Color corNavio = new Color(128, 128, 128); // Cinza
    private Color corAcerto = new Color(220, 20, 60); // Vermelho Carmesim
    private Color corErro = new Color(255, 255, 255); // Branco
    private Color corFundo = new Color(20, 20, 40); // Fundo escuro

    public BatalhaNavalGUI() {
        logica = new BatalhaNavalLogic();
        inicializarInterface();
        posicionarNaviosPadrao();
        posicionarNaviosInimigos();
    }

    private void inicializarInterface() {
        setTitle("Batalha Naval");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBackground(corFundo);

        // Painel de informações
        JPanel painelInfo = criarPainelInformacoes();

        // Painel dos tabuleiros
        JPanel painelTabuleiros = criarPainelTabuleiros();

        // Painel de controles
        JPanel painelControles = criarPainelControles();

        painelPrincipal.add(Box.createVerticalStrut(10));
        painelPrincipal.add(painelInfo);
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(painelTabuleiros);
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(painelControles);
        painelPrincipal.add(Box.createVerticalStrut(10));

        add(painelPrincipal);
        pack();
        setVisible(true);
    }

    private JPanel criarPainelInformacoes() {
        JPanel painel = new JPanel();
        painel.setBackground(corFundo);
        painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
        painel.setMaximumSize(new Dimension(900, 50));

        labelStatus = new JLabel("Status: Aguardando sua jogada");
        labelStatus.setForeground(Color.WHITE);
        labelStatus.setFont(new Font("Arial", Font.BOLD, 14));

        labelTurno = new JLabel("Sua vez");
        labelTurno.setForeground(new Color(144, 238, 144)); // Verde claro
        labelTurno.setFont(new Font("Arial", Font.BOLD, 14));

        painel.add(Box.createHorizontalStrut(20));
        painel.add(labelStatus);
        painel.add(Box.createHorizontalGlue());
        painel.add(labelTurno);
        painel.add(Box.createHorizontalStrut(20));

        return painel;
    }

    private JPanel criarPainelTabuleiros() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
        painel.setBackground(corFundo);
        painel.setMaximumSize(new Dimension(900, 500));

        // Tabuleiro do jogador
        JPanel painelMeuTabuleiro = criarTabuleiro(true);

        // Espaço entre tabuleiros
        painel.add(Box.createHorizontalStrut(20));
        painel.add(painelMeuTabuleiro);
        painel.add(Box.createHorizontalStrut(30));

        // Tabuleiro do inimigo
        JPanel painelTabuleiroInimigo = criarTabuleiro(false);
        painel.add(painelTabuleiroInimigo);
        painel.add(Box.createHorizontalStrut(20));

        return painel;
    }

    private JPanel criarTabuleiro(boolean ehMeuTabuleiro) {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(corFundo);

        JLabel titulo = new JLabel(ehMeuTabuleiro ? "Meu Tabuleiro" : "Tabuleiro do Inimigo");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painel.add(titulo);
        painel.add(Box.createVerticalStrut(10));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(TAMANHO_TABULEIRO, TAMANHO_TABULEIRO, 1, 1));
        painelBotoes.setBackground(new Color(40, 40, 60));
        painelBotoes.setBorder(new LineBorder(Color.GRAY, 2));

        if (ehMeuTabuleiro) {
            botoesMeuTabuleiro = new JButton[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
            for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
                for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                    JButton botao = criarBotao(i, j, true);
                    botoesMeuTabuleiro[i][j] = botao;
                    painelBotoes.add(botao);
                }
            }
        } else {
            botoesTabuleiroInimigo = new JButton[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
            for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
                for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                    JButton botao = criarBotao(i, j, false);
                    botoesTabuleiroInimigo[i][j] = botao;
                    painelBotoes.add(botao);
                }
            }
        }

        painel.add(painelBotoes);
        return painel;
    }

    private JButton criarBotao(int linha, int coluna, boolean ehMeuTabuleiro) {
        JButton botao = new JButton();
        botao.setPreferredSize(new Dimension(TAMANHO_BOTAO, TAMANHO_BOTAO));
        botao.setBackground(corAgua);
        botao.setFocusPainted(false);
        botao.setBorder(new LineBorder(new Color(100, 100, 150), 1));

        if (!ehMeuTabuleiro) {
            final int l = linha;
            final int c = coluna;
            botao.addActionListener(e -> realizarJogada(l, c));
            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            botao.setEnabled(false);
        }

        return botao;
    }

    private void realizarJogada(int linha, int coluna) {
        if (!logica.isMinhaVez()) {
            labelStatus.setText("Status: Aguarde seu turno!");
            return;
        }

        int resultado = logica.verificarJogada(linha, coluna);

        if (resultado == -1) {
            labelStatus.setText("Status: Posição já foi atacada!");
            return;
        }

        atualizarTabuleiroInimigo();

        if (resultado == 1) {
            labelStatus.setText("Status: Acerto! Ataque novamente!");
        } else {
            labelStatus.setText("Status: Erro! Turno do inimigo...");
            botoesTabuleiroInimigo[linha][coluna].setEnabled(false);
            logica.setMinhaVez(false);
            labelTurno.setText("Turno do Inimigo");

            Timer timer = new Timer(1500, e -> turnoInimigo());
            timer.setRepeats(false);
            timer.start();
        }

        if (logica.verificarVitoria()) {
            exibirVitoria();
        }
    }

    private void turnoInimigo() {
        logica.turnoInimigo();
        atualizarTabuleiro(true);

        if (logica.verificarDerrota()) {
            exibirDerrota();
        } else {
            logica.setMinhaVez(true);
            labelTurno.setText("Sua vez");
            labelStatus.setText("Status: É sua vez novamente!");
        }
    }

    private void atualizarTabuleiroInimigo() {
        int[][] estado = logica.getEstadoTabuleinoInimigo();
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                atualizarBotao(botoesTabuleiroInimigo[i][j], estado[i][j], false);
            }
        }
    }

    private void atualizarTabuleiro(boolean ehMeuTabuleiro) {
        int[][] estado = ehMeuTabuleiro ? logica.getEstadoTabuleinoMeu() : logica.getEstadoTabuleinoInimigo();
        JButton[][] botoes = ehMeuTabuleiro ? botoesMeuTabuleiro : botoesTabuleiroInimigo;

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                atualizarBotao(botoes[i][j], estado[i][j], ehMeuTabuleiro);
            }
        }
    }

    private void atualizarBotao(JButton botao, int estado, boolean ehMeuTabuleiro) {
        if (estado == BatalhaNavalLogic.getACERTO()) {
            botao.setBackground(corAcerto);
            botao.setText("X");
            botao.setForeground(Color.WHITE);
            botao.setFont(new Font("Arial", Font.BOLD, 18));
        } else if (estado == BatalhaNavalLogic.getERRO()) {
            botao.setBackground(corErro);
            botao.setText("·");
            botao.setForeground(Color.BLACK);
            botao.setFont(new Font("Arial", Font.BOLD, 16));
        } else if (estado == BatalhaNavalLogic.getAGUA()) {
            botao.setBackground(corAgua);
            botao.setText("");
        }
    }

    private void posicionarNaviosPadrao() {
        // Navios: 1 de 4, 2 de 3, 3 de 2, 4 de 1
        logica.posicionarNavio(0, 0, 4, true);   // Navio de 4
        logica.posicionarNavio(2, 1, 3, false);  // Navio de 3
        logica.posicionarNavio(2, 5, 3, true);   // Navio de 3
        logica.posicionarNavio(4, 0, 2, true);   // Navio de 2
        logica.posicionarNavio(5, 5, 2, false);  // Navio de 2
        logica.posicionarNavio(7, 2, 2, true);   // Navio de 2
        logica.posicionarNavio(8, 8, 1, true);   // Navio de 1
        logica.posicionarNavio(9, 5, 1, true);   // Navio de 1
    }

    private void posicionarNaviosInimigos() {
        // Posições aleatórias para o inimigo
        int[][] tabuleinoInimigo = logica.getTabuleinoInimigo();
        int naviosPositos = 0;
        int[] tamanhos = {4, 3, 3, 2, 2, 2, 1, 1};

        for (int tamanho : tamanhos) {
            boolean posicionado = false;
            while (!posicionado) {
                int linha = (int) (Math.random() * TAMANHO_TABULEIRO);
                int coluna = (int) (Math.random() * TAMANHO_TABULEIRO);
                boolean horizontal = Math.random() < 0.5;

                if (logica.posicionarNavio(linha, coluna, tamanho, horizontal)) {
                    posicionado = true;
                }
            }
        }
    }

    private JPanel criarPainelControles() {
        JPanel painel = new JPanel();
        painel.setBackground(corFundo);
        painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
        painel.setMaximumSize(new Dimension(900, 50));

        botaoNovoJogo = new JButton("Novo Jogo");
        botaoNovoJogo.setFont(new Font("Arial", Font.BOLD, 12));
        botaoNovoJogo.setBackground(new Color(34, 139, 34)); // Verde escuro
        botaoNovoJogo.setForeground(Color.WHITE);
        botaoNovoJogo.setFocusPainted(false);
        botaoNovoJogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoNovoJogo.addActionListener(e -> novoJogo());

        botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("Arial", Font.BOLD, 12));
        botaoSair.setBackground(new Color(178, 34, 34)); // Vermelho escuro
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setFocusPainted(false);
        botaoSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoSair.addActionListener(e -> System.exit(0));

        painel.add(Box.createHorizontalStrut(20));
        painel.add(botaoNovoJogo);
        painel.add(Box.createHorizontalGlue());
        painel.add(botaoSair);
        painel.add(Box.createHorizontalStrut(20));

        return painel;
    }

    private void novoJogo() {
        logica = new BatalhaNavalLogic();
        posicionarNaviosPadrao();
        posicionarNaviosInimigos();

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                botoesMeuTabuleiro[i][j].setText("");
                botoesMeuTabuleiro[i][j].setBackground(corAgua);
                botoesTabuleiroInimigo[i][j].setText("");
                botoesTabuleiroInimigo[i][j].setBackground(corAgua);
                botoesTabuleiroInimigo[i][j].setEnabled(true);
            }
        }

        labelStatus.setText("Status: Aguardando sua jogada");
        labelTurno.setText("Sua vez");
    }

    private void exibirVitoria() {
        JOptionPane.showMessageDialog(this,
                "Parabéns! Você venceu a batalha!\nNavios inimigos destruídos: " + logica.getNaviosInimigosDestruidos(),
                "Vitória!",
                JOptionPane.INFORMATION_MESSAGE);
        novoJogo();
    }

    private void exibirDerrota() {
        JOptionPane.showMessageDialog(this,
                "Você perdeu a batalha!\nSeus navios foram destruídos: " + logica.getNaviosDestruidos(),
                "Derrota!",
                JOptionPane.WARNING_MESSAGE);
        novoJogo();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BatalhaNavalGUI());
    }
}
