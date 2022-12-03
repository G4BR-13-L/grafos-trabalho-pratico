package Codigo.tests.GraphTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Codigo.src.Graph.Graph;
import Codigo.src.Graph.GraphMatrix;

public class ArestasMatrizTest {
    Graph grafo;
    GraphMatrix grafo_matriz;

    @BeforeEach
    void setup() {
        grafo = new Graph(10);
        grafo_matriz = new GraphMatrix(10);
    }

    @Test
    public void QuantidadeDeArestas() {
        grafo_matriz = new GraphMatrix(10);
        grafo_matriz.addArestaNaMatriz(1, 9);
        grafo_matriz.addArestaNaMatriz(2, 8);
        assertEquals(2, grafo_matriz.getQuantidadeDeArestasNaMatriz());
    }

    @Test
    public void PonderarArestaMatrizTeste() {
        grafo_matriz = new GraphMatrix(10);
        grafo_matriz.ponderarAresta(1, 2, 10);
        assertEquals(10, grafo_matriz.matrix[1][2]);
    }

    @Test
    public void AdicionaArestaComPesoNaMatrizTeste() {
        grafo_matriz = new GraphMatrix(10);
        grafo_matriz.addArestaNaMatriz(1, 2, 10);
        assertEquals(10, grafo_matriz.matrix[1][2]);
    }


}
