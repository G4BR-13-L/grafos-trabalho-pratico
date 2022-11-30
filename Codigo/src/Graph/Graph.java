package Codigo.src.Graph;

import java.util.ArrayList;
import java.util.List;

import Codigo.src.Graph.utils.StringUtils;

public class Graph {
    public int[][] matrix;
    public int n_vertices;
    public List<Vertice> vertices;

    public Graph(int n_vertices) {
        this.n_vertices = n_vertices;
        this.matrix = new int[n_vertices][n_vertices];
        this.preencherComZeros();
    }
    
    public void GerarListaDeAdjacencia(){
        List<Vertice> v = new ArrayList<>();
        for ( int i = 0 ; i < n_vertices ; i++ ){
            v.add(new Vertice(i));
        }

        for( int i = 0 ; i < n_vertices ; i++ ){
            for( int j = 0 ; j < n_vertices ; j++ ){
                if( this.matrix[i][j] == 1 ){
                    v.get(i).addAresta(v.get(j));
                }
            }
        }

        this.vertices = v;
    }

    private void preencherComZeros() {
        for (int i = 0; i < n_vertices; i++) {
            for (int j = 0; j < n_vertices; j++) {
                    this.matrix[i][j] = 0;
            }
        }
    }

    public int getNumeroDeArestas(){
        int n_arestas = 0;
        for( int i = 0; i < this.n_vertices ; i++ ){
            for( int j = 0; j < this.n_vertices ; j++ ){
                if( this.matrix[i][j] > 0 ){
                    n_arestas++;
                }
            }   
        }
        return n_arestas;
    }

    @Override
    public String toString(){

        String headerFormat = "|%1$-10s|%2$-10s\n";
        String lineFormat = "|%1$-10s|%2$s\n";
        
        String str = String.format(headerFormat, StringUtils.center("Vertices", 10), StringUtils.center("Arestas",10));

        for ( int i = 0 ; i < vertices.size() ; i++ ){
            str += String.format(lineFormat, StringUtils.center(this.vertices.get(i).rotulo+"", 10), this.vertices.get(i).arestasToString());
        }
        return str;
    }
}


