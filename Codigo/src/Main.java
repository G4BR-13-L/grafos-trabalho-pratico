package Codigo.src;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Codigo.src.Graph.Graph;
import Codigo.src.GraphGenerator.GraphGenerator;
import Codigo.src.GraphIO.GraphIO;

public class Main {
    public static Graph graph1;
    public static Graph graph2;
    public static Graph graph3;
    public static Graph graph4;
    public static Graph graph5;
    public static Graph graph6;
    public static Graph graph7;

    public static void main(String[] args) throws IOException {

        

        // Instanciando Grafo 1 a partir de arquivo
        System.out.println("-----------------------------------------");
        System.out.println("Instanciando Grafo 1 a partir de arquivo");
        graph1 = GraphIO.readGraph("Codigo/src/GraphIO/grafo_teste.pajek");
        graph1.GerarListaDeAdjacenciaAPartirDaMatriz();
        System.out.println(graph1.toString());

        System.out.println("\n\n===");

        // Instanciando grafo 2 a partir no numero de vertices
        System.out.println("-----------------------------------------");
        System.out.println("Instanciando grafo 2 a partir no numero de vertices");
        graph2 = new Graph(10);
        System.out.println(graph2.toString());

        // Adicionando aresta ao grafo
        System.out.println("-----------------------------------------");
        System.out.println("Adicionando aresta ao grafo");
        graph2.addAresta(5, 8);
        System.out.println(graph2.toString());

        // Removendo Aresta do grafo
        System.out.println("-----------------------------------------");
        System.out.println("Removendo Aresta do grafo");
        graph2.rmAresta(5, 8);
        System.out.println(graph2.toString());

        // Ponderando vertice do grafo
        System.out.println("-----------------------------------------");
        System.out.println("Ponderando vertice do grafo");
        graph2.ponderarVertice(5, 8);
        System.out.println(graph2.toString());

        //Ponderando Aresta do grafo
        System.out.println("-----------------------------------------");
        System.out.println("onderando Aresta do grafo");
        graph2.addAresta(5, 8);
        graph2.ponderarAresta(5, 8, 20);
        System.out.println(graph2.toString()); 


        System.out.println("\n\n\n");
        System.out.println("\n\n\n");


        // Busca em profundidade
        System.out.println("-----------------------------------------");
        System.out.println("Busca em profundidade");
        graph3 = new Graph(6);
        graph3.addAresta(0, 1);
        graph3.addAresta(0, 2);
        graph3.addAresta(1, 3);
        graph3.addAresta(1, 4);
        graph3.addAresta(0, 4);
        graph3.addAresta(2, 4);
        graph3.addAresta(4, 5);
        graph3.addAresta(3, 5);
        graph3.addAresta(1, 5);
        System.out.println(graph3.toString()); 
        graph3.ExecutarBuscaEmProfundidade(true);


        // Gerador de grafo
        System.out.println("-----------------------------------------");
        System.out.println("Gerador de grafo");
        graph4 = GraphGenerator.generateGraph(100, 2, 6);
        System.out.println(graph4.toString());

        // Busca por ponte de maneira ingenua
        System.out.println("-----------------------------------------");
        System.out.println("Busca por ponte de maneira ingenua");
        graph5 = new Graph(5);
        graph5.addAresta(1, 0);
        graph5.addAresta(0, 2);
        graph5.addAresta(2, 1);
        graph5.addAresta(0, 3);
        graph5.addAresta(3, 4);
        System.out.println(graph5.toString());
        graph5.buscaNaive();


        // Busca por ponte Tarjan
        System.out.println("-----------------------------------------");
        System.out.println("Busca por ponte Tarjan");
        graph6 = new Graph(5);
        graph6.addAresta(1, 0);
        graph6.addAresta(0, 2);
        graph6.addAresta(2, 1);
        graph6.addAresta(0, 3);
        graph6.addAresta(3, 4);
        System.out.println(graph5.toString());
        graph6.executarBuscarPontes();

        // Fleury
        System.out.println("-----------------------------------------");
        System.out.println("Fleury");
        graph7 = new Graph(4);
        graph7.addAresta(0, 1);
        graph7.addAresta(0, 2);
        graph7.addAresta(1, 2);
        graph7.addAresta(2, 3);
        graph7.Fleury();
    }
}
