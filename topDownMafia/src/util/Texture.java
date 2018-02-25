/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static org.lwjgl.opengl.GL11.*;
import de.matthiasmann.twl.utils.PNGDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author majoh
 */
public class Texture implements Cloneable {
    private int textureId;
    private int width, height;
    
    public Texture(File file) throws IOException{
        ByteBuffer buf;
        try (FileInputStream i = new FileInputStream(file)) {
            PNGDecoder decode = new PNGDecoder(i);
            
            height = decode.getHeight();
            width = decode.getWidth();
            
            buf = ByteBuffer.allocateDirect(height * width * 4);
            decode.decode(buf, width*4, PNGDecoder.Format.RGBA);
            buf.flip();
            
            i.close();
        }
        
        textureId = glGenTextures();
        
        glBindTexture(GL_TEXTURE_2D, textureId);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glDisable(GL_TEXTURE_2D);
    }
    
    public Texture(String f)throws IOException{
        this(new File(f));
    }
    
    public static void disableTextures(){
        glDisable(GL_TEXTURE_2D);
    }
    
    public void bind(){
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, textureId);
    }
    
    public void releaseTexture(){
        glDeleteTextures(textureId);
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getWidth(){
        return this.width;
    }
}
