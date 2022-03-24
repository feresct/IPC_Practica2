/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferrn
 */
public class Dato{
    
    private String categoria;
    private int valor;
    
    public Dato(String categoria, int valor){
        this.categoria = categoria;
        this.valor = valor;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public long getValor(){
        return valor;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
}
