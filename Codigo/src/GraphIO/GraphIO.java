package Codigo.src.GraphIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Codigo.src.Graph.Graph;


public class GraphIO {
    public GraphIO() {

    }

    public static Graph readGraph(String filepath) throws FileNotFoundException {
        if( filepath == "" ){
            filepath = "Codigo/src/GraphIO/grafo_teste.pajek";
        }
        String str_vertices;        
        String str_arestas;        
        int vertices = 0 ;
        int arestas = 0 ;
        Graph graph;
        System.out.println(filepath);
        File file = new File(filepath);
        Scanner sc = new Scanner(file);

        // Leitura das 2 primeiras linhas: *Vertices e *Edges
        str_vertices = sc.nextLine();
        str_arestas = sc.nextLine();

        //Recorte e  Conversão da Strind lida para numeros inteiros de vertices e arestas
        str_vertices = str_vertices.substring(str_vertices.indexOf(" ")).trim();
        str_arestas = str_arestas.substring(str_arestas.indexOf(" ")).trim();

        // Printando resultados---------------------------------------------------
        System.out.println("a:" + str_arestas + " v: " + str_vertices);

        vertices = Integer.parseInt(str_vertices);
        arestas = Integer.parseInt(str_arestas);

        System.out.println("a:" + arestas + " v:" + vertices);
        //------------------------------------------------------------------------

        //Novo grafo
        graph = new Graph(vertices);

        //Adicionando valores a matrix de adjacencia do grafo
        while (sc.hasNext()) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            graph.matrix[i - 1][j - 1] = 1;
        }
        
        // fechar scanner*/
        sc.close();
        return graph;
    }
}
