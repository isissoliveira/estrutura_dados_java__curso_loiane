package com.isis.estruturadados;

import com.isis.estruturadados.utils.EstruturaEstatica;


public class Pilha<T> extends EstruturaEstatica<T> {

    public Pilha() {
        super();
    }
    public Pilha(int capacidade) {
        super(capacidade);
    }

    public void empilha( T elemento) {
        this.adiciona( elemento);
    }

    public T desempilha( T elemento) {
        if(this.estaVazia()){
            return null;
        }
        return elementos[--posicaoLivre];
    }

    public T topo(){
        if(this.estaVazia()){
            return null;
        }
        return elementos[posicaoLivre-1];
    }

}
