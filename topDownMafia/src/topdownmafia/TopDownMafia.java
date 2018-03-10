package topdownmafia;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.glWindow;
import util.Sprite;
import util.Texture;
import util.glShaderProgram;

public class TopDownMafia {
    private static final GameLoop GAMELOOP = new GameLoop();
    public static glShaderProgram defaultShader;
    public static Sprite s;
    
    public static void main(String[] args) throws IOException{        
        glWindow.setWindowSize(1280, 720);
        glWindow.init();
        
        defaultShader = new glShaderProgram("Assets/shaders/shader.vert", "Assets/shaders/shader.frag");
        
        
        try {
            s = new Sprite(new Texture("Assets/anim.png", 2));
        } catch (IOException ex) {
            Logger.getLogger(TopDownMafia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GAMELOOP.run();
    }
}