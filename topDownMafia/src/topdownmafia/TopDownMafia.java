package topdownmafia;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.glWindow;
import util.Sprite;
import util.Texture;

public class TopDownMafia {
    private static final GameLoop GAMELOOP = new GameLoop();
    public static Sprite s;
    
    public static void main(String[] args) throws IOException{        
        glWindow.setWindowSize(1280, 720);
        glWindow.init();
        
        try {
            s = new Sprite(new Texture("D:\\Mathias\\Documents\\NetBeansProjects\\topDownMafia\\topDownMafia\\Assets\\blank.png"), 20, 20);
        } catch (IOException ex) {
            Logger.getLogger(TopDownMafia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GAMELOOP.run();
    }
}