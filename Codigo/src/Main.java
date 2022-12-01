package Codigo.src;

import java.io.File;
import java.io.FileNotFoundException;

import Codigo.src.Graph.Graph;
import Codigo.src.GraphIO.GraphIO;


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
