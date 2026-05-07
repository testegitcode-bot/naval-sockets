# Protocolo de Comunicação - Batalha Naval Multiplayer

## Visão Geral

Este documento descreve o protocolo de comunicação para implementação futura de multiplayer via Socket (TCP/IP) no jogo Batalha Naval.

**Status Atual:** Placeholders prontos na classe `BatalhaNavalLogic.java`  
**Próximo Passo:** Implementar `enviarJogadaSocket()` e `receberJogadaSocket()`

---

## Constantes Definidas em BatalhaNavalLogic

```java
// === PROTOCOLO DE COMUNICAÇÃO (para multiplayer via Socket) ===
public static final String NET_TIRO = "TIRO";           // Ex: TIRO;4;5
public static final String NET_RESULTADO = "RES";       // Ex: RES;ACERTO ou RES;ERRO
public static final String NET_TURNO = "TURNO";         // Sincronização de turno
public static final String NET_ACERTO = "ACERTO";       // Resultado: acertou
public static final String NET_ERRO = "ERRO";           // Resultado: errou
```

---

## Formato de Mensagens

### 1. Comando de Tiro (Jogador ataca)

**Enviado pelo:** Jogador 1 para Jogador 2  
**Formato:** `TIRO;linha;coluna`

**Exemplos:**
```
TIRO;4;5
TIRO;0;0
TIRO;9;9
```

**Interpretação:**
- `TIRO` = Tipo de comando
- `linha` = Linha do tabuleiro (0-9)
- `coluna` = Coluna do tabuleiro (0-9)

---

### 2. Comando de Resultado (Resposta do ataque)

**Enviado pelo:** Jogador 2 para Jogador 1 (respondendo a um tiro)  
**Formato:** `RES;ACERTO` ou `RES;ERRO`

**Exemplos:**
```
RES;ACERTO
RES;ERRO
```

**Interpretação:**
- `RES` = Tipo de comando (resultado)
- `ACERTO` = Acertou um navio
- `ERRO` = Atacou água

---

### 3. Comando de Sincronização de Turno

**Enviado pelo:** Servidor ou Jogador 1 (para sincronizar)  
**Formato:** `TURNO;jogador_id`

**Exemplos:**
```
TURNO;1
TURNO;2
```

**Interpretação:**
- `TURNO` = Comando de sincronização
- `jogador_id` = 1 ou 2 (indicando de quem é a vez)

---

## Fluxo Completo de Uma Jogada

```
Jogador 1                          Rede                          Jogador 2
    |                                |                               |
    | Clica em (4, 5)                |                               |
    |---Verifica se válido-----------|                               |
    |                                |                               |
    |--------TIRO;4;5 ------------>|                               |
    |                                |-------TIRO;4;5-------->    |
    |                                |                      Verifica tabuleiro
    |                                |                      (tem navio ou não?)
    |                                |                               |
    |                                | <----RES;ACERTO--------|
    | <--------RES;ACERTO --------------|                               |
    |                                |                               |
    | Atualiza visual (vermelho/branco) |                          |
    | Se acerto -> ataca novamente    |                               |
    | Se erro -> passa para adversário |                               |
    |                                |--------TURNO;2-------->    |
    |                                |                               |
    |                             <-- AGUARDA TIRO DO JOGADOR 2 ---|
```

---

## Correspondência com Valores do Jogo

### Estados das Células

| Valor | Constante | Significado |
|-------|-----------|-------------|
| 0 | AGUA | Célula vazia |
| 1 | NAVIO | Célula com navio |
| 2 | ACERTO | Célula atacada com sucesso |
| 3 | ERRO | Célula atacada sem sucesso |

### Resultados de Ataque

| Texto | Valor | Ação |
|-------|-------|------|
| `ACERTO` | 1 | Jogador continua atacando |
| `ERRO` | 0 | Turno passa para adversário |
| `INVALIDO` | -1 | Posição já foi atacada |

---

## Exemplo de Implementação (Pseudocódigo)

```java
// Enviar tiro via Socket
public void enviarJogadaSocket(int linha, int coluna) {
    String mensagem = BatalhaNavalLogic.NET_TIRO + ";" + linha + ";" + coluna;
    // socket.enviar(mensagem);
    System.out.println("[ENVIADO] " + mensagem);
}

// Receber resultado do tiro
public void receberJogadaSocket() {
    // String resultado = socket.receber();
    // if (resultado.startsWith(BatalhaNavalLogic.NET_RESULTADO)) {
    //     String[] partes = resultado.split(";");
    //     if (partes[1].equals(BatalhaNavalLogic.NET_ACERTO)) {
    //         // Acertou!
    //     } else {
    //         // Errou!
    //     }
    // }
    System.out.println("[SOCKET] Aguardando resultado...");
}

// Exemplo de parsing de mensagem recebida
private void processarMensagem(String mensagem) {
    String[] partes = mensagem.split(";");
    String comando = partes[0];
    
    if (comando.equals(NET_TIRO)) {
        int linha = Integer.parseInt(partes[1]);
        int coluna = Integer.parseInt(partes[2]);
        processarTiroRecebido(linha, coluna);
        
    } else if (comando.equals(NET_RESULTADO)) {
        String resultado = partes[1];
        processarResultado(resultado);
        
    } else if (comando.equals(NET_TURNO)) {
        int jogadorId = Integer.parseInt(partes[1]);
        sincronizarTurno(jogadorId);
    }
}
```

---

## Integrando com a GUI

### Em BatalhaNavalGUI.java

Quando uma jogada é realizada, em vez de chamar `turnoInimigo()` diretamente:

```java
// AGORA (local):
int resultado = logica.verificarJogada(linha, coluna);
logica.turnoInimigo(); // Simula IA local

// FUTURO (multiplayer):
int resultado = logica.verificarJogada(linha, coluna);
logica.enviarJogadaSocket(linha, coluna);
// Aguardar receberJogadaSocket() para resposta
// processarResultadoSocket(resposta);
```

---

## Sequência de Inicialização da Partida

```
1. Servidor aguarda conexão de 2 clientes
2. Cliente 1 conecta
3. Cliente 2 conecta
4. Servidor envia: TURNO;1 (Jogador 1 começa)
5. Ambos posicionam navios
6. Jogo começa!
```

---

## Tratamento de Erros

### Mensagens Inválidas

```
INVALIDO;motivo
INVALIDO;POS_ATACADA
INVALIDO;FORA_LIMITES
INVALIDO;CONEXAO_PERDIDA
```

### Reconexão

```
RECONECTAR;id_sessao
RECONECTAR_RESPOSTA;ok
```

---

## Considerações de Segurança

1. **Validação**: Sempre validar coordenadas no servidor
2. **Timeout**: Desconectar se não houver movimento em X segundos
3. **Integridade**: Enviar checksum de tabuleiro periodicamente
4. **Autenticação**: Implementar token de sessão

---

## Próximas Etapas de Implementação

### Fase 1: Socket Básico
- [ ] Implementar classe `ClienteSocket`
- [ ] Implementar classe `ServidorSocket`
- [ ] Teste de conexão básica

### Fase 2: Protocolo Completo
- [ ] Enviar/receber `TIRO`
- [ ] Enviar/receber `RES`
- [ ] Sincronizar `TURNO`

### Fase 3: Tratamento de Erros
- [ ] Reconexão automática
- [ ] Timeout de sessão
- [ ] Mensagens de erro

### Fase 4: Melhorias
- [ ] Chat entre jogadores
- [ ] Histórico de movimentos
- [ ] Replays de partidas

---

## Código Base Pronto

Os métodos placeholder já estão em `BatalhaNavalLogic.java`:

```java
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
```

Basta preencher estes métodos com a lógica de Socket real quando estiver pronto!

---

**Data:** 2026-05-07  
**Status:** Protocolo Definido - Pronto para Implementação  
**Próximo:** Implementar Socket em nova versão
