package Codigo.tests.GraphTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Codigo.src.Graph.Graph;

public class FleuryTest {
    @Test
    public void tresOuMaisVerticesDeGrauImparTest(){
        Graph g = new Graph(5);
        g.addAresta(0, 1);
        g.addAresta(0, 2);
        g.addAresta(0, 3);
        g.addAresta(1, 2);
        g.addAresta(1, 3);
        g.addAresta(2, 3);
        g.addAresta(2, 4);
        assertEquals(true, g.tresOuMaisVerticesDeGrauImpar());
    }

    @Test
    public void menosTresOuMaisVerticesDeGrauImparTest(){
        Graph g = new Graph(5);

        g.addAresta(0, 2);
        g.addAresta(0, 3);
        g.addAresta(1, 2);
        g.addAresta(1, 3);
        g.addAresta(2, 3);
        g.addAresta(2, 4);
        assertEquals(false, g.tresOuMaisVerticesDeGrauImpar());
    }
}
