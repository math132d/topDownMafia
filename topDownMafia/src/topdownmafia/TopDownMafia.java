package topdownmafia;

import util.glWindow;

public class TopDownMafia {
    private static final GameLoop GAMELOOP = new GameLoop();
    
    public static void main(String[] args) {
        glWindow.setWindowSize(1280, 720);
        glWindow.init();
        
        GAMELOOP.run();
    }
}