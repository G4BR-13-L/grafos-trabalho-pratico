package Codigo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Codigo.src.Graph.Graph;
import Codigo.src.Graph.GraphMatrix;

public class GraphTest {

    Graph grafo;
    GraphMatrix grafo_matriz;

    @BeforeEach
    void setup() {
        grafo = new Graph(10);
    }

    class VerticeMatrizTeste {
        @Test
        public void QuantidadeDeVertices() {
            grafo_matriz = new GraphMatrix(10);
            assertEquals(10, grafo.getQuantidadeVerticesNaMatriz());
        }

        @Test
        public void PonderarVerticeMatrizTeste() {
            grafo_matriz = new GraphMatrix(10);
            grafo_matriz.ponderarVertice(1, 10);
            assertEquals(10, grafo.matrix_peso_vertices[1]);
        }
    }

    class ArestasMatrizTeste {
        @Test
        public void QuantidadeDeArestas() {
            grafo_matriz.addArestaNaMatriz(1, 9);
            grafo_matriz.addArestaNaMatriz(2, 8);
            assertEquals(2, grafo.getQuantidadeDeArestasNaMatriz());
        }

        @Test
        public void PonderarArestaMatrizTeste() {
            grafo_matriz = new GraphMatrix(10);
            grafo_matriz.ponderarAresta(1,2, 10);
            assertEquals(10, grafo.matrix[1][2]);
        }
    }


    class VerticeAdjacenciaTest {
        @Test
        public void QuantidadeDeVertices() {
            grafo = new Graph(10);
            assertEquals(10, grafo.getQuantidadeVertices());
        }

        public void PonderarVerticeAdjacenciaTeste() {
            grafo.ponderarVertice(1, 10);
            assertEquals(10, grafo.vertices.get(1).peso);
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

        @Test
        public void PonderarArestaAdjacenciaTeste() {
            grafo.addAresta(1, 9);
            grafo.ponderarAresta(1,9 , 10);
            assertEquals(2, grafo.getAresta(1,9).peso);
        }
    }

}
