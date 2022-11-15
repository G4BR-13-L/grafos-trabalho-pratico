package Codigo.src;

import java.io.File;
import java.io.FileNotFoundException;

import Codigo.src.Graph.Graph;
import Codigo.src.GraphIO.GraphIO;

public class Main {
    public static Graph graph;

    public static void main(String[] args) throws FileNotFoundException {

        graph = GraphIO.readGraph("");
        System.out.println(graph.toString());
    }
}
