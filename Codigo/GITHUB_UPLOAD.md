# Como Fazer Upload para GitHub

## Pré-requisitos

1. **Conta no GitHub** - https://github.com
2. **Git instalado** - https://git-scm.com/downloads
3. **SSH configurado ou HTTPS** (recomenda-se SSH)

## Passo 1: Criar Repositório no GitHub

1. Acesse https://github.com/new
2. Preencha os dados:
   - **Repository name**: `BatalhaNaval` (ou o nome que preferir)
   - **Description**: "Jogo de Batalha Naval em Java Swing com interface gráfica completa"
   - **Public** ou **Private** (escolha sua preferência)
   - **Não** adicione README, .gitignore ou licença (já temos)
3. Clique em "Create repository"
4. **COPIE** a URL que aparece (tipo `https://github.com/seu-usuario/BatalhaNaval.git`)

## Passo 2: Configurar Git Localmente

Abra terminal/prompt na pasta `Codigo/`:

```bash
# Inicializar repositório local
git init

# Configurar nome e email (primeira vez apenas)
git config user.name "Seu Nome"
git config user.email "seu-email@example.com"

# Ver status
git status
```

## Passo 3: Adicionar Arquivos

```bash
# Adicionar todos os arquivos
git add .

# Ver o que será commitado
git status
```

Você deve ver:
```
Changes to be committed:
    new file: BatalhaNavalLogic.java
    new file: BatalhaNavalGUI.java
    new file: run.sh
    new file: run.bat
    new file: README.md
    new file: INSTRUCOES_EXECUCAO.md
    new file: COMO_USAR_VSCODE.md
    new file: RESUMO_PROJETO.txt
    new file: INDICE.md
    new file: GITHUB_UPLOAD.md
    new file: .gitignore
```

## Passo 4: Fazer Commit

```bash
git commit -m "Initial commit: Jogo Batalha Naval completo em Java Swing

- Interface gráfica com Swing (2 tabuleiros 10x10)
- Lógica de jogo separada com classe BatalhaNavalLogic
- Sistema de turnos funcionando
- Placeholders para multiplayer via Socket
- Documentação completa
- Scripts de execução (Windows e Unix)"
```

## Passo 5: Configurar Branch Principal

```bash
# Renomear branch para 'main' (padrão moderno)
git branch -M main
```

## Passo 6: Conectar ao GitHub

Substitua `https://github.com/seu-usuario/BatalhaNaval.git` pela URL que você copiou:

```bash
git remote add origin https://github.com/seu-usuario/BatalhaNaval.git
```

Verificar:
```bash
git remote -v
```

Você deve ver:
```
origin  https://github.com/seu-usuario/BatalhaNaval.git (fetch)
origin  https://github.com/seu-usuario/BatalhaNaval.git (push)
```

## Passo 7: Fazer Push (Upload)

```bash
git push -u origin main
```

Se pedir autenticação:
- **HTTPS**: Digite seu username e token (não a senha)
  - Token: https://github.com/settings/tokens
- **SSH**: Deve funcionar automaticamente se configurado

## Pronto!

Seu projeto está no GitHub! Acesse:
```
https://github.com/seu-usuario/BatalhaNaval
```

---

## Próximas Atualizações

Se quiser fazer mais commits depois:

```bash
# Fazer alterações nos arquivos...

# Adicionar mudanças
git add .

# Fazer commit
git commit -m "Descrição da mudança"

# Fazer push
git push
```

## Comandos Úteis

```bash
# Ver histórico de commits
git log

# Ver status
git status

# Ver diferenças
git diff

# Desfazer última mudança (antes de push)
git reset HEAD~1

# Ver remotes configurados
git remote -v
```

## Troubleshooting

### Erro: "fatal: not a git repository"
```bash
cd Codigo/
git init
```

### Erro: "Permission denied (publickey)"
- Configure SSH: https://docs.github.com/en/authentication/connecting-to-github-with-ssh
- Ou use HTTPS em vez de SSH

### Erro: "Authentication failed"
- Gere um token: https://github.com/settings/tokens
- Use o token como senha

### Erro: "The branch 'main' is not configured"
```bash
git push -u origin main
```

---

## Estrutura Final no GitHub

Seu repositório terá:

```
BatalhaNaval/
├── BatalhaNavalLogic.java
├── BatalhaNavalGUI.java
├── run.sh
├── run.bat
├── README.md
├── INSTRUCOES_EXECUCAO.md
├── COMO_USAR_VSCODE.md
├── RESUMO_PROJETO.txt
├── INDICE.md
├── GITHUB_UPLOAD.md
└── .gitignore
```

---

## GitHub Pages (Opcional)

Se quiser criar um site para o projeto:

1. No GitHub, vá para Settings do repositório
2. Role até "GitHub Pages"
3. Selecione branch `main` e pasta `/root`
4. Salve

GitHub criará um site em: `https://seu-usuario.github.io/BatalhaNaval/`

---

## Boas Práticas

1. **Commit messages claras** - Explique o que foi feito
2. **Commits frequentes** - Não faça commits gigantes
3. **Pull antes de push** - `git pull origin main`
4. **Use branches para features** - `git checkout -b feature/socket`
5. **Escreva README bom** - Já incluído!

---

## Próximas Fases no GitHub

Você pode usar GitHub para:

- **Issues**: Rastrear bugs e ideias
- **Projects**: Organizar desenvolvimento
- **Releases**: Publicar versões
- **Discussions**: Comunidade
- **CI/CD**: Testar automaticamente

---

**Seu jogo está pronto para ser compartilhado com o mundo!**

Para dúvidas sobre Git/GitHub: https://docs.github.com
