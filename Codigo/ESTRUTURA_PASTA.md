# Estrutura da Pasta Codigo/ - Guia Detalhado

```
Codigo/
│
├─ 📦 CÓDIGO-FONTE (Núcleo do Jogo)
│  │
│  ├─ BatalhaNavalLogic.java (207 linhas)
│  │  ├─ Responsabilidade: LÓGICA DO JOGO
│  │  ├─ Funções Principais:
│  │  │  ├─ Gerenciar matrizes 10x10 (meuTabuleiro, tabuleinoInimigo)
│  │  │  ├─ Posicionar navios (8 navios, 20 células)
│  │  │  ├─ Validar jogadas (acerto/erro)
│  │  │  ├─ Controlar turnos (jogador vs inimigo)
│  │  │  ├─ Verificar vitória/derrota
│  │  │  └─ PLACEHOLDERS para Socket (rede futura)
│  │  ├─ Atributos Principais:
│  │  │  ├─ int[][] meuTabuleiro (com seus navios)
│  │  │  ├─ int[][] tabuleinoInimigo (navios do inimigo)
│  │  │  ├─ int[][] estadoTabuleinoMeu (seu histórico de ataques sofridos)
│  │  │  ├─ int[][] estadoTabuleinoInimigo (seus ataques)
│  │  │  └─ boolean minhaVez (controle de turno)
│  │  ├─ Constantes:
│  │  │  ├─ AGUA = 0 (célula sem navio)
│  │  │  ├─ NAVIO = 1 (célula com navio)
│  │  │  ├─ ACERTO = 2 (célula acertada)
│  │  │  ├─ ERRO = 3 (célula errada)
│  │  │  └─ TAMANHO_TABULEIRO = 10
│  │  └─ NÃO DEPENDE DE: Swing, GUI ou qualquer interface
│  │
│  └─ BatalhaNavalGUI.java (357 linhas)
│     ├─ Responsabilidade: INTERFACE GRÁFICA
│     ├─ Funções Principais:
│     │  ├─ Criar janela com Swing (JFrame)
│     │  ├─ Desenhar 2 tabuleiros 10x10 (JButton)
│     │  ├─ Gerenciar cores dos botões
│     │  ├─ Processar cliques do usuário
│     │  ├─ Atualizar visual em tempo real
│     │  ├─ Mostrar mensagens de status
│     │  ├─ Controlar turnos (visual)
│     │  └─ Diálogos de vitória/derrota
│     ├─ Componentes Visuais:
│     │  ├─ JFrame mainWindow (janela principal)
│     │  ├─ JPanel[] painéis (layout)
│     │  ├─ JButton[10][10] botoesMeuTabuleiro (seu tabuleiro - DESABILITADO)
│     │  ├─ JButton[10][10] botoesTabuleiroInimigo (tabuleiro inimigo - CLICÁVEL)
│     │  ├─ JLabel labelStatus (mostra: "Acerto!", "Erro!", etc)
│     │  ├─ JLabel labelTurno (mostra: "Sua vez" ou "Turno do Inimigo")
│     │  └─ JButton botões de controle (Novo Jogo, Sair)
│     ├─ Cores Utilizadas:
│     │  ├─ AZUL (65, 105, 225) - Água/não atacado
│     │  ├─ CINZA (128, 128, 128) - Navio
│     │  ├─ VERMELHO (220, 20, 60) - Acerto
│     │  └─ BRANCO (255, 255, 255) - Erro
│     ├─ DEPENDE DE: BatalhaNavalLogic (composição)
│     └─ USA: Swing, eventos de mouse, timers
│
├─ 📘 DOCUMENTAÇÃO (Guias para Usuários)
│  │
│  ├─ LEIA_PRIMEIRO.txt (Comece aqui!)
│  │  ├─ Responsabilidade: INTRODUÇÃO RÁPIDA
│  │  ├─ Conteúdo:
│  │  │  ├─ Bem-vindo ao projeto
│  │  │  ├─ Como rodar em 3 minutos
│  │  │  ├─ Requisitos (Java 8+)
│  │  │  ├─ Qual documento ler baseado no seu perfil
│  │  │  ├─ Cores e como jogar
│  │  │  ├─ Troubleshooting rápido
│  │  │  └─ Próximos passos
│  │  └─ Público: Iniciantes (primeira leitura)
│  │
│  ├─ INSTRUCOES_EXECUCAO.md (Manual Universal)
│  │  ├─ Responsabilidade: GUIA PASSO-A-PASSO
│  │  ├─ Conteúdo:
│  │  │  ├─ Instalar Java (Windows, macOS, Linux)
│  │  │  ├─ Verificar instalação (java -version)
│  │  │  ├─ Compilar: javac *.java
│  │  │  ├─ Executar: java BatalhaNavalGUI
│  │  │  ├─ Estrutura de arquivos
│  │  │  ├─ Como jogar (completo)
│  │  │  ├─ Estrutura do código (resumo)
│  │  │  └─ Troubleshooting (Erro: X → Solução: Y)
│  │  └─ Público: Todos (referência técnica)
│  │
│  ├─ COMO_USAR_VSCODE.md (Guia VS Code)
│  │  ├─ Responsabilidade: INSTRUÇÕES PARA VS CODE
│  │  ├─ Conteúdo:
│  │  │  ├─ Abrir pasta em VS Code
│  │  │  ├─ Terminal integrado (Ctrl + `)
│  │  │  ├─ Compilar no VS Code
│  │  │  ├─ Executar no VS Code
│  │  │  ├─ Atalhos úteis (Ctrl+K, Ctrl+H, F1, etc)
│  │  │  ├─ Code Runner (extensão opcional)
│  │  │  ├─ Debugging com breakpoints
│  │  │  ├─ Editar código direto no VS Code
│  │  │  └─ Troubleshooting VS Code específico
│  │  └─ Público: Usuários de VS Code
│  │
│  ├─ README.md (Documentação Técnica)
│  │  ├─ Responsabilidade: REFERÊNCIA TÉCNICA COMPLETA
│  │  ├─ Conteúdo:
│  │  │  ├─ Overview do projeto
│  │  │  ├─ Características (listas)
│  │  │  ├─ Arquivos (estrutura básica)
│  │  │  ├─ Como começar (setup)
│  │  │  ├─ Gameplay (regras)
│  │  │  ├─ Arquitetura (BatalhaNavalLogic + GUI)
│  │  │  ├─ Estrutura de dados (matrizes, constantes)
│  │  │  ├─ Estrutura de navios (tabela)
│  │  │  ├─ Métodos principais (listagem)
│  │  │  ├─ Implementando multiplayer (próximos passos)
│  │  │  └─ Troubleshooting técnico
│  │  └─ Público: Desenvolvedores
│  │
│  ├─ INDICE.md (Mapa Completo)
│  │  ├─ Responsabilidade: NAVEGAÇÃO DO PROJETO
│  │  ├─ Conteúdo:
│  │  │  ├─ Visão geral do projeto
│  │  │  ├─ Descrição de CADA arquivo
│  │  │  ├─ Fluxo de execução (diagrama)
│  │  │  ├─ Cores e estados (tabela)
│  │  │  ├─ Como contribuir/expandir
│  │  │  ├─ Checklist de qualidade
│  │  │  ├─ Próximas fases (Fase 2, 3, 4)
│  │  │  ├─ Estatísticas do projeto
│  │  │  └─ Suporte rápido (tabela de dúvidas)
│  │  └─ Público: Quem quer entender tudo
│  │
│  ├─ GITHUB_UPLOAD.md (Como Subir)
│  │  ├─ Responsabilidade: INSTRUÇÕES GITHUB
│  │  ├─ Conteúdo:
│  │  │  ├─ Pré-requisitos (Git, conta GitHub)
│  │  │  ├─ Criar repositório (passo 1)
│  │  │  ├─ Configurar Git localmente (passo 2)
│  │  │  ├─ Adicionar arquivos (git add .)
│  │  │  ├─ Fazer commit (git commit -m)
│  │  │  ├─ Configurar branch (git branch -M main)
│  │  │  ├─ Conectar ao GitHub (git remote add)
│  │  │  ├─ Fazer push (git push -u origin main)
│  │  │  ├─ Próximas atualizações (git workflow)
│  │  │  ├─ Comandos úteis de Git
│  │  │  └─ Troubleshooting Git
│  │  └─ Público: Quem quer subir no GitHub
│  │
│  ├─ RESUMO_PROJETO.txt (Resumo Visual)
│  │  ├─ Responsabilidade: OVERVIEW ASCII VISUAL
│  │  ├─ Conteúdo:
│  │  │  ├─ Lista visual de arquivos
│  │  │  ├─ Requisitos implementados (✓✓✓)
│  │  │  ├─ Como executar (opções)
│  │  │  ├─ Cores utilizadas (com RGB)
│  │  │  ├─ Estrutura de dados (matrizes)
│  │  │  ├─ Navios no jogo (tabela)
│  │  │  ├─ Próximas expansões
│  │  │  ├─ Estrutura do código (árvore)
│  │  │  └─ Troubleshooting (❌ → solução)
│  │  └─ Público: Leitura rápida e visual
│  │
│  └─ ESTRUTURA_PASTA.md (Este arquivo!)
│     ├─ Responsabilidade: MAPA DETALHADO DA PASTA
│     ├─ Conteúdo:
│     │  ├─ Estructura em árvore visual
│     │  ├─ Responsabilidade de CADA arquivo
│     │  ├─ O que CADA arquivo contém
│     │  ├─ Quando usar CADA arquivo
│     │  ├─ Dependências entre arquivos
│     │  └─ Fluxo de leitura recomendado
│     └─ Público: Quem quer entender a organização
│
├─ 🔧 SCRIPTS DE EXECUÇÃO (Automação)
│  │
│  ├─ run.sh (Linux/macOS - 995 bytes)
│  │  ├─ Responsabilidade: AUTOMATIZAR EXECUÇÃO (Unix)
│  │  ├─ O que faz:
│  │  │  ├─ Verifica se Java está instalado
│  │  │  ├─ Mostra versão do Java
│  │  │  ├─ Compila: javac BatalhaNavalLogic.java BatalhaNavalGUI.java
│  │  │  ├─ Se compilação falhar → mostra erro e sai
│  │  │  ├─ Se sucesso → executa: java BatalhaNavalGUI
│  │  │  └─ Mostra feedback visual (✓, 🔨, 🎮, ❌)
│  │  ├─ Como usar:
│  │  │  ├─ chmod +x run.sh (primeira vez)
│  │  │  └─ ./run.sh (executar)
│  │  └─ Público: Usuários Linux/macOS
│  │
│  └─ run.bat (Windows - 1.1 KB)
│     ├─ Responsabilidade: AUTOMATIZAR EXECUÇÃO (Windows)
│     ├─ O que faz:
│     │  ├─ Verifica se javac está disponível
│     │  ├─ Mostra versão do Java
│     │  ├─ Compila: javac *.java
│     │  ├─ Se compilação falhar → pausa para ler erro
│     │  ├─ Se sucesso → executa: java BatalhaNavalGUI
│     │  └─ Pausa ao final (para ver resultado)
│     ├─ Como usar:
│     │  ├─ Duplo clique direto no arquivo
│     │  └─ Ou no terminal: run.bat
│     └─ Público: Usuários Windows
│
└─ ⚙️ CONFIGURAÇÃO (Controle de Versão)
   │
   └─ .gitignore (142 bytes)
      ├─ Responsabilidade: CONTROLE GIT
      ├─ O que ignora:
      │  ├─ *.class (arquivos compilados)
      │  ├─ *.jar, *.war, *.ear
      │  ├─ .idea/, .vscode/ (IDEs)
      │  ├─ *.log (logs)
      │  ├─ build/, dist/ (diretórios)
      │  └─ Arquivos temporários
      ├─ Propósito: Não versionar lixo/compilados
      └─ Público: Sistema de controle de versão (Git)
```

---

## 📊 Mapa de Responsabilidades

### Por Tipo de Arquivo

#### 1️⃣ CÓDIGO JAVA (Núcleo)
```
BatalhaNavalLogic.java
  ↓
  Gerencia: Lógica pura, matrizes, turnos, vitória

BatalhaNavalGUI.java
  ↓ depende de
  BatalhaNavalLogic
  ↓
  Gerencia: Interface, cores, eventos, visual
```

#### 2️⃣ DOCUMENTAÇÃO (Guias de Leitura)
```
LEIA_PRIMEIRO.txt (Entrada)
       ↓
       ├→ INSTRUCOES_EXECUCAO.md (Como rodar)
       ├→ COMO_USAR_VSCODE.md (VS Code específico)
       ├→ README.md (Entender o código)
       ├→ INDICE.md (Mapa completo)
       ├→ GITHUB_UPLOAD.md (Subir GitHub)
       ├→ RESUMO_PROJETO.txt (Overview visual)
       └→ ESTRUTURA_PASTA.md (Este arquivo)
```

#### 3️⃣ SCRIPTS (Automação)
```
run.sh (Linux/macOS)
  ├─ Compila: javac *.java
  └─ Executa: java BatalhaNavalGUI

run.bat (Windows)
  ├─ Compila: javac *.java
  └─ Executa: java BatalhaNavalGUI
```

#### 4️⃣ CONFIGURAÇÃO (Ambiente)
```
.gitignore
  ├─ Ignora: *.class (compilados)
  └─ Mantém: *.java, *.md (fontes)
```

---

## 🎯 Fluxo de Leitura Recomendado

### Para Iniciante (3 minutos)
```
1. LEIA_PRIMEIRO.txt
2. Execute: ./run.sh ou run.bat
3. Jogue!
```

### Para Desenvolvedor (30 minutos)
```
1. README.md → entender arquitetura
2. BatalhaNavalLogic.java → estudar lógica
3. BatalhaNavalGUI.java → estudar interface
4. INDICE.md → compreender completo
```

### Para Usuário VS Code
```
1. COMO_USAR_VSCODE.md
2. Abra pasta em VS Code
3. Terminal integrado + javac *.java
4. java BatalhaNavalGUI
```

### Para Quem Quer Adicionar Multiplayer
```
1. README.md → entender estrutura
2. INDICE.md → seção "Como Contribuir"
3. BatalhaNavalLogic.java → métodos Socket
4. Implemente a lógica de rede
```

### Para GitHub
```
1. GITHUB_UPLOAD.md
2. Siga os 7 passos
3. Pronto para compartilhar!
```

---

## 🔄 Dependências Entre Arquivos

```
LEIA_PRIMEIRO.txt
       ↓ referencia
       ├→ run.sh / run.bat (execução)
       ├→ INSTRUCOES_EXECUCAO.md
       ├→ COMO_USAR_VSCODE.md
       └→ README.md

BatalhaNavalGUI.java
       ↓ depende de
       BatalhaNavalLogic.java

BatalhaNavalLogic.java
       ↓ nenhuma dependência externa
       (apenas Java nativo)

README.md
       ↓ menciona
       ├→ BatalhaNavalLogic.java
       ├→ BatalhaNavalGUI.java
       └→ padrão MVC

INDICE.md
       ↓ referencia
       ├→ Todos os arquivos
       ├→ Fluxo de execução
       └→ Próximas expansões
```

---

## 📋 Quando Usar Cada Arquivo

| Situação | Leia... |
|----------|---------|
| Sou iniciante | LEIA_PRIMEIRO.txt |
| Quero rodar rápido | run.sh ou run.bat |
| Preciso de instruções | INSTRUCOES_EXECUCAO.md |
| Uso VS Code | COMO_USAR_VSCODE.md |
| Preciso entender o código | README.md |
| Quero um mapa completo | INDICE.md |
| Vou usar GitHub | GITHUB_UPLOAD.md |
| Quero resumo visual | RESUMO_PROJETO.txt |
| Quero entender a pasta | ESTRUTURA_PASTA.md (este) |
| Vou editar código | BatalhaNavalLogic.java ou BatalhaNavalGUI.java |
| Vou implementar socket | BatalhaNavalLogic.java (métodos placeholder) |

---

## 🎮 Fluxo de Execução do Jogo

```
1. Usuário executa: java BatalhaNavalGUI

2. BatalhaNavalGUI.main()
   └─ Cria instância de BatalhaNavalLogic

3. BatalhaNavalGUI.__init__()
   ├─ Cria janela Swing
   ├─ Desenha 2 tabuleiros 10x10 (200 botões)
   ├─ Posiciona navios (função auxiliar)
   └─ Mostra interface

4. Usuário clica em botão do tabuleiro inimigo

5. BatalhaNavalGUI.realizarJogada()
   ├─ Chama: BatalhaNavalLogic.verificarJogada()
   ├─ Recebe: 1 (acerto), 0 (erro), -1 (inválido)
   ├─ Atualiza cor do botão
   └─ Se erro → Timer → turnoInimigo()

6. BatalhaNavalLogic.turnoInimigo()
   ├─ Gera posição aleatória
   ├─ Verifica seu tabuleiro
   ├─ Acerto ou erro?
   └─ Retorna para GUI

7. Verificação de Vitória/Derrota
   ├─ BatalhaNavalLogic.verificarVitoria()
   └─ BatalhaNavalLogic.verificarDerrota()

8. Se fim de jogo:
   └─ Mostrar diálogo + novo jogo
```

---

## 📊 Tamanho e Complexidade

| Arquivo | Tipo | Linhas | Complexidade |
|---------|------|--------|--------------|
| BatalhaNavalLogic.java | Código | 207 | Média |
| BatalhaNavalGUI.java | Código | 357 | Alta |
| README.md | Doc | ~280 | Baixa |
| INSTRUCOES_EXECUCAO.md | Doc | ~150 | Baixa |
| COMO_USAR_VSCODE.md | Doc | ~280 | Baixa |
| INDICE.md | Doc | ~450 | Média |
| GITHUB_UPLOAD.md | Doc | ~280 | Baixa |
| RESUMO_PROJETO.txt | Doc | ~240 | Baixa |
| ESTRUTURA_PASTA.md | Doc | ~350 | Média |
| run.sh | Script | ~30 | Muito Baixa |
| run.bat | Script | ~30 | Muito Baixa |
| .gitignore | Config | ~15 | Muito Baixa |

---

## ✅ Checklist de Uso

Ao usar este projeto:

- [ ] Li LEIA_PRIMEIRO.txt
- [ ] Verifiquei Java instalado (java -version)
- [ ] Executei ./run.sh ou run.bat
- [ ] Jogo abriu e funcionou
- [ ] Li README.md para entender o código
- [ ] Abri os arquivos .java em um editor
- [ ] Joguei uma partida completa
- [ ] Consultei INDICE.md para expandir
- [ ] Estou pronto para customizar!

---

## 🎯 Resumo Final

Esta pasta contém um **jogo de Batalha Naval completo e pronto para usar**:

- **2 arquivos Java** = Código funcional
- **7 documentos** = Guias e referências
- **2 scripts** = Execução automática
- **1 configuração** = Controle de versão

**Total: 12 arquivos, ~2.200 linhas, ~75 KB**

Tudo está interligado e bem organizado para fácil entendimento e expansão!

---

**Data:** 2026-05-06  
**Status:** Completo e Funcional  
**Próximo Passo:** Escolha uma opção acima e comece!
