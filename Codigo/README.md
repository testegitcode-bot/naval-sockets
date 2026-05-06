# Batalha Naval - Jogo em Java Swing

Um jogo clássico de Batalha Naval desenvolvido em **Java** com interface gráfica usando **Swing**. O projeto é completo, funcional e pronto para ser expandido com multiplayer via Socket.

## Características

- **Interface Gráfica**: Dois tabuleiros 10x10 lado a lado usando Swing
- **Lógica Separada**: Classe `BatalhaNavalLogic` gerencia toda a lógica do jogo
- **Sistema de Turnos**: Alternância automática entre jogador e IA
- **IA Aleatória**: Inimigo ataca posições aleatórias no seu tabuleiro
- **Placeholders de Rede**: Métodos prontos para implementação de multiplayer via Socket

## Arquivos do Projeto

```
Codigo/
├── BatalhaNavalLogic.java        # Lógica do jogo (não depende de Swing)
├── BatalhaNavalGUI.java          # Interface gráfica (Swing)
├── INSTRUCOES_EXECUCAO.md        # Guia completo de execução
└── README.md                     # Este arquivo
```

## Como Começar

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior

### Compilar
```bash
javac BatalhaNavalLogic.java BatalhaNavalGUI.java
```

### Executar
```bash
java BatalhaNavalGUI
```

## Gameplay

### Objetivo
Destruir todos os navios do inimigo (17 células) antes que ele destrua os seus.

### Controles
1. **Clique na grade direita** (Tabuleiro do Inimigo) para atacar
2. **Acerto**: Você ataca novamente
3. **Erro**: Passa a vez para o inimigo
4. **Novo Jogo**: Reinicia a partida
5. **Sair**: Fecha o programa

### Cores
| Cor | Significado |
|-----|-------------|
| Azul | Água (não atacado) |
| Cinza | Navio (seu tabuleiro) |
| Vermelho | Acerto |
| Branco | Erro |

## Arquitetura

### BatalhaNavalLogic
Gerencia toda a lógica do jogo:
- Posicionamento de navios
- Validação de jogadas
- Sistema de turnos
- Verificação de vitória/derrota
- **Placeholders de Socket** para rede

### BatalhaNavalGUI
Interface gráfica com Swing:
- Renderização dos dois tabuleiros
- Manipulação de eventos dos botões
- Atualização visual do estado do jogo
- Mensagens de status e turno

## Estrutura dos Navios

| Tamanho | Quantidade | Células |
|---------|-----------|---------|
| 4 | 1 | 4 |
| 3 | 2 | 6 |
| 2 | 3 | 6 |
| 1 | 4 | 4 |
| **Total** | **8** | **20** |

(Vitória após 17 acertos - 3 células para afundar completamente)

## Implementando Multiplayer via Socket

Os métodos `enviarJogadaSocket()` e `receberJogadaSocket()` estão prontos em `BatalhaNavalLogic`:

```java
public void enviarJogadaSocket(int linha, int coluna) {
    // TODO: Implementar envio de jogada para o servidor/outro jogador
}

public void receberJogadaSocket() {
    // TODO: Implementar recebimento de jogada do adversário
}
```

### Próximos Passos para Rede
1. Criar classe `ClienteSocket` para conectar em rede
2. Criar classe `ServidorSocket` para gerenciar múltiplas conexões
3. Modificar `BatalhaNavalGUI` para integrar os métodos de Socket
4. Implementar protocolo de comunicação entre cliente e servidor

## Estrutura do Código

### Constantes em BatalhaNavalLogic
```java
private static final int TAMANHO_TABULEIRO = 10;
private static final int AGUA = 0;
private static final int NAVIO = 1;
private static final int ACERTO = 2;
private static final int ERRO = 3;
```

### Estados dos Botões em BatalhaNavalGUI
- **Azul**: Água
- **Cinza**: Navio (visível apenas no seu tabuleiro)
- **Vermelho com 'X'**: Acerto
- **Branco com '·'**: Erro

## Principais Métodos

### BatalhaNavalLogic
- `posicionarNavio(linha, coluna, tamanho, horizontal)` - Posiciona um navio
- `verificarJogada(linha, coluna)` - Processa um ataque
- `turnoInimigo()` - IA ataca uma posição aleatória
- `verificarVitoria()` / `verificarDerrota()` - Verifica fim de jogo
- `enviarJogadaSocket()` / `receberJogadaSocket()` - Placeholders de rede

### BatalhaNavalGUI
- `realizarJogada(linha, coluna)` - Processa clique do jogador
- `turnoInimigo()` - Executa turno da IA com delay
- `atualizarTabuleiroInimigo()` - Atualiza visual após ataque
- `novoJogo()` - Reinicia o jogo

## Requisitos Implementados

✅ Interface dividida em duas grades 10x10 com JButton  
✅ Cores corretas (azul, cinza, vermelho, branco)  
✅ Classe `BatalhaNavalLogic` separada da interface  
✅ Sistema de turnos funcionando  
✅ Métodos `enviarJogadaSocket()` e `receberJogadaSocket()` como placeholders  
✅ Arquivo único ou conjunto de classes para rodar em VS Code  
✅ Instruções completas de execução  
✅ Código preparado para expansão com multiplayer  

## Troubleshooting

**Erro: `javac: command not found`**
- Instale o JDK conforme o guia em INSTRUCOES_EXECUCAO.md

**Erro: `Exception in thread 'main'`**
- Verifique se os dois arquivos .java estão na mesma pasta
- Tente recompilar com `javac *.java`

**A janela não abre**
- Certifique-se de ter uma interface gráfica disponível
- Teste com `java -version` para confirmar que Java funciona

## Autor

Desenvolvido como projeto educacional de Batalha Naval em Java Swing.

## Licença

Este projeto é código aberto e pode ser utilizado livremente.

---

**Para executar**: Veja `INSTRUCOES_EXECUCAO.md` para guia passo-a-passo.
