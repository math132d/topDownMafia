/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.*;

/**
 *
 * @author majoh
 */
public class glShaderProgram {
    private int shaderProgramPointer;

    private int vertexShaderPointer;
    private int fragmentShaderPointer;
    

    public glShaderProgram() {
        shaderProgramPointer = glCreateProgram();
        vertexShaderPointer = glCreateShader(GL_VERTEX_SHADER);
        fragmentShaderPointer = glCreateShader(GL_FRAGMENT_SHADER);
    }
    
    public glShaderProgram(String vertexShader, String fragmentShader){
        this();
        
        attachVertexShader(vertexShader);
        attachFragmentShader(fragmentShader);
        finalizeShader();
    }

    public void attachVertexShader(String s) {
        StringBuilder source;

        try {
            source = loadShaderFile(s);

            glShaderSource(vertexShaderPointer, source);
            glCompileShader(vertexShaderPointer);
            
            if(glGetShaderi(vertexShaderPointer, GL_COMPILE_STATUS) == GL_FALSE){
                System.err.println("Failed to compile Vertex shader");
                System.err.println(glGetShaderInfoLog(vertexShaderPointer, GL_INFO_LOG_LENGTH));
            }
            
            glAttachShader(shaderProgramPointer, vertexShaderPointer);
            
        } catch (IOException e) {
            System.err.println("Failed loading the Fragment shader, is the path correct?");
        }
    }

    public void attachFragmentShader(String s) {
        StringBuilder source;

        try {
            source = loadShaderFile(s);

            glShaderSource(fragmentShaderPointer, source);
            glCompileShader(fragmentShaderPointer);
            
            if(glGetShaderi(fragmentShaderPointer, GL_COMPILE_STATUS) == GL_FALSE){
                System.err.println("Failed to compile Fragment shader");
                System.err.println(glGetShaderInfoLog(fragmentShaderPointer, GL_INFO_LOG_LENGTH));
            }
            
            glAttachShader(shaderProgramPointer, fragmentShaderPointer);
            
        } catch (IOException e) {
            System.err.println("Failed loading the Fragment shader, is the path correct?");
        }
    }
    
    public void finalizeShader(){
        
        glBindAttribLocation(shaderProgramPointer, 0, "in_Position");
        glBindAttribLocation(shaderProgramPointer, 1, "in_Color");
        
        glLinkProgram(shaderProgramPointer);
        glValidateProgram(shaderProgramPointer);
        
        if(glGetProgrami(shaderProgramPointer, GL_VALIDATE_STATUS) == GL_FALSE){
            System.err.println("Failed to validate shader program");
            System.err.println(glGetProgramInfoLog(shaderProgramPointer, glGetProgrami(shaderProgramPointer, GL_INFO_LOG_LENGTH)));
        }
    }
    
    public void bind(){
        if(glGetProgrami(shaderProgramPointer, GL_VALIDATE_STATUS) == GL_TRUE){
            glUseProgram(shaderProgramPointer);
        }else{
            throw new RuntimeException("Failed to bind shader program, it is not properly validated.");
        }
    }
    
    public void clear(){
        glUseProgram(0);
    }
    
    public void terminate(){
        glDeleteProgram(shaderProgramPointer);
        glDeleteShader(fragmentShaderPointer);
        glDeleteShader(vertexShaderPointer);
    }

    private StringBuilder loadShaderFile(String s) throws IOException {
        StringBuilder source = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
            String line;

            while ((line = reader.readLine()) != null) {
                source.append(line).append("\n");
            }
        }

        return source;
    }
}
