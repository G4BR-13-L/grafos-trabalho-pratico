package Codigo.src.Graph;

public class Graph {
    public int[][] matrix;
    public int n_vertices;
    public Tabela tabela;

    public Graph(int n_vertices) {
        this.matrix = new int[n_vertices][n_vertices];
        this.n_vertices = n_vertices;
        tabela = new Tabela(n_vertices);
        this.preencherComZeros();
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
    public String toString() {
        String graphStrMatrix = "";
        for (int i = 0; i < n_vertices; i++) {
            graphStrMatrix += i + " ";
            for (int j = 0; j < n_vertices; j++) {
                graphStrMatrix += String.format("| %-6d ", this.matrix[i][j]);
            }
            graphStrMatrix += "\n";
        }
        return graphStrMatrix;
    }
}
