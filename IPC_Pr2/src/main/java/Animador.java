
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferrn
 */
public class Animador {
    
    private Dato[] datos;
    private JPanel panel;
    private JFreeChart barras;
    private Random rand;
    private String titulo;
    private int[] notas = {100,50,60,70,80,76};
    
    public int[] getNotas(){
        return notas;
    }
    
    public void setNotas(int[] notas){
        this.notas = notas;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public Animador(Dato[] datos, JPanel panel){
        this.datos = datos;
        this.panel = panel;
        rand = new Random();
    }
    
    public void generarGraficaAleatoria(){
        refreshChart();
        generateImage("Imagen.png");
    }
    
    private void refreshChart(){
        ChartPanel chartPanel = getChartPanel();
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel);
        panel.validate();
        System.out.println("Refrescar");
    }
    
    public ChartPanel getChartPanel(){
        barras = ChartFactory.createBarChart(this.getTitulo(), "Categorias", "Calificacion", getDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel( barras );
        return chartPanel;
    }
    
    private CategoryDataset getDataset(){
        
        Ordenar ordenar = new Ordenar();
        
        final int[] cal = this.getNotas();
        final String[] materias ={"Programación", "Estadistica", "Matematica", "Lenguaje", "Arte", "Física"};
        final String categoria = "Materia";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < notas.length; i++) {
            dataset.addValue(cal[i],materias[i],categoria);
        }
        
        return dataset;
    }
    
    private void generateImage(String nombreGrafica){
        try{
            final File file = new File(nombreGrafica);
            ChartUtils.saveChartAsPNG(file, barras, 300, 200);
        }
        catch(IOException e){
            System.out.println("Imagen no generada");
        }
    }
}
