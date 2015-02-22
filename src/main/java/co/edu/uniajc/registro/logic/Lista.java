/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniajc.registro.logic;

/**
 *
 * @author estudiante101
 */
public class Lista<T> {
    private Nodo<T> cabeza;
    private int count;

    public Lista() {
        this.cabeza = null;
        this.count = 0;
    }

    public Lista(Nodo<T> cabeza) throws Exception {
        agregar(cabeza);
    }
    
    public void agregar(Nodo<T> nodo) throws Exception {
        if(nodo.getRegistro()!=null){
            nodo.setSiguiente(this.cabeza);
            this.cabeza = nodo;
            this.count++;
        }else{
            throw new Exception("Error");
        }
    }
    
    public void desplegar(){
        Nodo<T> actual = cabeza;
        do{
            System.out.println("<" + actual.getRegistro().toString() + ">");
            if(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }else{
                break;
            }
        }while(true);
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
    
    private static class Nodo<T> {
        private T registro;
        private Nodo<T> siguiente;
        
        public Nodo() {
            this.registro = null;
            this.siguiente = null;
        }

        public Nodo(T registro) {
            this.registro = registro;
            this.siguiente = null;
        }

        /**
         * @return the registro
         */
        public T getRegistro() {
            return registro;
        }

        /**
         * @param registro the registro to set
         */
        public void setRegistro(T registro) {
            this.registro = registro;
        }

        /**
         * @return the siguiente
         */
        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        /**
         * @param siguiente the siguiente to set
         */
        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Lista<String> miLista = new Lista<>();
        miLista.agregar(new Nodo("a0"));
        miLista.agregar(new Nodo("a1"));
        miLista.agregar(new Nodo("a2"));
        miLista.agregar(new Nodo("a3"));
        miLista.agregar(new Nodo("a4"));
        System.out.println("Tamaño: " + miLista.count);
        miLista.desplegar();
        miLista.desplegar();
    }
}