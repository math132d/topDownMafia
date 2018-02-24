/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;

/**
 *
 * @author majoh
 */
public class Texture {
    private int textureId;
    
    public Texture(File f){
        //TODO somehow load the fukin thang
    }
    
    public Texture(String f){
        this(new File(f));
    }
    
    public void bind(){
        //Somehow bond textureId
    }
    
    public int getHeight(){
        return 40;
    }
    
    public int getWidth(){
        return 40;
    }
}
