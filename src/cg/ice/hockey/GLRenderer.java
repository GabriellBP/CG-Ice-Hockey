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
import static com.jogamp.opengl.GL2GL3.GL_VERTEX_PROGRAM_POINT_SIZE;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.Color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class GLRenderer implements GLEventListener {
    private GLU glu;
    private GL2 gl;
    private final int width, height;
    private LineStrategy lineStrategy;
    private CircleStrategy circleStrategy;
    
    private int stage;
    public JLabel status;
    private Point auxPoint;
    private ArrayList<Point> arenaPoints = new ArrayList();
    
    private int brushSize;
    private Color brushColor;
    private ArenaRenderer arenaRenderer;
    private BleachersRenderer bleachersRenderer;

    GLRenderer(GLU glu, int width, int height, int brushSize, Color brushColor, LineStrategy lineStrategy, CircleStrategy circleStrategy) {
        this.glu = glu;
        this.width = width;
        this.height = height;
        this.brushSize = brushSize;
        this.brushColor = brushColor;
        this.lineStrategy = lineStrategy;
        this.circleStrategy = circleStrategy;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("init");
        gl = drawable.getGL().getGL2();
        glu = new GLU();
        glu.gluOrtho2D(0, width, height, 0);
        
        setStage(0);
        
        arenaRenderer = new ArenaRenderer(gl, brushSize, lineStrategy, circleStrategy);
        bleachersRenderer = new BleachersRenderer(gl, brushSize, brushColor, lineStrategy);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("dispose");
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        this.gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        this.gl.glClearColor((float) (242 / 256.0), (float) (254 / 256.0), (float) (255/256.0), 1);
        
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
        if (stage == 0) {
            arenaPoints.add(new Point(x, y));
            status.setText("BR Arena");
            
            if (arenaPoints.size() == 2) {
                Point p1 = arenaPoints.get(0), p2 = arenaPoints.get(1);
                
                boolean invalid = true;
                try {
                    float ratio = (p2.y - p1.y) / (p2.x - p1.x);

                    if (!(ratio < 1 || 2.2 < ratio || p1.x > p2.x || p1.y > p2.y)) {
                        invalid = false;
                        setStage(stage + 1);
                    }
                } catch (Exception e) {
                    invalid = true;
                }
                
                if (invalid) {
                    JOptionPane.showMessageDialog(null, "Arena inválida!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    reset();
                }
            }
        } else {
            if (stage == 1) {
                this.auxPoint = new Point(x, y);
                setStage(stage + 1);
            } else {
                this.bleachersRenderer.addBleacher(auxPoint, new Point(x, y));
                setStage(stage - 1);
            }
        }
    }

    void setLineStrategy(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
        this.arenaRenderer.setLineStrategy(lineStrategy);
        bleachersRenderer.setLineStrategy(lineStrategy);
    }

    void setCircleStrategy(CircleStrategy circleStrategy) {
        this.circleStrategy = circleStrategy;
        arenaRenderer.setCircleStrategy(circleStrategy);
    }

    void setBrushSize(int value) {
        brushSize = value;
        arenaRenderer.setBrushSize(value);
        bleachersRenderer.setBrushSize(value);
    }

    void setBrushColor(Color brushColor) {
        this.brushColor = brushColor;
        bleachersRenderer.setBrushColor(brushColor);
    }
    
    private void setStage(int value) {
        stage = value;
        
        switch (stage) {
            case 0:
                status.setText("TL Arena");
                break;
            case 1:
                status.setText("P1 Bleach");
                break;
            case 2:
                this.status.setText("P2 Bleach");
                break;
        }
    }

    void reset() {
        stage = 0;
        status.setText("TL Arena");
        arenaPoints = new ArrayList();
        bleachersRenderer.reset();
    }
    
}
