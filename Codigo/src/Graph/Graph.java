package Codigo.src.Graph;

import java.util.ArrayList;
import java.util.List;

import Codigo.src.Graph.utils.StringUtils;

public class Graph {
    public int[][] matrix;
    public int n_vertices;
    public List<Vertice> vertices;

    /**
     * Construtor padrão que cria um grafo em estrutura de lista
     * de adjacencia somente com os vertices. Inicialmente 
     * sempre será um grafo totalmente disconexo pois as relações
     * e arestas NÃO são definidas por esse construtor
     * @param n_vertices
     */
    public Graph(int n_vertices) {
        this.n_vertices = n_vertices;
        this.GerarListaDeAdjacencia();
    }

    /**
     * Construtor utilizado quando a quantidade de 
     * vertices é passado pelo GraphIO. Essse construtor gera primeiro 
     * uma matriz de adjacência e depois a preenche com zeros.
     * Obrigatóriamente, após cramar esse construtor é necessário 
     * chamar o método @GerarListaDeAdjacenciaAPartirDaMatriz() 
     * para gerar uma lista de adjecencia da qual é possivel de ser manipulada.
     * A matriz de adjacencia no momento serve apenas como 
     * instermediário na leitura do grafo
     * @param isMatrix - Sempre dever ser true
     * @param n_vertices
     */
    public Graph(boolean isMatrix, int n_vertices) {
        this.n_vertices = n_vertices;
        this.matrix = new int[n_vertices][n_vertices];
        this.preencherMatrizComZeros();
    }
    
    
    /**
     * Método que gera a lista de adjacencia padrão, com somente
     * vertices e sem arestas. 
     */
    public void GerarListaDeAdjacencia(){
        List<Vertice> v = new ArrayList<>();
        for ( int i = 0 ; i < n_vertices ; i++ ){
            v.add(new Vertice(i));
        }
        this.vertices = v;
    }

     
    /**
     * Metodo que gera a lista de adjacencia a partir da martiz 
     * produzida na leitura de arquivo
     */
    public void GerarListaDeAdjacenciaAPartirDaMatriz(){
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


    /**
     * Método que preence a matriz com zeros no momento 
     * de instanciação de uma matriz 
     */
    private void preencherMatrizComZeros() {
        for (int i = 0; i < n_vertices; i++) {
            for (int j = 0; j < n_vertices; j++) {
                    this.matrix[i][j] = 0;
            }
        }
    }


    /**
     * Método que conta a quantidade de arestas na matriz 
     * de adjacencia do grafo 
     * @return n_arestas
     */
    public int getNumeroDeArestasNaMatrix(){
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


    /**
     * ToString para printar a lista de adjecencia 
     * de um jeito bem bacana 
     */
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


