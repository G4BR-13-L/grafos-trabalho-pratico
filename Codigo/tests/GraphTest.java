package Codigo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestClassOrder;

import Codigo.src.Graph.Graph;
import Codigo.src.Graph.GraphMatrix;

public class GraphTest {

    Graph grafo;
    GraphMatrix grafo_matriz;

    @BeforeEach
    void setup() {
        grafo = new Graph(10);
        grafo_matriz = new GraphMatrix(10);

    }

    class GrafoVazioCompleto {
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
            g_matriz.addArestaNaMatriz(1, 2);
            g_matriz.addArestaNaMatriz(2, 3);
            g_matriz.addArestaNaMatriz(3, 1);

            Graph g_adjacente = new Graph(3);
            g_adjacente.addAresta(1, 2);
            g_adjacente.addAresta(2, 3);
            g_adjacente.addAresta(3, 1);

            assertEquals(true, g_matriz.isCompleto());
            assertEquals(true, g_adjacente.isCompleto());
        }
    }

    class AdjacenciaDeArestasTeste{
        @Test
        public void AdjacenciaArestaTeste(){
            GraphMatrix g_matriz = new GraphMatrix(3);
            g_matriz.addArestaNaMatriz(1, 2);
            g_matriz.addArestaNaMatriz(2, 3);
            g_matriz.addArestaNaMatriz(3, 1);

            Graph g_adjacente = new Graph(3);
            g_adjacente.addAresta(1, 2);
            g_adjacente.addAresta(2, 3);
            g_adjacente.addAresta(3, 1);

            assertEquals(true, g_matriz.isArestasAdjacentes(1,2 ,2,3));
            assertEquals(true, g_adjacente.isArestasAdjacentes(1,2 ,2,3));
        }
    }

    class VerticeMatrizTeste {
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
            grafo_matriz.addArestaNaMatriz(1, 2);
            assertEquals(true, grafo_matriz.existeAdjacenciaEntreOsVertices(1, 2));
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
            grafo_matriz.ponderarAresta(1, 2, 10);
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

        @Test
        public void VerificarAdjacenciaDeVerticeNaAdjacenciaTeste() {
            grafo.addAresta(1, 2);
            assertEquals(true, grafo.existeAdjacenciaEntreOsVertices(1, 2));
        }
    }

    class ArestasAdjacenciaTest {
        @Test
        public void AdicaoDeAresta() {
            grafo.addAresta(1, 9);
            assertEquals(true, grafo.existeAdjacenciaEntreOsVertices(1, 9));
        }

        @Test
        public void remocaoDeAresta() {
            grafo.addAresta(1, 9);
            grafo.rmAresta(1, 9);
            assertEquals(false, grafo.existeAdjacenciaEntreOsVertices(1, 9));
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
            grafo.ponderarAresta(1, 9, 10);
            assertEquals(2, grafo.getAresta(1, 9).peso);
        }
    }

}
