/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/**
 *
 * @author jorgecisneros
 */
public class Pajaro extends Ellipse2D.Double{
    Color colorPajaro;
    int yVelocidad = -2;
    Image mosca,mosca2;
    int radio;
    public Pajaro(int _radio, Color _color){
        super(100, 100, _radio, _radio);
        colorPajaro = _color;
        radio = _radio;
        precargaImagenes();
    }
    private void precargaImagenes(){
         
        mosca = (new ImageIcon(new ImageIcon(
                getClass().getResource("/imagenes/fly1.png"))
                .getImage().getScaledInstance(radio,radio, Image.SCALE_DEFAULT)))
                .getImage();
        mosca2 = (new ImageIcon(new ImageIcon(
                getClass().getResource("/imagenes/fly2.png"))
                .getImage().getScaledInstance(radio,radio, Image.SCALE_DEFAULT)))
                .getImage();
        
    }
    public void mueve(Graphics2D g2){
        this.y = this.y - yVelocidad;
        //pongo un tope para que no se salga por el techo
        if (this.y < 0) {
            this.y = 0;
            yVelocidad = -2;
        }
        if(yVelocidad <0){
        g2.drawImage(mosca, (int)this.getX(), (int)this.getY() , null);
        }
        else{
        g2.drawImage(mosca2, (int)this.getX(), (int)this.getY() , null);
        }
        yVelocidad -= 1;
        if (yVelocidad < -3){
            yVelocidad = -2;
        }
    }
    
    public boolean chequeaColision(Columna c){
        Area areaPajaro = new Area(this);
        Area areaPajaro2 = new Area(this);
        Area areaCirculo = new Area(c.circuloInferior);
        Area areaCirculo2 = new Area(c.circuloSuperior);
        boolean choca = true;
        areaPajaro.intersect(areaCirculo);
        areaPajaro2.intersect(areaCirculo2);
       
        if (areaPajaro.isEmpty()){
            choca = false;
        }
        if (areaPajaro2.isEmpty()){
            choca = false;
        }
        return (this.intersects(c.capitel) || 
                this.intersects(c.base) ||
                choca
                );
    }

}
