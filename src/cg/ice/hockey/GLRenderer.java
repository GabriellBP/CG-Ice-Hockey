package cg.ice.hockey;

import cg.ice.hockey.strategies.line.LineStrategy;
import cg.ice.hockey.util.Point;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;

class GLRenderer implements GLEventListener {
    private GLU glu;
    private GL2 gl;
    private final int width, height;
    
    private int stage = 0;
    private ArrayList<Point> arenaPoints = new ArrayList();
    
    private ArenaRenderer arenaRenderer;
    private BleachersRenderer bleachersRenderer;

    GLRenderer(GLU glu, int width, int height) {
        this.arenaRenderer = new ArenaRenderer();
        this.bleachersRenderer = new BleachersRenderer();
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
        if (stage > 0) {
            arenaRenderer.drawArena(arenaPoints.get(0), arenaPoints.get(1));
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("reshape");
    }

    void onClick(int x, int y) {
        if (stage == 0) { // esperando pontos da arena
            this.arenaPoints.add(new Point(x, y));
            
            if (this.arenaPoints.size() == 2) {
                stage++;
            }
        }
    }
}
