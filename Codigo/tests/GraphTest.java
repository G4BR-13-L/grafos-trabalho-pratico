package Codigo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Codigo.src.Graph.Graph;

public class GraphTest {

    Graph grafo;

    @BeforeEach
    void setup() {
        grafo = new Graph(10);
    }

    class VerticeMatrizTeste {
        @Test
        public void QuantidadeDeVertices() {
            grafo = new Graph(10);
            assertEquals(10, grafo.getQuantidadeVerticesNaMatriz());
        }
    }

    class ArestasMatrizTeste {
        @Test
        public void QuantidadeDeArestas() {
            grafo.addAresta(1, 9);
            grafo.addAresta(2, 8);
            assertEquals(2, grafo.getQuantidadeDeArestasNaMatriz());

        }
    }

    class VerticeAdjacenciaTest {
        @Test
        public void QuantidadeDeVertices() {
            grafo = new Graph(10);
            assertEquals(10, grafo.getQuantidadeVertices());
        }
    }

    class ArestasAdjacenciaTest {
        @Test
        public void AdicaoDeAresta() {
            grafo.addAresta(1, 9);
            assertEquals(true, grafo.existeAresta(1, 9));
        }

        @Test
        public void remocaoDeAresta() {
            grafo.addAresta(1, 9);
            grafo.rmAresta(1, 9);
            assertEquals(false, grafo.existeAresta(1, 9));
        }

        @Test
        public void QuantidadeDeArestas() {
            grafo.addAresta(1, 9);
            grafo.addAresta(2, 8);
            assertEquals(2, grafo.getQuantidadeArestas());

        }
    }

}
