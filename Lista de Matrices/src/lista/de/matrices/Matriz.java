package lista.de.matrices;

public class Matriz {
    private int[][] matriz;
    private int n; //Filas
    private int m; //Columnas
    public Matriz(){
        matriz = new int[100][100];
    }
    public int getYX(int y, int x){
        return matriz[y][x];
    }
    public void setYX(int y, int x, int valor){
        matriz[y][x] = valor;
    }
    public void setN(int y){
        n = y;
    }
    public int getN(){
        return n;
    }
    public void setM(int x){
        m = x;
    }
    public int getM(){
        return m;
    }
}
