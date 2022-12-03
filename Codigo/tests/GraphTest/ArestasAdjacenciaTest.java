package Codigo.tests.GraphTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Codigo.src.Graph.Graph;
import Codigo.src.Graph.GraphMatrix;

public class ArestasAdjacenciaTest {
    Graph grafo;
    

    @Test
    public void AdicaoDeAresta() {
        grafo = new Graph(10);
        grafo.addAresta(1, 9);
        assertEquals(true, grafo.existeAdjacenciaEntreOsVertices(1, 9));
    }

    @Test
    public void remocaoDeAresta() {
        grafo = new Graph(10);
        grafo.addAresta(1, 9);
        grafo.rmAresta(1, 9);
        assertEquals(false, grafo.existeAdjacenciaEntreOsVertices(1, 9));
    }

    @Test
    public void QuantidadeDeArestas() {
        grafo = new Graph(10);
        grafo.addAresta(1, 9);
        grafo.addAresta(2, 8);
        assertEquals(2, grafo.getQuantidadeArestas());
    }

    @Test
    public void PonderarArestaAdjacenciaTeste() {
        grafo = new Graph(10);
        grafo.addAresta(1, 9);
        grafo.ponderarAresta(1, 9, 10);
        assertEquals(10, grafo.getAresta(1, 9).peso);
    }
}
