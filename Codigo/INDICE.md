# Índice do Projeto - Batalha Naval

## Visão Geral

Projeto completo de Batalha Naval em Java Swing com interface gráfica, lógica de jogo e placeholders para multiplayer via Socket.

**Status:** ✅ Completo e Funcional  
**Linhas de Código:** ~1.200  
**Linguagem:** Java  
**Framework GUI:** Swing (Nativo)  
**Requisitos:** JDK 8+

---

## Arquivos Principais

### 1. Código-Fonte (564 linhas totais)

#### `BatalhaNavalLogic.java` (207 linhas)
Gerencia toda a lógica do jogo, independente de GUI.

**Responsabilidades:**
- Inicializar tabuleiros (matriz 10x10)
- Posicionar navios
- Validar e processar jogadas
- Controlar turnos
- Verificar vitória/derrota
- **Placeholders:** `enviarJogadaSocket()` e `receberJogadaSocket()`

**Classes Internas:** Nenhuma (design simples e direto)

**Métodos Principais:**
```
+ inicializarTabuleiros()
+ posicionarNavio(linha, coluna, tamanho, horizontal): boolean
+ verificarJogada(linha, coluna): int
+ turnoInimigo(): void
+ verificarVitoria(): boolean
+ verificarDerrota(): boolean
+ enviarJogadaSocket(linha, coluna): void [PLACEHOLDER]
+ receberJogadaSocket(): void [PLACEHOLDER]
+ Getters/Setters...
```

#### `BatalhaNavalGUI.java` (357 linhas)
Interface gráfica usando Swing com dois tabuleiros 10x10.

**Responsabilidades:**
- Criar interface visual
- Gerenciar eventos dos botões
- Atualizar cores e estados
- Controlar turno e mensagens
- Tratar vitória/derrota

**Componentes:**
- `JFrame` - Janela principal
- `JPanel` - Painéis de layout
- `JButton[10][10]` - Tabuleiros
- `JLabel` - Mensagens de status
- `GridLayout` - Layout dos tabuleiros

**Métodos Principais:**
```
+ inicializarInterface(): void
+ criarPainelInformacoes(): JPanel
+ criarPainelTabuleiros(): JPanel
+ criarTabuleiro(ehMeuTabuleiro): JPanel
+ criarBotao(linha, coluna, ehMeuTabuleiro): JButton
+ realizarJogada(linha, coluna): void
+ turnoInimigo(): void
+ atualizarTabuleiroInimigo(): void
+ posicionarNaviosPadrao(): void
+ posicionarNaviosInimigos(): void
+ novoJogo(): void
+ exibirVitoria(): void
+ exibirDerrota(): void
+ main(String[] args): void
```

---

## Arquivos de Documentação

### 2. Guias de Execução

#### `INSTRUCOES_EXECUCAO.md` (Recomendado para iniciantes)
- Requisitos do sistema
- Instalação de Java por SO
- Como compilar e executar
- Estrutura de arquivos
- Como jogar
- Troubleshooting

#### `COMO_USAR_VSCODE.md` (Específico para VS Code)
- Passo-a-passo dentro do VS Code
- Terminal integrado
- Compilação e execução
- Atalhos úteis
- Debugging
- Troubleshooting VS Code

#### `README.md` (Documentação técnica completa)
- Overview do projeto
- Características
- Como começar
- Gameplay detalhado
- Arquitetura das classes
- Estrutura dos dados
- Próximos passos

#### `RESUMO_PROJETO.txt` (Visão geral visual)
- Lista de arquivos
- Requisitos implementados
- Como executar
- Estrutura de dados
- Cores utilizadas
- Troubleshooting

#### `INDICE.md` (Este arquivo)
- Mapa de todos os arquivos
- Descrição de cada componente
- Fluxo de execução

---

## Scripts de Automação

### 3. Executores

#### `run.sh` (Linux/macOS)
```bash
#!/bin/bash
# Compila e executa automaticamente
# Verifica se Java está instalado
# Mostra feedback visual
```

**Uso:**
```bash
chmod +x run.sh  # Primeira vez
./run.sh         # Executar
```

#### `run.bat` (Windows)
```batch
@echo off
:: Compila e executa automaticamente
:: Verifica se Java está instalado
:: Mostra feedback visual
```

**Uso:**
```batch
run.bat
```

---

## Configuração

### 4. Controle de Versão

#### `.gitignore`
```
*.class          # Arquivos compilados
*.jar
*.war
*.ear
.idea/           # IDE
.vscode/
*.log
build/
dist/
```

---

## Fluxo de Execução

```
1. main() em BatalhaNavalGUI
   ↓
2. Construtor BatalhaNavalGUI()
   ↓
3. Inicializar Interface Swing
   ├─ Criar painéis
   ├─ Criar botões (2x 10x10 = 200 botões)
   ├─ Posicionar navios (aleatório)
   ├─ Adicionar listeners
   └─ Exibir janela
   ↓
4. Aguardando clique do usuário
   ├─ Clique em tabuleiro inimigo
   ├─ Chamar realizarJogada()
   ├─ Validar via BatalhaNavalLogic.verificarJogada()
   ├─ Atualizar cor do botão
   ├─ Se acerto → pode clicar novamente
   └─ Se erro → turnoInimigo() com delay
   ↓
5. Verificar vitória/derrota
   ├─ Se vitória → mostrar diálogo
   ├─ Se derrota → mostrar diálogo
   └─ Iniciar novo jogo
```

---

## Cores e Estados

### Estados do Tabuleiro

| Valor | Constante | Cor | RGB | Significado |
|-------|-----------|-----|-----|-------------|
| 0 | AGUA | Azul | (65, 105, 225) | Não atacado |
| 1 | NAVIO | Cinza | (128, 128, 128) | Navio (seu tab.) |
| 2 | ACERTO | Vermelho | (220, 20, 60) | Acertou |
| 3 | ERRO | Branco | (255, 255, 255) | Errou |

---

## Como Contribuir/Expandir

### Implementar Multiplayer (Socket)

Preencha estes métodos em `BatalhaNavalLogic.java`:

```java
public void enviarJogadaSocket(int linha, int coluna) {
    // TODO: Conectar a servidor/outro jogador
    // Serializar: linha + coluna
    // Enviar via Socket
}

public void receberJogadaSocket() {
    // TODO: Receber dados do Socket
    // Desserializar: linha + coluna
    // Processar com verificarJogada()
}
```

### Arquivos Necessários para Socket:

1. `ClienteSocket.java` - Conectar ao servidor
2. `ServidorSocket.java` - Gerenciar conexões
3. `ProtocoloRede.java` - Serializar/desserializar
4. Modificar `BatalhaNavalGUI` para usar Socket

---

## Checklist de Qualidade

- ✅ Código compilável
- ✅ Interface funcional
- ✅ Lógica de jogo correcta
- ✅ Sistema de turnos funcionando
- ✅ Cores conforme especificação
- ✅ IA aleatória implementada
- ✅ Vitória/derrota detectados
- ✅ Novo jogo reseta corretamente
- ✅ Documentação completa
- ✅ Scripts de execução
- ✅ Placeholders de Socket prontos
- ✅ Sem dependências externas
- ✅ Java 8+ compatível

---

## Próximas Fases (Opcional)

### Fase 2: Multiplayer Local
- [ ] Modo 2 jogadores no mesmo PC
- [ ] Alternância de teclado
- [ ] Tela dividida com privacidade

### Fase 3: Multiplayer Online
- [ ] Implementar Socket TCP/IP
- [ ] Servidor de jogo
- [ ] Matchmaking
- [ ] Chat in-game

### Fase 4: Melhorias
- [ ] IA mais inteligente
- [ ] Dificuldade ajustável
- [ ] Tema/skins customizáveis
- [ ] Ranking/pontuação
- [ ] Animações suaves

---

## Estatísticas do Projeto

| Métrica | Valor |
|---------|-------|
| Linhas Java | 564 |
| Linhas Documentação | 623 |
| Total | 1.187 |
| Classes Java | 2 |
| Métodos Java | 25+ |
| Constantes | 7 |
| Placeholders Socket | 2 |
| Botões Interface | 200 |
| Tamanho Tabuleiro | 10x10 |
| Navios | 8 |
| Células Totais | 20 |

---

## Suporte Rápido

**Não compila?**
→ Ver `INSTRUCOES_EXECUCAO.md` seção "Requisitos"

**Não abre?**
→ Ver `COMO_USAR_VSCODE.md` seção "Troubleshooting"

**Como expandir?**
→ Ver `README.md` seção "Próximas Fases"

**Como funciona?**
→ Ver `RESUMO_PROJETO.txt` seção "Estrutura"

---

## Resumo Rápido

Para **começar imediatamente**:

```bash
# Terminal/Prompt
javac BatalhaNavalLogic.java BatalhaNavalGUI.java
java BatalhaNavalGUI
```

Para **entender o código**:
1. Leia `BatalhaNavalLogic.java` (lógica simples)
2. Leia `BatalhaNavalGUI.java` (interface)
3. Consulte `README.md` para detalhes

Para **expandir com rede**:
1. Implemente os métodos Socket
2. Crie classes de Cliente/Servidor
3. Modifique GUI para usar Socket

---

**Projeto Completo e Pronto para Uso!**

Data: 2026-05-06  
Status: ✅ FINALIZADO
