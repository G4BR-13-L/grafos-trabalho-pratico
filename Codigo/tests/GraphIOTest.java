package Codigo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Codigo.src.Graph.Graph;
import Codigo.src.GraphIO.GraphIO;

public class GraphIOTest {
    @Before
    public void escreverArquivoDeInstancia() throws IOException{
        String str = "*Vertices 9\n*Edges 12\n1 2\n1 9\n2 9\n2 3\n2 8\n3 8\n3 4\n4 5\n4 7\n5 7\n5 6\n6 4";
        FileWriter fWriter = new FileWriter("grafo_teste.pajek");
            fWriter.write(str);
            fWriter.close();
    }
    @Test
    public void testeDeLeituraDeGrafos() throws FileNotFoundException{
        Graph g = GraphIO.readGraph("grafo_teste.pajek");
        assertEquals(9, g.n_vertices);
        assertEquals(12, g.getNumeroDeArestas());
    }
}
