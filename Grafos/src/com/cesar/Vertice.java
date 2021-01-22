/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar;

/**
 *
 * @author cesarsp
 */
public class Vertice {

    String nombre;
    public Lista LArcos;

    public Vertice(String nom) {
        this.nombre = nom;
        this.LArcos = new Lista();
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCantArcos() {
        return LArcos.dim();
    }

    public void insertarArco(Arco arco) {
        LArcos.insertarUlt(arco); //Inserta el arco q ya viene creado
    }
}
