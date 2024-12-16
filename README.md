# Tools For RPG – Panpalianos
## Utilitário para Old Dragon

Esse é um projeto pessoal. Baseado no sistema de RPG de Mesa Old Dragon, principalmente no livro básico da 1ª edição.

Inicialmente foi criado como forma de aprender a Linguagem **Java**, mas caso possível, também usar em minhas sessões de RPG.

## Tecnologias
- Linguagem Java
- Java Swing para UI
- GSON para manipulação de arquivos .json

## Features

### Fichas
- Operações básicas para gerenciar fichas
- Possibilidade de aleatorizar atributos da ficha na hora de criação
- Subatributos são calculados de acordo com as regras de Old Dragon

### Iniciativas
- Operações básicas para gerenciar iniciativas

### Estatísticas
- Geração de estatísticas como mínimo, máximo e média de um atributo da party

### Tabela de Preco (Homebrew)
- Tabela de preço de upgrade para armas dos personagens

### Simulador de Combate
- Simulação de um combate, uma ficha jogadora contra uma inimiga

### Arquivos
- Por meio de arquivos pode-se persistir os dados das fichas
- Leitura de arquivos no formato .json

## Créditos

<a href="https://www.flaticon.com/br/icones-gratis/espada" title="espada ícones">Espada ícones criados por Freepik - Flaticon</a><br/>
<a href="https://www.flaticon.com/br/icones-gratis/armaduras" title="armaduras ícones">Armaduras ícones criados por Freepik - Flaticon</a><br/>
<a href="https://www.flaticon.com/br/icones-gratis/escudo" title="escudo ícones">Escudo ícones criados por Freepik - Flaticon</a><br/>

## Anexos

### Tabela Tipos de Ficha
|Tipo da Ficha|Descrição|
|-|-|
|Criatura        |Genérica, representa uma criatura qualquer.|
|Jogador         |Específica ao personagem de jogador. Possui classe, nível, experiência, entre outras características.|

### Ficha de Old Dragon, Frente e Verso
<img src="documentacao/ficha.png" alt="ficha.png" width="400">         <img src="documentacao/ficha.png" alt="fichaVerso.png" width="400">

### Diagrama de classe
![image](documentacao/diagramaClasse.png)