package Codigo.src.Graph;

public class Tabela {

    public int[] TD;
    public int[] TT;
    public int[] pai;
    public boolean isCompleta;
    public int n_vertices;

    public Tabela(int vertices) {
        this.TD = new int[vertices];
        this.TT = new int[vertices];
        this.pai = new int[vertices];
        this.isCompleta = false;
        this.n_vertices = vertices;
        this.zerarTabela(vertices);
    }

    public void zerarTabela(int vertices) {
        for (int i = 0; i < vertices; i++) {
            TD[i] = 0;
            TT[i] = 0;
            pai[i] = 0;
        }
    }

    public boolean aindaHaVerticesParaExplorar(){

        for ( int i  = 0 ; i < this.TD.length ; i++ ){
            if( this.TD[i] == 0 ){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String str = "";
        for( int i = 0 ; i < this.n_vertices ; i++ ){
            str+=String.format(" %-3d |", this.TD[i]);
        }
        return str;
    }

}
