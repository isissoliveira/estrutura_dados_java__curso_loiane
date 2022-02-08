package com.isis.estruturadados;

import java.lang.reflect.Array;

public class Lista<T> {
    private T[] elementos;
    private int posicaoLivre;

    // Construtor da nossa Lista genérica criado utilizando REFLECTION
    public Lista( int capacidade, Class<T> tipoClasse ) {
        elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
        posicaoLivre = 0;
    }

    // Construtor da nossa Lista genérica de forma mais elegante
    public Lista(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        posicaoLivre = 0;
    }

    public boolean adiciona(T elemento) {
        if (this.posicaoLivre < this.elementos.length) {
            elementos[posicaoLivre] = elemento;
            posicaoLivre++;
            return true;
        }
        return false;
    }

    public void adiciona(int posicao, T elemento) {
        if (posicao < 0 || posicao >= elementos.length) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        for (int i = posicaoLivre-1; i>=posicao; i--){
            elementos[i+1] = elementos[i];
        }
        elementos[posicao] = elemento;
        posicaoLivre++;
    }

    public void remove(int posicao) {
        if (posicao < 0 || posicao >= elementos.length) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        for (int i = posicao; i<posicaoLivre-1; i++){
            elementos[i] = elementos[i+1];
        }
        elementos[posicaoLivre-1] = null;
        posicaoLivre--;
    }

    public void remove(T elemento) {
        int posicao = busca(elemento);
        if( posicao >= 0 ){
            remove(posicao);
        }
    }

    public void aumentaCapacidade(){
        T[] novoVetor = (T[])new Object[ this.elementos.length * 2];
        for ( int i = 0 ; i< this.elementos.length ; i++ ) {
            novoVetor[i] =  this.elementos[i];
        }
        this.elementos = novoVetor;
    }

    public T busca(int posicao) {
        if (posicao < 0 || posicao >= elementos.length) {
            throw new IllegalArgumentException("Argumento inválido para a busca!");
        } else return this.elementos[posicao];
    }

    public int busca(T elemento) {
        for (int i=0; i<posicaoLivre; i++){
            if(elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public boolean contem( T elemento){
        return busca( elemento) > -1;
    }

    public T obtem( int indice){
        return busca( indice);
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
