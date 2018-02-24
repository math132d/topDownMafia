package topdownmafia;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static topdownmafia.TopDownMafia.s;
import util.glWindow;

/**
 *
 * @author majoh
 */
public class GameLoop implements Runnable {
    int frameCount;
    
    @Override
    public void run() {
        while(!glfwWindowShouldClose(glWindow.window)){
            glClear(GL_COLOR_BUFFER_BIT);
            
            draw();
            tick();
            
            glfwSwapBuffers(glWindow.window);
            glfwPollEvents();
        }
        
        stop();
    }
    
    private void draw(){
        s.draw(0,0);
    }
    
    private void tick(){
        frameCount++;
    }
    
    public void stop(){
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}