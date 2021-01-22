/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.listas_enlazadas;

/**
 *
 * @author cesar
 */
public class Nodo{
       private int  elem;
       private Nodo prox;

       public Nodo(){
           elem = 0;
           prox = null;
       }

       public Nodo(int x, Nodo p){
           elem = x;
           prox = p;
       }

       public void setElem(int x) {
           elem = x;
       }

       public int getElem() {
           return elem;
       }

       public void setProx(Nodo p){
           prox = p;
       }

       public Nodo getProx(){
           return prox;
       }
}