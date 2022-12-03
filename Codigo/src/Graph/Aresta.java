package Codigo.src.Graph;

public class Aresta {
    public int rotulo;
    public int peso;
    public int rotuloVerticeV;
    public int rotuloVerticeW;

    public Aresta(int rotulo, int peso, int rotuloVerticeV, int rotuloVerticeW) {
        this.rotulo = rotulo;
        this.peso = peso;
        this.rotuloVerticeV = rotuloVerticeV;
        this.rotuloVerticeW = rotuloVerticeW;
    }

    public Aresta(int rotulo, int rotuloVerticeV, int rotuloVerticeW) {
        this.rotulo = rotulo;
        this.peso = 1;
        this.rotuloVerticeV = rotuloVerticeV;
        this.rotuloVerticeW = rotuloVerticeW;
    }

    @Override
    public String toString() {
        String str = String.format(
                "===> Aresta\n rotulo: %d\nv: %d\nw: %d\npeso: %d",
                this.rotulo,
                this.rotuloVerticeV,
                this.rotuloVerticeW,
                this.peso);

        return str;
    }
}
