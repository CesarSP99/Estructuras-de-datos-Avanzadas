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

public class Arco {

    private float costo;
    private Vertice verticeD;

    public Arco(Vertice vd, float co) {
        this.costo = co;
        this.verticeD = vd;
    }

    public void setCosto(float co) {
        this.costo = co;
    }

    public float getCosto() {
        return costo;
    }

    public String getNombreVertD() {
        return verticeD.getNombre(); //Devuelve el nombre del vertice destino
    }

    public void setNombreVertD(Vertice vd) {
        this.verticeD = vd;
    }
}
