package Codigo.tests.GraphTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

import Codigo.src.Graph.Graph;
import Codigo.src.Graph.GraphMatrix;

public class VerticeMatrizTest {
    Graph grafo;
    GraphMatrix grafo_matriz;

    @BeforeEach
    void setup() {
        grafo = new Graph(10);
        grafo_matriz = new GraphMatrix(10);
    }

    @Test
    public void QuantidadeDeVertices() {
        grafo_matriz = new GraphMatrix(10);
        assertEquals(10, grafo_matriz.getQuantidadeVerticesNaMatriz());
    }

    @Test
    public void PonderarVerticeMatrizTeste() {
        grafo_matriz = new GraphMatrix(10);
        grafo_matriz.ponderarVertice(1, 10);
        assertEquals(10, grafo_matriz.matrix_peso_vertices[1]);
    }

    @Test
    public void VerificarAdjacenciaDeVerticeNaMatrizTeste() {
        grafo_matriz = new GraphMatrix(10);
        grafo_matriz.addArestaNaMatriz(0, 1);
        assertEquals(true, grafo_matriz.existeAdjacenciaEntreOsVertices(0, 1));
    }

}
