package topdownmafia;

import util.glWindow;
import util.Sprite;
import util.Texture;

public class TopDownMafia {
    private static final GameLoop GAMELOOP = new GameLoop();
    public static Sprite s = new Sprite(new Texture("dd"));
    
    public static void main(String[] args){
        glWindow.setWindowSize(1280, 720);
        glWindow.init();
        
        GAMELOOP.run();
    }
}