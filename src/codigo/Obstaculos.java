/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author DIOS
 */
public class Obstaculos {
    
    Rectangle2D obstaculo;
    int hueco =130;
    int altura_columna = 200;
    int ancho_columna = 80;
    private int ancho_pantalla;
    Image kong;
    Rectangle2D columnaChoque;
Random aleatorio = new Random();  

    

  public Obstaculos (int _ancho, int _anchoPantalla){
       
        
      int desplazamientoMas = aleatorio.nextInt(100);
      int desplazamientoMenos= aleatorio.nextInt(100);
        obstaculo = new Rectangle2D.Double(_ancho, altura_columna + desplazamientoMas -desplazamientoMenos -50, 40, 40);
        
        ancho_pantalla = _anchoPantalla;
//        precargaImagenes();
    }
  
    public void mueve(Graphics2D g2){
        mueveColumna();
        //mueveColumna(base);
        
        g2.fill(obstaculo);
       
//        g2.drawImage(kong, (int)obstaculo.getX(), (int)obstaculo.getY(), null);
        
    }
    
    
//     private void precargaImagenes(){
//        kong = (new ImageIcon(new ImageIcon(
//                getClass().getResource("/imagenes/kingkong.png"))
//                .getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT)))
//                .getImage();         
//                
//    }
    
    
    private void mueveColumna(){
        if (obstaculo.getX() + ancho_columna < 0){
            
            int desplazamientoMas = aleatorio.nextInt(100);
      int desplazamientoMenos= aleatorio.nextInt(100);
            obstaculo.setFrame(ancho_pantalla,
                               altura_columna - desplazamientoMenos + desplazamientoMas -50, 
                               obstaculo.getWidth(), 
                               obstaculo.getHeight());
          
        }
        else{
            obstaculo.setFrame(obstaculo.getX()-5, obstaculo.getY(),obstaculo.getWidth(), obstaculo.getHeight());
        }
    }}