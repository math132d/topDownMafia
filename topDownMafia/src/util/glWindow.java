package util;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

/**
 *
 * @author majoh
 */
public class glWindow {
    private static int WIDTH, HEIGHT;

    public static long window;
    
    
    public glWindow(){}
    
    private static void canvas2D(){
        GL.createCapabilities();
        
        glClearColor(0f, 0f, 0f, 1f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, -1.0, 1.0);
        glEnable(GL_TEXTURE_2D);
        
        // enable alpha blending
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }
    
    private static void initWindow(){
        GLFWErrorCallback.createPrint(System.out).set();
        
        if(!glfwInit()) throw new RuntimeException("Could not initiate GLFW");
        
        if((window = glfwCreateWindow(WIDTH, HEIGHT, "TopDownMafia", 0, 0)) == 0)
            throw new RuntimeException("Could not create GLFW window");

        
        glfwMakeContextCurrent(window);
    }
    
    public static void setWindowSize(int width, int height){
        WIDTH = width;
        HEIGHT = height;
    }
    
    public static void init(){
        
        if(WIDTH*HEIGHT == 0){
            glfwTerminate();
            throw new RuntimeException("Cannot inititate a window with 0x0 size");
        }
        
        try{
            initWindow();
            canvas2D();
        }catch(RuntimeException e){
            glfwTerminate();
            e.printStackTrace();
        }
    }
}
