package util;

import static util.glDrawables.*;

/**
 *
 * @author majoh
 */
public class Sprite {
    
    private float w, h;
    private float anchX, anchY; //[0,0] Being top left, [1,1] Being bottom right
    private Texture tex;
    
    public Sprite(Texture tex, float w, float h, float anchX, float anchY){
        this.w = w;
        this.h = h;
        
        this.anchX = anchX;
        this.anchY = anchY;
        
        this.tex = tex;
    }
    
    public Sprite(Texture tex, float w, float h){
        this(tex, w, h, 0, 0);
    }
    
    public Sprite(Texture tex){
        this(tex, tex.getWidth(), tex.getHeight());
    }

    public float getW() { return w; }

    public void setW(float w) { this.w = w; }

    public float getH() { return h; }

    public void setH(float h) { this.h = h; }
    
    public void scale(float factor){
        this.w *= factor;
        this.h *= factor;
    }
    
    public Texture getTexture(){ return tex; }
    
    public void draw(float x, float y){
        tex.bind();
        
        rect(x, y, w, h);
    }
    
    
}
