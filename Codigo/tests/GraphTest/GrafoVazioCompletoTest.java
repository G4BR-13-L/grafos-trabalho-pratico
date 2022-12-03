package Codigo.tests.GraphTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Codigo.src.Graph.Graph;
import Codigo.src.Graph.GraphMatrix;

public class GrafoVazioCompletoTest {
    Graph grafo;
    GraphMatrix grafo_matriz;

    @BeforeEach
    public void setup() {
        grafo = new Graph(10);
        grafo_matriz = new GraphMatrix(10);
    }

    @Test
    public void VerificarGrafoVazio() {
        GraphMatrix g_matriz = new GraphMatrix(0);
        Graph g_adjacente = new Graph(0);
        assertEquals(true, g_matriz.isVazio());
        assertEquals(true, g_adjacente.isVazio());
    }

    @Test
    public void VerificarGrafoCompleto() {
        GraphMatrix g_matriz = new GraphMatrix(3);
        g_matriz.addArestaNaMatriz(0, 1);
        g_matriz.addArestaNaMatriz(1, 2);
        g_matriz.addArestaNaMatriz(2, 0);

        Graph g_adjacente = new Graph(3);
        g_adjacente.addAresta(0, 1);
        g_adjacente.addAresta(1, 2);
        g_adjacente.addAresta(2, 0);

        assertEquals(true, g_matriz.isCompleto());
        assertEquals(true, g_adjacente.isCompleto());
    }

}
