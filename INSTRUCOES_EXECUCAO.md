# Instruções de Execução - Batalha Naval

## Requisitos do Sistema

- **Java Development Kit (JDK)** versão 8 ou superior instalado
- **VS Code** ou qualquer editor de texto (opcional, para editar o código)

### Instalar Java

#### Windows
1. Baixe o JDK em: https://www.oracle.com/java/technologies/downloads/
2. Execute o instalador e siga as instruções
3. Adicione Java ao PATH do seu sistema (geralmente automático)

#### macOS
```bash
brew install openjdk@11
```

#### Linux (Ubuntu/Debian)
```bash
sudo apt-get update
sudo apt-get install default-jdk
```

### Verificar Instalação do Java
```bash
java -version
javac -version
```

## Como Executar o Jogo

### 1. Abra o Terminal/Prompt de Comando

### 2. Navegue até a pasta do projeto
```bash
cd caminho/para/o/projeto
```

### 3. Compile os arquivos Java
```bash
javac BatalhaNavalLogic.java BatalhaNavalGUI.java
```

### 4. Execute o jogo
```bash
java BatalhaNavalGUI
```

A janela do jogo abrirá automaticamente!

## Estrutura dos Arquivos

```
projeto/
├── BatalhaNavalLogic.java    (Lógica do jogo)
├── BatalhaNavalGUI.java      (Interface gráfica)
└── INSTRUCOES_EXECUCAO.md    (Este arquivo)
```

## Como Jogar

### Interface
- **Esquerda**: Seu Tabuleiro (apenas visualização)
- **Direita**: Tabuleiro do Inimigo (onde você ataca)

### Cores
- **Azul**: Água (não atacado)
- **Cinza**: Navio (no seu tabuleiro)
- **Vermelho com X**: Acerto
- **Branco com ·**: Erro

### Mecânica do Jogo
1. Clique em qualquer quadrado do tabuleiro do inimigo (lado direito)
2. Se acertar um navio, você tem o direito de atacar novamente
3. Se errar, passa a vez para o inimigo
4. O primeiro a destruir todos os navios (17 células) vence
5. Clique em "Novo Jogo" para recomeçar
6. Clique em "Sair" para fechar o programa

## Estrutura do Código

### BatalhaNavalLogic.java
- **Responsabilidades**: Gerenciar a lógica do jogo
- **Atributos principais**:
  - `meuTabuleiro`: Matriz com posições dos seus navios
  - `tabuleinoInimigo`: Matriz com posições dos navios do inimigo
  - `estadoTabuleinoMeu`: Histórico de ataques sofridos
  - `estadoTabuleinoInimigo`: Histórico de seus ataques

- **Métodos principais**:
  - `posicionarNavio()`: Posiciona um navio no tabuleiro
  - `verificarJogada()`: Valida e processa um ataque
  - `turnoInimigo()`: Simula a jogada da IA
  - `enviarJogadaSocket()`: PLACEHOLDER para enviar via rede
  - `receberJogadaSocket()`: PLACEHOLDER para receber via rede

### BatalhaNavalGUI.java
- **Responsabilidades**: Gerenciar a interface gráfica
- **Componentes principais**:
  - `botoesMeuTabuleiro[][]`: Botões do seu tabuleiro
  - `botoesTabuleiroInimigo[][]`: Botões do tabuleiro inimigo
  - `labelStatus`: Mostra mensagens de status
  - `labelTurno`: Indica de quem é a vez

## Próximas Melhorias (Placeholders Prontos)

Os métodos `enviarJogadaSocket()` e `receberJogadaSocket()` na classe `BatalhaNavalLogic` estão prontos para implementação de:

- Conexão com outro jogador via rede
- Comunicação Socket (TCP/IP)
- Modo multiplayer online

Para implementá-los, basta adicionar o código de rede dentro desses métodos.

## Troubleshooting

### Erro: "javac: command not found"
- Java não está instalado ou não está no PATH
- Solução: Instale o JDK conforme as instruções acima

### Erro: "Exception in thread 'main'"
- Algum arquivo está faltando ou corrompido
- Solução: Baixe os arquivos novamente e tente recompilar

### A janela não abre
- Pode ser problema com a exibição gráfica no Linux sem GUI
- Solução: Execute em uma máquina com interface gráfica

## Suporte

Se encontrar problemas, verifique:
1. Java está instalado e no PATH
2. Os dois arquivos .java estão na mesma pasta
3. A compilação funcionou sem erros
4. Você está usando Java 8 ou superior

Bom jogo!
