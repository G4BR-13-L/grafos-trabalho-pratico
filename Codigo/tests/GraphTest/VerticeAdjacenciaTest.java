package Codigo.tests.GraphTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Codigo.src.Graph.Graph;
import Codigo.src.Graph.GraphMatrix;

public class VerticeAdjacenciaTest {
    Graph grafo;
    GraphMatrix grafo_matriz;

    @BeforeEach
    public void setup() {
        grafo = new Graph(10);
        grafo_matriz = new GraphMatrix(10);
    }

    @Test
    public void QuantidadeDeVertices() {
        grafo = new Graph(10);
        assertEquals(10, grafo.getQuantidadeVertices());
    }

    public void PonderarVerticeAdjacenciaTeste() {
        grafo.ponderarVertice(1, 10);
        assertEquals(10, grafo.vertices.get(1).peso);
    }

    @Test
    public void VerificarAdjacenciaDeVerticeNaAdjacenciaTeste() {
        grafo = new Graph(10);
        grafo.addAresta(1, 2);
        assertEquals(true, grafo.existeAdjacenciaEntreOsVertices(1, 2));
    }

}
