/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author majoh
 */
public class glDrawables {
    public static void rect(float x, float y, float w, float h, int layer){
        glBegin(GL_QUADS);
        
        
        glTexCoord3f(0, 0, layer);  //¤##
        //Corner here -->    //#0#
        glVertex2f(x, y);    //###
        
        glTexCoord3f(1, 0, layer);  //##¤
        //Corner here -->    //#0#
        glVertex2f(x+w, y);  //###
        
        glTexCoord3f(1, 1, layer);  //###
        //Corner here -->    //#0#
        glVertex2f(x+w, y+h);//##¤
        
        glTexCoord3f(0, 1, layer);  //###
        //Corner here -->    //#0#
        glVertex2f(x, y+h);  //¤##
        
        glEnd();
    }
}
