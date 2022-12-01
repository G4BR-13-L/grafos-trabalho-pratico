# Trabalho Prático de Teoria dos Grafos

[Escreva um ou dois  parágrafo resumindo o objetivo do seu projeto.]

## Alunos integrantes da equipe

* Breno Rosa Almeida 
* Gabriel Victor Couto Martins de Paula 
* Luís Antônio de Souza e Sousa 
* Rubia Coelho de Matos 

## Professores responsáveis

* Gabriel Barbosa da Fonseca 

# Código do Projeto

Mantenha neste diretório todo o código do projeto. Se necessário, descreva neste arquivo aspectos relevantes da estrutura de diretórios criada para organização do código.

# CHECKLIST COM AS TAREFAS

## [ ENTREGA 1 ]
Desenvolver uma biblioteca para a manipulação de grafos, contendo:

### REPRESENTAÇÕES
| Tarefa                                                  | Situação | Quem Fez | Observação |
| ------------------------------------------------------- | -------- | -------- | ---------- |
| Representação de grafos utilizando Matriz de adjacência | ✅        | Gabriel  | -          |
| Representação de grafos utilizando Lista de adjacência  | ✅        | Gabriel  | -          |

### MANIPULAÇÃO

| Tarefa                                                                                     | Situação | Quem Fez | Observação |
| ------------------------------------------------------------------------------------------ | -------- | -------- | ---------- |
| Criação de um grafo com X v ́ertices (o número de v ́ertices deve ser inserido pelo usuário) | ✅        | Gabriel  | -          |
| Criação e remoção de arestas                                                               | ✅        | Gabriel  | -          |
| Ponderação e rotulação de vertices                                                         | ❌        |          |            |
| Ponderação e rotulação de arestas                                                          | ❌        |          |            |
| Checagem de adjacência entre vertices                                                      | ✅        | Gabriel  | -          |
| Checagem de adjacência entre arestas                                                       | ❌        |          |            |
| Checagem da adjacência de arestas                                                          | ❌        |          |            |
| Checagem da quantidade de vertices e arestas                                               | ✅        | Gabriel  | -          |
| Checagem de grafo vazio e completo                                                         | ❌        |          |            |

## [ ENTREGA 2 ]

Uma ponte em um grafo  ́e definido como uma aresta cuja remo ̧c ̃ao desconectado o grafo. O problema
de se determinar pontes existentes em um grafo apresenta v ́arias aplica ̧c ̃oes, dentre elas encontrar
caminhos (ou ciclos) eulerianos. Na segunda etapa deste trabalho vocˆe dever ́a implementar dois
m ́etodos para identifica ̧c ̃ao de pontes: (i) m ́etodo naive em que testa-se a conectividade de um grafo
para cada remo ̧c ̃ao de aresta (utilizando uma busca em largura ou profundidade por exemplo); e (ii)
m ́etodo baseado em Tarjan (artigo em anexo).
Ap ́os implementadas as duas solu ̧c ̃oes para detec ̧c ̃ao de pontes, vocˆe dever ́a encontrar um caminho
euleriano, usando Algoritmo de Fleury, em um grafo euleriano usando as duas estrat ́egias implemen-
tadas. Ilustre os tempos computacionais necess ́arios para as duas estrat ́egias utilizando como teste
grafos aleat ́orios contendo 100, 1000, 10000 e 100000 v ́ertices.
