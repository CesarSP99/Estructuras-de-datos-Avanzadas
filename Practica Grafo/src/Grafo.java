import java.util.HashMap;
import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Grafo {

    private Lista LVertices;
    private final float inf;
            
    public Grafo() {
        this.inf = 99999;
        LVertices = new Lista();
    }

    public void crearVertice(String nomV) {
        LVertices.insertarUlt(new Vertice(nomV));
    }

    public Vertice buscarVertice(String nomV) {
        Vertice vertice;
        int i = 0;
        while (i < LVertices.dim()) {
            vertice = (Vertice) LVertices.getElem(i);
            if (vertice.getNombre().equals(nomV)) {
                return vertice;
            }
            i++;
        }
        return null;
    }

    public void insertarArco(String X, String Y, float co) {
        Vertice vo = buscarVertice(X);
        Vertice vd = buscarVertice(Y);
        vo.insertarArco(new Arco(vd, co));
    }

    public void imprimir(JTextArea jta) {
        int i = 0;
        Vertice v;
        Arco a;
        while (i < LVertices.dim()) {
            v = (Vertice) LVertices.getElem(i);
            int j = 0;
            while (j < v.LArcos.dim()) {
                jta.append(v.getNombre());
                jta.append("-->");
                a = (Arco) v.LArcos.getElem(j); //Muestra el arco donde apunto
                jta.append(a.getNombreVertD() + "  " + a.getCosto());
                jta.append("\n");
                j++;
            }
            i++;
        }
    }

    //METODOS DE ENSEÑANZA    
    public float peso() {
        int i = 0;
        Vertice v;
        float s = 0;
        while (i < LVertices.dim()) {
            v = (Vertice) LVertices.getElem(i);
            int j = 0;
            Arco a;
            while (j < v.LArcos.dim()) {
                a = (Arco) v.LArcos.getElem(j);
                s = s + a.getCosto();
                j++;
            }
            i++;
        }
        return s;
    }

    public void desmarcarTodos() {
        for (int i = 0; i < this.LVertices.dim(); i++) {
            Vertice v = (Vertice) this.LVertices.getElem(i);
            v.marcado = false;
        }
    }

    public void ordenarVerticesAlf() {
        Vertice aux;
        Vertice v1;
        Vertice v2;
        for (int i = 0; i < LVertices.dim(); i++) {
            for (int j = 0; j < LVertices.dim() - 1; j++) {
                v1 = (Vertice) LVertices.getElem(j);
                v2 = (Vertice) LVertices.getElem(j + 1);
                if (v1.getNombre().compareTo(v2.getNombre()) > 0) {
                    aux = (Vertice) LVertices.getElem(j);
                    LVertices.setElem(v2, j);
                    LVertices.setElem(aux, j + 1);
                }
            }
        }
        for (int i = 0; i < LVertices.dim(); i++) {
            Vertice v = (Vertice) LVertices.getElem(i);
            v.ordenarArcosAlf();
        }
    }

    public void DFS(String A, JTextArea jta) {
        jta.append("DFS: ");
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice v = buscarVertice(A);
        dfs(v, jta);
        jta.append("\n");
    }

    private void dfs(Vertice v, JTextArea jta) {
        jta.append(v.getNombre() + " ");
        v.marcado = true;
        Arco a;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            a = (Arco) v.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
            if (!w.marcado) {
                dfs(w, jta);
            }
        }
    }

    public void BFS(String s, JTextArea jta) {
        desmarcarTodos();
        ordenarVerticesAlf();
        Arco a;
        Vertice v = buscarVertice(s), w;
        LinkedList<Vertice> C;
        C = new LinkedList<Vertice>();
        C.add(v);
        v.marcado = true;
        jta.append("BFS: ");
        do {
            v = C.pop();
            jta.append(v.getNombre() + " ");
            for (int i = 0; i < v.LArcos.dim(); i++) {
                a = (Arco) v.LArcos.getElem(i);
                w = buscarVertice(a.getNombreVertD());
                if (!w.marcado) {
                    C.add(w);
                    w.marcado = true;
                }
            }
        } while (!C.isEmpty());
        jta.append("\n");
    }

    public boolean existeCamino(String X, String Y) {
        if (buscarVertice(X) != null && buscarVertice(Y) != null) {
            desmarcarTodos();
            Vertice v = buscarVertice(X);
            return existeCamino(v, Y);
        }
        return false;
    }

    private boolean existeCamino(Vertice v, String Y) {
        v.marcado = true;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            Arco a = (Arco) v.LArcos.getElem(i);
            Vertice v2 = buscarVertice(a.getNombreVertD());
            if (!v2.marcado) { //sino esta marcado (marcado==false)
                if (v2.getNombre().equals(Y)) {
                    return true;
                } else if (existeCamino(v2, Y)) {
                    return true;
                }
            } else if (v2.getNombre().equals(Y)) //Cuando se quiera a traves de otros vertices llegar al mismo vertice o del mismo al mismo
            {
                return true;
            }
        }
        return false;
    }

    public int cantidadCaminos(Vertice v, String y) {
        int i = 0, c = 0;
        v.marcado = true;
        while (i < v.LArcos.dim()) {
            Arco a = (Arco) v.LArcos.getElem(i);
            Vertice v2 = buscarVertice(a.getNombreVertD());
            if (!v2.marcado) {
                if (v2.getNombre().equals(y)) {
                    c++;
                } else {
                    c = c + cantidadCaminos(v2, y);
                    v2.marcado = false;
                }
            }
            i++;
        }
        return c;
    }

    public boolean sonIguales(Grafo b) {
        //Compruebo si tienen la misma cantidad de nodos para recien iterar
        if (this.LVertices.dim() != b.LVertices.dim()) {
            return false;
        }

        //Ordenar alfabeticamente todos los nodos
        this.ordenarVerticesAlf();
        b.ordenarVerticesAlf();

        //Compruebo primero los nombres de nodos y que tengan la misma cantidad de aristas
        for (int i = 0; i < this.LVertices.dim(); i++) {
            Vertice v1, v2;
            v1 = (Vertice) this.LVertices.getElem(i);
            v2 = (Vertice) b.LVertices.getElem(i);
            if (v1.LArcos.dim() != v2.LArcos.dim() || (v1.nombre == null ? v2.nombre != null : !v1.nombre.equals(v2.nombre))) {
                return false;
            }
        }

        //Luego compruebo los aristas para cada vertice, comprobando si los nodos destinos son iguales
        for (int i = 0; i < this.LVertices.dim(); i++) {
            Vertice v1, v2;
            v1 = (Vertice) this.LVertices.getElem(i);
            v2 = (Vertice) b.LVertices.getElem(i);
            for (int j = 0; j < v1.LArcos.dim(); j++) {
                Arco a1, a2;
                a1 = (Arco) v1.LArcos.getElem(j);
                a2 = (Arco) v2.LArcos.getElem(j);
                if (a1.getCosto() != a2.getCosto() || (a1.getNombreVertD() == null ? a2.getNombreVertD() != null : !a1.getNombreVertD().equals(a2.getNombreVertD()))) {
                    return false;
                }
            }
        }

        //Al final si pasa todas las pruebas, son iguales
        return true;
    }

    public boolean existeMasDeUnCamino(String x, String y) {
        Vertice v = buscarVertice(x);
        if (v != null && cantidadCaminos(v, y) > 1) {
            return true;
        }
        return false;
    }

    public boolean existeCaminoBFS(String origen, String destino) {
        if (buscarVertice(origen) != null && buscarVertice(destino) != null) {
            //BFS(origen, new JTextArea());
            desmarcarTodos();
            ordenarVerticesAlf();
            Arco a;
            Vertice v = buscarVertice(origen), w;
            LinkedList<Vertice> C;
            C = new LinkedList<Vertice>();
            C.add(v);
            v.marcado = true;
            do {
                v = C.pop();
                for (int i = 0; i < v.LArcos.dim(); i++) {
                    a = (Arco) v.LArcos.getElem(i);
                    w = buscarVertice(a.getNombreVertD());
                    if (!w.marcado) {
                        C.add(w);
                        w.marcado = true;
                    }
                }
            } while (!C.isEmpty());
        }
        return buscarVertice(destino).marcado;
    }

    public boolean existeMasDeUnCaminoBFS(String x, String y) {
        if (buscarVertice(x) != null && cantidadCaminosBFS(x, y) > 1) {
            return true;
        }
        return false;
    }

    public int cantidadCaminosBFS(String origen, String destino) {
        int caminos = 0;
        if (buscarVertice(origen) != null && buscarVertice(destino) != null) {
            desmarcarTodos();
            ordenarVerticesAlf();
            Arco a;
            Vertice v = buscarVertice(origen), w;
            LinkedList<Vertice> C;
            C = new LinkedList<Vertice>();
            C.add(v);
            v.marcado = true;
            do {
                v = C.pop();
                for (int i = 0; i < v.LArcos.dim(); i++) {
                    a = (Arco) v.LArcos.getElem(i);
                    w = buscarVertice(a.getNombreVertD());
                    if (w.getNombre().equals(destino)) {
                        caminos++;
                    }
                    if (!w.marcado) {
                        C.add(w);
                        w.marcado = true;
                    }
                }
            } while (!C.isEmpty());
        }
        return caminos;
    }

    public boolean esArbolBinario(String s) {
        Vertice vo = buscarVertice(s);
        vo.marcado = true;
        if (vo.LArcos.dim() <= 2) {
            for (int i = 0; i < vo.LArcos.dim(); i++) {
                Arco a = (Arco) vo.LArcos.getElem(i);
                Vertice vd = buscarVertice(a.getNombreVertD());
                if (vd.marcado) {
                    if (!esArbolBinario(a.getNombreVertD())) {
                        return false;
                    }
                } 
                else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean esListaEnlazada(String s) {
        Vertice vo = buscarVertice(s);
        vo.marcado = true;
        if (vo.LArcos.dim() <= 1) {
            for (int i = 0; i < vo.LArcos.dim(); i++) {
                Arco a = (Arco) vo.LArcos.getElem(i);
                Vertice vd = buscarVertice(a.getNombreVertD());
                if (vd.marcado) {
                    if (!esListaEnlazada(a.getNombreVertD())) {
                        return false;
                    }
                } 
                else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    Map<Vertice, Float> dijkstra(Vertice origen){
        Map<Vertice, Float> dist = new TreeMap<Vertice, Float>();
        Map<Vertice, String> ruta = new TreeMap<Vertice, String>();
        PriorityQueue<Arco> pq = new PriorityQueue<Arco>(new ArcoComparator());
        Arco aux1, aux2;
        desmarcarTodos();
        ordenarVerticesAlf();
        llenarConInfinito(dist);
        //Insertando a la cola el origen con distancia 0 con ayuda de un nuevo arco auxiliar
        pq.add(new Arco(origen, 0));
        dist.put(origen, 0f);
        ruta.put(origen, origen.nombre);
        while(!pq.isEmpty()){
            aux1 = pq.poll();
            Vertice v = buscarVertice(aux1.getNombreVertD());
            for(int i = 0; i < v.LArcos.dim(); i++){
                aux2 = (Arco)v.LArcos.getElem(i);
                //Comprobando la distancia acumulada con la distancia almacenada y actualizando si fuese necesario
                if(aux1.getCosto() + aux2.getCosto() < dist.get(buscarVertice(aux2.getNombreVertD()))){
                    float distanciaNueva = aux1.getCosto() + aux2.getCosto();
                    dist.put(buscarVertice(aux2.getNombreVertD()),distanciaNueva);
                    pq.add(new Arco(buscarVertice(aux2.getNombreVertD()),distanciaNueva));
                    ruta.put(buscarVertice(aux2.getNombreVertD()), ruta.get(v) + " " + aux2.getNombreVertD());
                }
            }
        }
        return dist;
    }
    
    void llenarConInfinito(Map<Vertice, Float> mapa){
        for(int i = 0; i < LVertices.dim(); i++){
            mapa.put((Vertice)LVertices.getElem(i), inf);
        }
    }
    
}  //end class
