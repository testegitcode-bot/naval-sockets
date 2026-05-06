# Como Usar em VS Code

## Pré-requisitos

1. **Ter Java instalado** (JDK 8+)
   - Teste com: `java -version` e `javac -version` no terminal

2. **VS Code instalado**
   - https://code.visualstudio.com

3. **Extensões recomendadas no VS Code**
   - Extension Pack for Java (Microsoft)
   - Code Runner (opcional)

## Passo 1: Abrir a Pasta no VS Code

```
1. Abra VS Code
2. Clique em "File" → "Open Folder"
3. Navegue até a pasta "Codigo" onde os arquivos estão
4. Clique em "Select Folder"
```

A estrutura deve aparecer assim:

```
Codigo/
├── BatalhaNavalLogic.java
├── BatalhaNavalGUI.java
├── run.sh
├── run.bat
├── README.md
├── INSTRUCOES_EXECUCAO.md
└── ... (outros arquivos)
```

## Passo 2: Compilar o Projeto

### Opção A: Usar o Terminal Integrado (Recomendado)

```
1. Pressione: Ctrl + ` (backtick)
   OU: View → Terminal
   
2. No terminal que aparecer, digite:
   javac BatalhaNavalLogic.java BatalhaNavalGUI.java
   
3. Pressione Enter
   
4. Se não houver erro, você verá novos arquivos .class criados
```

### Opção B: Usar o Script (Se System path estiver correto)

**Linux/macOS:**
```bash
./run.sh
```

**Windows:**
```bash
run.bat
```

## Passo 3: Executar o Jogo

### Opção A: Linha de Comando

```
1. Com o terminal do VS Code ainda aberto
2. Digite: java BatalhaNavalGUI
3. Pressione Enter
4. A janela do jogo abrirá
```

### Opção B: Code Runner

```
1. Clique com botão direito em BatalhaNavalGUI.java
2. Selecione "Run Code"
   (Nota: O jogo abrirá em uma nova janela)
```

## Passo 4: Jogar

Quando a janela abrir:

- **Clique no tabuleiro da direita** para atacar o inimigo
- **Acertos (vermelho)**: você ataca novamente
- **Erros (branco)**: passa a vez pro inimigo
- **Novo Jogo**: reinicia
- **Sair**: fecha o programa

## Estrutura de Pastas Ideal

```
seu_projeto_java/
└── Codigo/                      ← Abra esta pasta no VS Code
    ├── BatalhaNavalLogic.java
    ├── BatalhaNavalGUI.java
    ├── run.sh
    ├── run.bat
    └── ... (documentação)
```

## Atalhos Úteis no VS Code

| Atalho | O que faz |
|--------|-----------|
| `Ctrl + ` ` | Abre/fecha terminal integrado |
| `Ctrl + K Ctrl + C` | Comenta linhas selecionadas |
| `Ctrl + /` | Comenta/descomenta linha |
| `Ctrl + F` | Abre busca no arquivo |
| `Ctrl + H` | Abre busca e substituição |
| `Ctrl + Shift + P` | Abre paleta de comandos |
| `F1` | Também abre paleta de comandos |

## Troubleshooting

### Terminal não reconhece comandos Java

**Solução:**
1. Reinicie o VS Code
2. Verifique se Java está no PATH do sistema
3. Teste: abra terminal DO SISTEMA (não integrado) e teste `javac -version`

### Arquivo .class não aparece após compilação

**Solução:**
1. Verifique se não houve erros na compilação
2. Recarregue a pasta (File → Close Folder → Open Folder)
3. Ou clique no ícone de refresh na barra do Explorer

### Erro ao executar: "Exception in thread"

**Solução:**
1. Certifique-se de que compilou (devem existir BatalhaNavalLogic.class e BatalhaNavalGUI.class)
2. Verifique que os dois arquivos .java estão na mesma pasta
3. Tente recompilar com: `javac *.java`

### Janela não abre

**Solução:**
1. Verifique se a máquina tem interface gráfica (não é servidor)
2. Tente executar de um terminal fora do VS Code
3. Se ainda não funcionar, pode ser problema com drivers gráficos

## Debugging (Opcional)

Se quiser adicionar breakpoints:

1. Clique na linha onde quer pausar
2. Clique na margem esquerda (aparecerá um círculo vermelho)
3. Execute com debugger (F5 ou Run → Start Debugging)
4. O programa pausará na linha

## Editando o Código

### Principais Classes

**BatalhaNavalLogic.java** - A lógica
- Gerencia tabuleiros
- Valida jogadas
- Controla turnos
- Placeholder para Socket

**BatalhaNavalGUI.java** - A interface
- Desenha os botões
- Processa cliques
- Atualiza cores
- Mostra mensagens

### Dicas de Edição

1. Hover sobre nomes de variáveis para ver tipo
2. Ctrl + Click em uma função para ir para sua definição
3. Ctrl + Shift + O para organizar imports (if needed)
4. Documentação aparece ao passar mouse em métodos

## Próximos Passos

Após rodar o jogo:

1. **Testar a funcionalidade**
   - Jogue uma partida completa
   - Teste vitória e derrota

2. **Modificar o código** (opcional)
   - Altere cores em BatalhaNavalGUI
   - Mude posição dos navios em BatalhaNavalLogic
   - Incremente dificuldade da IA

3. **Implementar multiplayer** (avançado)
   - Preencha enviarJogadaSocket()
   - Preencha receberJogadaSocket()
   - Crie classes de Socket

## Extensões Recomendadas

Instale no VS Code para melhor experiência:

```
1. Extension Pack for Java (Microsoft)
   - Traz suporte completo a Java

2. Code Runner (Jun Han)
   - Permite executar código direto

3. Better Comments (Aaron Bond)
   - Colorir comentários de forma mais legível
```

Para instalar:
1. Clique no ícone de Extensions (Ctrl + Shift + X)
2. Busque pelo nome
3. Clique em Install

## Checklist de Execução

- [ ] Java instalado e reconhecido (`java -version` funciona)
- [ ] VS Code aberto
- [ ] Pasta "Codigo" aberta em VS Code
- [ ] Terminal integrado aberto (Ctrl + `)
- [ ] Compilação bem-sucedida (sem erro de javac)
- [ ] Arquivos .class aparecem na pasta
- [ ] Comando `java BatalhaNavalGUI` executa a janela
- [ ] Jogo funciona e responde aos cliques

## Mais Informações

- Veja **README.md** para documentação completa
- Veja **INSTRUCOES_EXECUCAO.md** para guia genérico
- Veja **RESUMO_PROJETO.txt** para visão geral do projeto
