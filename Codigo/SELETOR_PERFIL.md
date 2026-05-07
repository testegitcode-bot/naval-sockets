# Seletor de Perfil do Jogador - Nova Funcionalidade

## Visão Geral

Uma nova tela de seleção (popup) foi adicionada ao jogo que permite ao jogador escolher seu perfil no início de cada partida. Essa funcionalidade prepara o jogo para multiplayer e melhora a experiência do usuário.

---

## Como Funciona

### Na Inicialização do Jogo

1. Quando você inicia o jogo (`java BatalhaNavalGUI`)
2. Aparece um diálogo popup com duas opções:
   - **Jogador 1 (Esquerda)** - seu tabuleiro fica na esquerda
   - **Jogador 2 (Direita)** - seu tabuleiro fica na direita

### Na Inicialização de Novo Jogo

1. Quando clica em **"Novo Jogo"** durante uma partida
2. O mesmo diálogo popup aparece novamente
3. Você pode escolher trocar de perfil ou manter o mesmo

---

## Comportamento por Perfil

### Jogador 1 (Esquerda)

```
┌──────────────────────┐       ┌──────────────────────┐
│ Meu Tabuleiro (J1)   │       │ Tabuleiro do Inimigo │
│ Lado ESQUERDA        │  ←→   │ Lado DIREITA         │
│ ■ ■ ■ ■              │       │ (sem navios visíveis)│
└──────────────────────┘       └──────────────────────┘

Título da Janela: "Batalha Naval - Jogador 1 (Esquerda)"
```

### Jogador 2 (Direita)

```
┌──────────────────────┐       ┌──────────────────────┐
│ Tabuleiro do Inimigo │       │ Meu Tabuleiro (J2)   │
│ Lado ESQUERDA        │  ←→   │ Lado DIREITA         │
│ (sem navios visíveis)│       │ ■ ■ ■ ■              │
└──────────────────────┘       └──────────────────────┘

Título da Janela: "Batalha Naval - Jogador 2 (Direita)"
```

---

## Diálogo de Seleção

### Aparência

```
╔════════════════════════════════════════════════╗
║                                                ║
║         Selecione seu Perfil                  ║
║     Escolha qual lado você quer jogar        ║
║                                                ║
║  ┌─────────────────────────────────────────┐  ║
║  │  Jogador 1 (Esquerda)                   │  ║
║  └─────────────────────────────────────────┘  ║
║                                                ║
║  ┌─────────────────────────────────────────┐  ║
║  │  Jogador 2 (Direita)                    │  ║
║  └─────────────────────────────────────────┘  ║
║                                                ║
╚════════════════════════════════════════════════╝
```

### Cores

- **Botão Jogador 1**: Azul (SteelBlue)
- **Botão Jogador 2**: Vermelho (Crimson)
- **Fundo**: Cinza escuro
- **Textos**: Branco

---

## Implementação Técnica

### Novo Campo

```java
private int perfilJogador = 0; // 0 = não selecionado, 1 = Jogador 1, 2 = Jogador 2
```

### Novo Método: `exibirDialogoSelecaoPerfil()`

- Cria um JOptionPane com dois botões
- Armazena a escolha em `perfilJogador`
- Atualiza título da janela

### Método Modificado: `atualizarTituloJanela()`

```java
private void atualizarTituloJanela() {
    if (perfilJogador == 1) {
        setTitle("Batalha Naval - Jogador 1 (Esquerda)");
    } else {
        setTitle("Batalha Naval - Jogador 2 (Direita)");
    }
}
```

### Método Modificado: `criarPainelTabuleiros()`

```java
// Agora verifica perfilJogador para ordenar os tabuleiros
if (perfilJogador == 1) {
    // Seu tabuleiro na esquerda, inimigo na direita
    painel.add(painelMeuTabuleiro);
    painel.add(painelTabuleiroInimigo);
} else {
    // Inimigo na esquerda, seu tabuleiro na direita
    painel.add(painelTabuleiroInimigo);
    painel.add(painelMeuTabuleiro);
}
```

### Método Modificado: `novoJogo()`

```java
private void novoJogo() {
    // Agora exibe o diálogo novamente
    exibirDialogoSelecaoPerfil();
    // ... resto do código ...
}
```

---

## Casos de Uso

### Uso Local (Uma Pessoa)

```
Você pode testar ambos os perfis na mesma máquina
1. Jogue como Jogador 1
2. Clique em "Novo Jogo"
3. Escolha Jogador 2
4. Agora sua posição mudou!
```

### Uso Multiplayer (Futuro)

```
Quando implementar Socket:
- Jogador 1 executa o jogo e escolhe "Jogador 1 (Esquerda)"
- Jogador 2 executa o jogo e escolhe "Jogador 2 (Direita)"
- Ambos veem a posição correta do seu lado
- Comunica via Socket qual perfil está usando
```

---

## Fluxo de Inicialização

```
1. java BatalhaNavalGUI
        ↓
2. Construtor BatalhaNavalGUI()
        ↓
3. inicializarInterface() - cria a tela
        ↓
4. exibirDialogoSelecaoPerfil() - mostra popup
        ↓
5. Usuário escolhe (1 ou 2)
        ↓
6. perfilJogador = escolha
        ↓
7. atualizarTituloJanela() - muda título
        ↓
8. criarPainelTabuleiros() - ordena baseado em perfilJogador
        ↓
9. Jogo começa com tabuleiros na ordem correta
```

---

## Fluxo de "Novo Jogo"

```
1. Usuário clica em "Novo Jogo"
        ↓
2. novoJogo() é chamado
        ↓
3. exibirDialogoSelecaoPerfil() - mostra popup novamente
        ↓
4. Usuário escolhe novo perfil (ou mesmo)
        ↓
5. Reset de todos os tabuleiros
        ↓
6. Navios posicionados novamente
        ↓
7. Partida começa com novo layout se trocou de perfil
```

---

## Compatibilidade

- ✅ Totalmente compatível com versões anteriores
- ✅ Jogo continua funcionando normalmente se não quiser usar
- ✅ Padrão: Jogador 1 (se fechar o diálogo)
- ✅ Pronto para multiplayer

---

## Exemplos de Uso

### Exemplo 1: Testar Ambos os Lados

```
1. Iniciar jogo
2. Escolher "Jogador 1"
3. Jogar uma partida
4. Clicar "Novo Jogo"
5. Escolher "Jogador 2"
6. Notar que seu tabuleiro está na direita agora
7. Jogar normalmente, mas de outro lado
```

### Exemplo 2: Prepare para Multiplayer

```
Máquina 1:
- java BatalhaNavalGUI
- Escolher "Jogador 1 (Esquerda)"
- Aguardar conexão

Máquina 2:
- java BatalhaNavalGUI
- Escolher "Jogador 2 (Direita)"
- Conectar à máquina 1
- Ambos veem a posição correta!
```

---

## Próximos Passos para Multiplayer

Quando implementar Socket:

1. Antes de conectar, pedir para escolher perfil
2. Enviar via Socket: `PERFIL;1` ou `PERFIL;2`
3. Cada cliente reconhece seu lado
4. Interface fica automaticamente na ordem correta

---

## Arquivos Modificados

### BatalhaNavalGUI.java
- ✅ Adicionado campo `perfilJogador`
- ✅ Adicionado método `exibirDialogoSelecaoPerfil()`
- ✅ Adicionado método `atualizarTituloJanela()`
- ✅ Modificado construtor para chamar `exibirDialogoSelecaoPerfil()`
- ✅ Modificado `criarPainelTabuleiros()` para ordenar baseado no perfil
- ✅ Modificado `novoJogo()` para exibir diálogo novamente

### SELETOR_PERFIL.md (NOVO)
- ✅ Documentação completa desta funcionalidade

---

## Testes Recomendados

```
☐ 1. Iniciar jogo e escolher Jogador 1
☐ 2. Verificar título: "... Jogador 1 (Esquerda)"
☐ 3. Seu tabuleiro deve estar na ESQUERDA
☐ 4. Jogar uma partida completa
☐ 5. Clicar "Novo Jogo"
☐ 6. Escolher Jogador 2
☐ 7. Verificar título: "... Jogador 2 (Direita)"
☐ 8. Seu tabuleiro deve estar na DIREITA
☐ 9. Jogar normalmente
☐ 10. Fechar o diálogo (deve usar Jogador 1 como padrão)
```

---

**Data:** 2026-05-07  
**Versão:** 1.2  
**Status:** Implementado e Pronto para Testes

