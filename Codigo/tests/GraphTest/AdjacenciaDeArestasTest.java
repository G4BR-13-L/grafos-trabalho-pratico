package Codigo.tests.GraphTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Codigo.src.Graph.Graph;
import Codigo.src.Graph.GraphMatrix;

public class AdjacenciaDeArestasTest {
    Graph grafo;
    GraphMatrix grafo_matriz;

    @BeforeEach
    void setup() {
        grafo = new Graph(10);
        grafo_matriz = new GraphMatrix(10);
    }

    @Test
    public void AdjacenciaArestaTeste() {
        GraphMatrix g_matriz = new GraphMatrix(3);
        g_matriz.addArestaNaMatriz(0, 1);
        g_matriz.addArestaNaMatriz(1, 2);
        g_matriz.addArestaNaMatriz(2, 0);

        Graph g_adjacente = new Graph(3);
        g_adjacente.addAresta(0, 1);
        g_adjacente.addAresta(1, 2);
        g_adjacente.addAresta(2, 0);

        assertEquals(true, g_matriz.isArestasAdjacentes(0, 1, 1, 2));
        assertEquals(true, g_adjacente.isArestasAdjacentes(0, 1, 1, 2));
    }

}
