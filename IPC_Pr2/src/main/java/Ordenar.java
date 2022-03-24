/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferrn
 */
public class Ordenar {
    
    private int pasos;
    
    public int getPasos(){
        return pasos;
    }
    
    public void setPasos(int pasos){
        this.pasos = pasos;
    }
    
    public int[] insertionSort(int lista[], String orden) 
    { 
        int n = lista.length; 
        for (int i = 1; i < n; ++i) { 
            int key = lista[i]; 
            int j = i - 1; 
  
            /* Mover los elementos que son mayores que el que estamos comparando a una posición más a la derecha de su actual posición */
            while (j >= 0 && lista[j] > key) { 
                lista[j + 1] = lista[j]; 
                j = j - 1; 
                
                pasos++;
                
                
                imprimeArreglo(lista, orden);
            } 
            lista[j + 1] = key; 
        }
        this.setPasos(pasos);
        int[] imp = invierteArreglo(lista, orden);
        
        return imp;
    } 
    
    public int[] bubbleSort(int lista[], String orden) {
    int size = lista.length;

    // Ejecutar el bucle dos veces: uno para recorrer el Array  y otro para comparaciones
    for (int i = 0; i < size - 1; i++) {
 
      // Se genera un registro de los intercambios
      boolean swapped = true;
      for (int j = 0; j < size - i - 1; j++) {

        // Para ordenar en orden descendiente cambiar > por <
        if (lista[j] > lista[j + 1]) {
          
          // Intercambio
          int temp = lista[j];
          lista[j] = lista[j + 1];
          lista[j + 1] = temp;
          
          pasos++;
          this.setPasos(pasos);
          
          swapped = false;
          imprimeArreglo(lista, orden);
        }
      }
      
      // Si no ha habido intercambio en la última comparación, entonces el array está ya ordenado.
      if (swapped == true)
        break;
        }
    
        int[] imp = invierteArreglo(lista, orden);
        
        return imp;
    }
    
    public int[] selectionSort(int lista[], String orden) 
    {
        int n = lista.length;
        
  
        // Los límites entre el array ordenado y desordenado se va desplazando a la derecha (el algoritmo ordenado va creciendo en cada iteración)
        for (int i = 0; i < n-1; i++) 
        { 
            // Encontrar el mínimo elemento del array que todavía no está ordenado
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (lista[j] < lista[min_idx]) 
                    min_idx = j; 
            
            // Intercambiar el elemento con valor mínimo por la primera posición del array que todavia no está ordenado 
            int temp = lista[min_idx]; 
            lista[min_idx] = lista[i]; 
            lista[i] = temp;
            
            pasos++;
            this.setPasos(pasos);
            
            imprimeArreglo(lista, orden);
        }
        int[] imp = invierteArreglo(lista, orden);
        
        return imp;
    }
    
        public int[] invierteArreglo(int arreglo[], String orden){
            String imp = "";
            
            if(orden.equals("Descendente")){
                int aux;

                for (int i=0; i<arreglo.length/2; i++) {
                    aux = arreglo[i];
                    arreglo[i] = arreglo[arreglo.length-1-i];
                    arreglo[arreglo.length-1-i] = aux;
                }
            }
            return arreglo;
        }
        
        public void imprimeArreglo(int arreglo[], String orden){
            String imp = "";
            
            if(orden.equals("Ascendente")){
                for (int i = 0; i < arreglo.length; i++) {

                    if (i != arreglo.length-1)
                        imp = imp+arreglo[i]+",";
                        else
                            imp = imp+arreglo[i]+"";
                }
                System.out.println(imp);
            }
            else if(orden.equals("Descendente")){
                for (int i = (arreglo.length-1); i >=0; i--) {

                    if (i != arreglo.length)
                       imp = imp+arreglo[i]+",";
                       else
                           imp = imp+arreglo[i]+"";
                }
                System.out.println(imp);   
            }
        }
}

