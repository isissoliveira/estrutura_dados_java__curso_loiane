package com.isis.estruturadados.utils;

import java.lang.reflect.Array;

public class EstruturaEstatica<T> {
    protected T[] elementos;
    protected int posicaoLivre;

    // Construtor da nossa Lista genérica de forma mais elegante
    protected EstruturaEstatica(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        posicaoLivre = 0;
    }

    protected EstruturaEstatica() {
        this(10);
    }

    protected boolean adiciona(T elemento) {
        aumentaCapacidade();
        if (this.posicaoLivre < this.elementos.length) {
            elementos[posicaoLivre] = elemento;
            posicaoLivre++;
            return true;
        }
        return false;
    }

    protected void adiciona(int posicao, T elemento) {
        if (posicao < 0 || posicao >= elementos.length) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        for (int i = posicaoLivre-1; i>=posicao; i--){
            elementos[i+1] = elementos[i];
        }
        elementos[posicao] = elemento;
        posicaoLivre++;
    }

    private void aumentaCapacidade(){
        if( posicaoLivre == elementos.length){
            T[] novoVetor = (T[])new Object[ this.elementos.length * 2];
            for ( int i = 0 ; i< this.elementos.length ; i++ ) {
                novoVetor[i] =  this.elementos[i];
            }
            this.elementos = novoVetor;
        }
    }

    public boolean estaVazia(){
        return posicaoLivre==0;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i=0; i<this.elementos.length; i++){
            if(elementos[i] != null ){
                s.append(elementos[i] + ",");
            }

        }
        s.deleteCharAt(s.length()-1);
        s.append("]");
        return s.toString();
    }
}
