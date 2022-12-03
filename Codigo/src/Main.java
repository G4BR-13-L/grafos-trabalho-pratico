package Codigo.src;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import Codigo.src.Graph.Graph;
import Codigo.src.GraphGenerator.GraphGenerator;
import Codigo.src.GraphIO.GraphIO;

public class Main {
    public static Graph graph1;
    public static Graph graph2;
    public static Graph graph3;
    public static Graph graph4;

    public static void main(String[] args) throws IOException {

        // Instanciando Grafo 1 a partir de arquivo
        /* graph1 = GraphIO.readGraph("Codigo/src/GraphIO/grafo_teste.pajek");
        graph1.GerarListaDeAdjacenciaAPartirDaMatriz();
        System.out.println(graph1.toString());

        System.out.println("\n\n===");

        // Instanciando grafo 2 a partir no numero de vertices
        graph2 = new Graph(10);
        System.out.println(graph2.toString());

        // Adicionando aresta ao grafo
        graph2.addAresta(5, 8);
        System.out.println(graph2.toString());

        // Removendo Aresta do grafo
        graph2.rmAresta(5, 8);
        System.out.println(graph2.toString());

        // Ponderando vertice do grafo
        graph2.ponderarVertice(5, 8);
        System.out.println(graph2.toString());

        // Ponderando Aresta do grafo
        graph2.addAresta(5, 8);
        graph2.ponderarAresta(5, 8, 20);
        System.out.println(graph2.toString()); */

        /* System.out.println("\n\n\n");
        System.out.println("\n\n\n");
        System.out.println("\n\n\n"); */


        // Busca em profundidade
        /* graph3 = new Graph(6);
        graph3.addAresta(0, 1);
        graph3.addAresta(0, 2);
        graph3.addAresta(1, 3);
        graph3.addAresta(1, 4);
        graph3.addAresta(0, 4);
        graph3.addAresta(2, 4);
        graph3.addAresta(4, 5);
        graph3.addAresta(3, 5);
        graph3.addAresta(1, 5);
        System.out.println(graph3.toString()); */

        /* graph3.ExecutarBuscaEmProfundidade(true);
        System.out.println("\n\n\n");
        System.out.println("\n\n\n");
        System.out.println(graph3.getQuantidadeArestas());
        System.out.println(graph3.getQuantidadeDeArestasNaMatriz()); */

        // Gerador de grafo
        /* graph4 = GraphGenerator.generateGraph(23000, 1, 3);
        System.out.println(graph4.toString()); */
        //graph4.ExecutarBuscaEmProfundidade();

        System.out.println("\nCaminhos Fleury: \n");
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.Fleury();

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 0);
        g2.Fleury();
 
        Graph g3 = new Graph(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(3, 2);
        g3.addEdge(3, 1);
        g3.addEdge(2, 4);
        g3.Fleury();




    }
}
