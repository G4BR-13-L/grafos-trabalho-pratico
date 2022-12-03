package Codigo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Codigo.src.Graph.Graph;
import Codigo.src.GraphGenerator.GraphGenerator;

public class GraphGeneratorTest {

    @Test
    public void gerarGrafoDeTamanhoCorretoTeste() {
        Graph g = GraphGenerator.generateGraph(10, 1, 3);
        assertEquals(true, (g.getQuantidadeArestas() <= 30));
        assertEquals(true, (g.getQuantidadeArestas() >= 10));
        assertEquals(10, g.getQuantidadeVertices());
    }
}
