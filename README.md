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
| Representação de grafos utilizando Matriz de adjacência | ✅       | Gabriel  | -          |
| Representação de grafos utilizando Lista de adjacência  | ✅       | Gabriel  | -          |

### MANIPULAÇÃO

| Tarefa                                                                                     | Situação | Quem Fez | Observação |
| ------------------------------------------------------------------------------------------ | -------- | -------- | ---------- |
| Criação de um grafo com X v ́ertices (o número de v ́ertices deve ser inserido pelo usuário) | ✅       | Gabriel  | -          |
| Criação e remoção de arestas                                                               | ✅       | Gabriel  | -          |
| Ponderação e rotulação de vertices                                                         | ✅       | Gabriel  |            |
| Ponderação e rotulação de arestas                                                          | ✅       | Gabriel  |            |
| Checagem de adjacência entre vertices                                                      | ✅       | Gabriel  | -          |
| Checagem de adjacência entre vertices                                                      | ✅       | Gabriel  |            |
| Checagem da adjacência de arestas                                                          | ✅       | Gabriel  |            |
| Checagem da quantidade de vertices e arestas                                               | ✅       | Gabriel  | -          |
| Checagem de grafo vazio e completo                                                         | ✅       | Gabriel  |            |

## [ ENTREGA 2 ]

Uma ponte em um grafo  ́e definido como uma aresta cuja remoção desconectado o grafo. O problema
de se determinar pontes existentes em um grafo apresenta várias aplicações, dentre elas encontrar
caminhos (ou ciclos) eulerianos. Na segunda etapa deste trabalho você deverá implementar dois
métodos para identificação de pontes: 

1. método naive em que testa-se a conectividade de um grafo para cada remoção de aresta (utilizando uma busca em largura ou profundidade por exemplo); 
2.  méetodo baseado em Tarjan (artigo em anexo). 

Após implementadas as duas soluções para detecção de pontes, você deverá encontrar um caminho euleriano, usando Algoritmo de Fleury, em um grafo euleriano usando as duas estratégias implementadas. Ilustre os tempos computacionais necessários para as duas estratégias utilizando como teste
grafos grafos aleatórios contendo 100, 1000, 10000 e 100000 vértices.


| Tarefa                                                    | Situação | Quem Fez | Observação |
| --------------------------------------------------------- | -------- | -------- | ---------- |
| Busca em profundidade                                     | ✅       | Gabriel  | -          |
| Teste de busca em profundidade                            | ❌       |          | -          |
| Grafos de 100, 1.000, 10.000 e 100.000 vertices           | ❌       |          | -          |
| Algoritmo para gerar grafos aleatórios vertices           | ✅       | Gabriel  | -          |
| Salvamento de grafo em arquivo                            | ❌       |          | -          |
| Algoritmo de Fleury                                       | ❌       |          | -          |
| Algoritmo de Tarjan                                       | ❌       |          | -          |
| Testes de tempo de processamento da busca em profundidade | ❌       |          | -          |
| Testes de tempo de processamento de Fleury                | ❌       |          | -          |
| Testes de tempo de processamento de Tarjan                | ❌       |          | -          |
|                                                           | ❌       |          | -          |
|                                                           | ❌       |          | -          |