package cg.ice.hockey;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

class GLRenderer implements GLEventListener {
    private GLU glu;
    private GL2 gl;
    private int width, height;
    private boolean ready = false;

    GLRenderer(GLU glu, int width, int height) {
        this.glu = glu;
        this.width = width;
        this.height = height;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("init");
        this.gl = drawable.getGL().getGL2();
        
        glu = new GLU();
        glu.gluOrtho2D(0, width, height, 0);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("dispose");
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        System.out.println("display");
        if (ready)
            drawCircle(20, width / 2, height / 2);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("reshape");
    }

    void onClick(int x, int y) {
        ready = true;
    }
    
    void drawCircle(float radius, float x, float y) {
        System.out.println("drawing circle");
        gl.glPushMatrix();
            gl.glTranslated(x, y, 0);
            
            gl.glBegin(gl.GL_LINES);
            for (int i = 0; i < 360; i++) {
                gl.glColor3f(139, 69, 19);
                x = (float) (radius * cos(i));
                y = (float) (radius * sin(i));
                gl.glVertex3f(0, 0, 0);
                gl.glVertex3f(x, y, 0);
            }
            gl.glEnd();
        gl.glPopMatrix();
        gl.glFlush();
}
}
