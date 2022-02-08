package com.isis.estruturadados;

import java.util.Arrays;

public class Vetor {
    private String[] elementos;
    private int posicaoLivre;

    public Vetor(int capacidade) {
        elementos = new String[capacidade];
        posicaoLivre = 0;
    }

    public boolean adiciona(String elemento) {
        if (this.posicaoLivre < this.elementos.length) {
            elementos[posicaoLivre] = elemento;
            posicaoLivre++;
            return true;
        }
        return false;
    }

    public void adiciona(int posicao, String elemento) {
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

    public void remove(String elemento) {
        int posicao = busca(elemento);
        if( posicao >= 0 ){
            remove(posicao);
        }
    }

    public void aumentaCapacidade(){
        String[] novoVetor = new String[ this.elementos.length * 2];
        for ( int i = 0 ; i< this.elementos.length ; i++ ) {
            novoVetor[i] = this.elementos[i];
        }
        this.elementos = novoVetor;
    }

    public String busca(int posicao) {
        if (posicao < 0 || posicao >= elementos.length) {
            throw new IllegalArgumentException("Argumento inválido para a busca!");
        } else return this.elementos[posicao];
    }

    public int busca(String elemento) {
        for (int i=0; i<posicaoLivre; i++){
            if(elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

}
