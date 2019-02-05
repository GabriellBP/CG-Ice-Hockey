package cg.ice.hockey;

import cg.ice.hockey.strategies.circle.CircleStrategy;
import cg.ice.hockey.strategies.line.BresenhamLineStrategy;
import cg.ice.hockey.strategies.line.LineEquationStrategy;
import cg.ice.hockey.strategies.line.LineStrategy;
import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;
import static com.jogamp.opengl.GL.GL_COLOR_BUFFER_BIT;
import static com.jogamp.opengl.GL.GL_DEPTH_BUFFER_BIT;
import com.jogamp.opengl.GL2;
import static com.jogamp.opengl.GL2ES3.GL_QUADS;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import javax.swing.JLabel;

class GLRenderer implements GLEventListener {
    private GLU glu;
    private GL2 gl;
    private final int width, height;
    private LineStrategy lineStrategy;
    private CircleStrategy circleStrategy;
    public JLabel status;
    
    private int stage = 0;
    private Point auxPoint;
    private final ArrayList<Point> arenaPoints = new ArrayList();
    
    private ArenaRenderer arenaRenderer;
    private BleachersRenderer bleachersRenderer;

    GLRenderer(GLU glu, int width, int height, LineStrategy lineStrategy) {
        this.glu = glu;
        this.width = width;
        this.height = height;
        this.lineStrategy = lineStrategy;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("init");
        this.gl = drawable.getGL().getGL2();
        this.status.setText("TL Arena");
        
        glu = new GLU();
        glu.gluOrtho2D(0, width, height, 0);
        
        this.arenaRenderer = new ArenaRenderer(this.gl, this.lineStrategy);
//        this.bleachersRenderer = new BleachersRenderer(this.gl, this.lineStrategy);
        this.bleachersRenderer = new BleachersRenderer(this.gl, this.lineStrategy);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("dispose");
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        this.gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        this.gl.glClearColor(1, 1, 1, 1);
        if (stage > 0) {
            arenaRenderer.drawArena(arenaPoints.get(0), arenaPoints.get(1));
            bleachersRenderer.drawBleachrs();
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("reshape");
    }

    void onClick(int x, int y) {
        if (stage == 0) { // esperando pontos da arena
            this.arenaPoints.add(new Point(x, y));
            this.status.setText("BR Arena");
            
            if (this.arenaPoints.size() == 2) {
                stage++;
                this.status.setText("P1 Bleach");
            }
        } else {
            if (stage == 1) {
                this.auxPoint = new Point(x, y);
                stage++;
                this.status.setText("P2 Bleach");
            } else {
                this.bleachersRenderer.addBleacher(auxPoint, new Point(x, y));
                stage--;
                this.status.setText("P1 Bleach");
            }
        }
    }

    public void setLineStrategy(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
        this.arenaRenderer.setLineStrategy(lineStrategy);
        this.bleachersRenderer.setLineStrategy(lineStrategy);
    }

    public void setCircleStrategy(CircleStrategy circleStrategy) {
        this.circleStrategy = circleStrategy;
    }
    
    
}
