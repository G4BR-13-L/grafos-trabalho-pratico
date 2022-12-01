package Codigo.src;

import java.io.File;
import java.io.FileNotFoundException;

import Codigo.src.Graph.Graph;
import Codigo.src.GraphIO.GraphIO;

/**
 * Entrega 1
 * * Desenvolver uma biblioteca para a manipulação de grafos, contendo:
 * 
 * * REPRESENTAÇÕES
 * * Gabriel - [ ✅ ] Representação de grafos utilizando Matriz de adjacência
 * * Gabriel - [ ✅ ] Representação de grafos utilizando Lista de adjacência
 * 
 * * MANIPULAÇÃO
 * * Funções básicas para manipulação de grafos em ambas representações, incluindo:
 * * Gabriel - [ ✅ ] Criação de um grafo com X v ́ertices (o n ́umero de v ́ertices deve ser inserido pelo usu ́ario)
 * * Gabriel - [ ✅ ] Criação e remoção de arestas
 * * [ ❌ ] Ponderação e rotulação de vertices
 * * [ ❌ ] Ponderação e rotulação de arestas
 * * [ ❌ ] Checagem de adjacência entre v ́ertices
 * * [ ❌ ] Checagem de adjacência entre arestas
 * * [ ❌ ] Checagem da adjacência de arestas
 * * [ ❌ ] Checagem da quantidade de vertices e arestas
 * * [ ❌ ] Checagem de grafo vazio e completo
 */
public class Main {
    public static Graph graph1;
    public static Graph graph2;

    public static void main(String[] args) throws FileNotFoundException {

        // Instanciando Grafo 1 a partir de arquivo
        graph1 = GraphIO.readGraph("Codigo/src/GraphIO/grafo_teste.pajek");
        graph1.GerarListaDeAdjacenciaAPartirDaMatriz();
        System.out.println(graph1.toString());


        System.out.println("\n\n===");


        // Instanciando grafo 2 a partir no numero de vertices
        graph2 = new Graph( 10);
        System.out.println(graph2.toString());

        // Adicionando aresta ao grafo
        graph2.addAresta(5, 8);
        System.out.println(graph2.toString());

        // Removendo Aresta do grafo
        graph2.rmAresta(5, 8);
        System.out.println(graph2.toString());





    }
}
