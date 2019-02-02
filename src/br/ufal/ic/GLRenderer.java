package br.ufal.ic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.Random;
import javax.media.opengl.GL;
import static javax.media.opengl.GL.GL_COLOR_BUFFER_BIT;
import static javax.media.opengl.GL.GL_QUADS;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;


/**
 * GLRenderer.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class GLRenderer extends GLCanvas implements GLEventListener {

    GLU glu;
    GL gl;
    int width, height;
    Random random = new Random();
    
    GLRenderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("init");
        
        gl = drawable.getGL();
        glu = new GLU();
        glu.gluOrtho2D(0, width, 0, height);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        System.out.println("display");
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("reshape");}

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        System.out.println("display changed");
    }

    void drawCircle(float radius) {
        display();
        System.out.println("drawing circle");
        gl.glPushMatrix();
            gl.glTranslated(width / 2.0, height / 2.0, 0);
            
            gl.glBegin(gl.GL_LINES);
            for (int i = 0; i < 360; i++) {
                gl.glColor3f(139, 69, 19);
                float x = (float) (radius * cos(i));
                float y = (float) (radius * sin(i));
                gl.glVertex3f(0, 0, 0);
                gl.glVertex3f(x, y, 0);
            }
            gl.glEnd();
        gl.glPopMatrix();
        gl.glFlush();
    }

    void onSpace() {
        System.out.println("ON SPACE!");
    }

    void onClick(int x, int y) {
        drawCircle(500);
    }
}

