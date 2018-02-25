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
    public static void rect(float x, float y, float w, float h, float frame){
        glBegin(GL_QUADS);
        
        
        glTexCoord2f(0, 0);  //¤##
        //Corner here -->    //#0#
        glVertex2f(x, y);    //###
        
        glTexCoord2f(1, 0);  //##¤
        //Corner here -->    //#0#
        glVertex2f(x+w, y);  //###
        
        glTexCoord2f(1, 1);  //###
        //Corner here -->    //#0#
        glVertex2f(x+w, y+h);//##¤
        
        glTexCoord2f(0, 1);  //###
        //Corner here -->    //#0#
        glVertex2f(x, y+h);  //¤##
        
        glEnd();
    }
}
