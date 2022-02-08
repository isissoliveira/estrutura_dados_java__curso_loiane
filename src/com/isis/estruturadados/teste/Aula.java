package com.isis.estruturadados.teste;

import com.isis.estruturadados.Lista;
import com.isis.estruturadados.Pilha;
import com.isis.estruturadados.Vetor;
import com.isis.estruturadados.VetorObjetos;

import java.util.ArrayList;
import java.util.Stack;

// INDICAÇÃO DE LIVRO:  EFFECTIVE JAVA
public class Aula {

    public static void main(String[] args) {
        testaVetor();
        testaVetorObjetos();
        testaLista();
        testaArraylist();
        testesExercicios();
        testaPilha();
        testaStack();
    }

    static private void testaVetor(){
        Vetor v = new Vetor(3);

        v.adiciona("elemento0");
        v.adiciona("elemento1");
        v.adiciona("elemento2");
        try {
            System.out.println(v.busca(3));
        }catch( Exception e ){
            System.out.println( "Oh Oh, Vetor!");
        }
    }

    static private void testaVetorObjetos(){
        VetorObjetos v = new VetorObjetos(3);

        v.adiciona("elemento0");
        v.adiciona("elemento1");
        v.adiciona("elemento2");
        try {
            System.out.println(v.busca(3));
        }catch( Exception e ){
            System.out.println( "Oh Oh, Vetor Objeto!");
        }
    }

    static private void testaLista(){
        Lista<String> v = new Lista<String>(3);

        v.adiciona("elemento0");
        v.adiciona("elemento1");
        v.adiciona("elemento2");
        try {
            System.out.println(v.busca(3));
        }catch( Exception e ){
            System.out.println( "Oh Oh, Lista!");
        }
    }

    static private void testaArraylist(){
        ArrayList<String> v = new ArrayList<String>(3);

        v.add("elemento0");
        v.add("elemento1");
        v.add("elemento2");
        try {
            System.out.println(v.get(3));
        }catch( Exception e ){
            System.out.println( "Oh Oh, ArrayList!");
        }
    }

    static private void testesExercicios(){
        Lista<String> v = new Lista<String>(3);

        v.adiciona("elemento0");
        v.adiciona("elemento1");
        v.adiciona("elemento2");

        System.out.println( v.contem("elemento1"));
        System.out.println(v.contem("elemento3"));
        System.out.println(v.obtem(0));

        System.out.println(v);
        v.remove("elemento1");
        System.out.println(v);

   }

    static private void testaPilha(){
        Pilha<Integer> p = new Pilha<Integer>();

        p.empilha(1);
        p.empilha(2);
        System.out.println(p);

    }

    static private void testaStack(){  //PILHA
        Stack<Integer> s = new Stack<Integer>();

        s.push(1);
        s.push(2);
        System.out.println(s);
        s.pop();
        System.out.println(s);
    }



}
