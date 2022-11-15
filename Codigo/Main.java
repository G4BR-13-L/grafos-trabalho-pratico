package Codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Codigo.Graph.Graph;
import Codigo.GraphIO.GraphIO;

public class Main {
    public static Graph graph;

    public static void main(String[] args) throws FileNotFoundException {

        graph = GraphIO.readGraph("grafo_00.pajek");
        System.out.println(graph.toString());
    }
}
