/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;

public class Nodo{
    private Empleado elem;
    private Nodo prox;

    public Nodo(){
        elem = new Empleado();
        prox = null;
    }

    public Nodo(Empleado x, Nodo p){
        elem = x;
        prox = p;
    }

    public void setElem(Empleado x) {
        elem = x;
    }
    
    public Empleado getElem() {
        return elem;
    }

    public void setProx(Nodo p){
        prox = p;
    }

    public Nodo getProx(){
        return prox;
    }
}