/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.de.matrices;

public class Nodo{
    private Matriz elem;
    private Nodo prox;

    public Nodo(){
        elem = new Matriz();
        prox = null;
    }

    public Nodo(Matriz x, Nodo p){
        elem = x;
        prox = p;
    }

    public void setElem(Matriz x) {
        elem = x;
    }
    
    public Matriz getElem() {
        return elem;
    }

    public void setProx(Nodo p){
        prox = p;
    }

    public Nodo getProx(){
        return prox;
    }
}