package Codigo.src;

import java.io.File;
import java.io.FileNotFoundException;

import Codigo.src.Graph.Graph;
import Codigo.src.GraphIO.GraphIO;

/**
 * Entrega 1
 * * Desenvolver uma biblioteca para a manipula ̧c ̃ao de grafos, contendo:
 * 
 * * REPRESENTAÇÕES
 * * • Representação de grafos utilizando Matriz de adjacência
 * * • Representação de grafos utilizando Lista de adjacência
 * 
 * * MANIPULAÇÃO
 * * Funções básicas para manipulação de grafos em ambas representa ̧c ̃oes, incluindo:
 * * • Criação de um grafo com X v ́ertices (o n ́umero de v ́ertices deve ser inserido pelo usu ́ario)
 * * • Criação e remo ̧c ̃ao de arestas
 * * • Ponderação e rotulação de v ́ertices
 * * • Ponderação e rotulação de arestas
 * * • Checagem de adjacência entre v ́ertices
 * * • Checagem de adjacência entre arestas
 * * • Checagem da adjacência de arestas
 * * • Checagem da quantidade de v ́ertices e arestas
 * * • Checagem de grafo vazio e completo
 */
public class Main {
    public static Graph graph;

    public static void main(String[] args) throws FileNotFoundException {

        graph = GraphIO.readGraph("Codigo/src/GraphIO/grafo_teste.pajek");
        graph.GerarListaDeAdjacencia();
        System.out.println(graph.toString());
    }
}
