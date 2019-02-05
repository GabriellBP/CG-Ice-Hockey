package cg.ice.hockey;

import cg.ice.hockey.strategies.circle.BresenhamCircleStrategy;
import cg.ice.hockey.strategies.circle.CircleStrategy;
import cg.ice.hockey.strategies.circle.CircumferenceEquationStrategy;
import cg.ice.hockey.strategies.line.BresenhamLineStrategy;
import cg.ice.hockey.strategies.line.LineEquationStrategy;
import cg.ice.hockey.strategies.line.LineStrategy;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends javax.swing.JFrame {
    private final GLCanvas canvas;
    private Animator animator;
    private GLRenderer renderer;
    public Color color;
            
    public GUI() {
        initComponents();
        
        renderer = new GLRenderer(new GLU(), jPanel1.getWidth(), jPanel1.getHeight(), getCurrentLineStrategy(), getCurrentCircleStrategy());
        renderer.status = lblStatus;
        
        canvas = new GLCanvas();
        canvas.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        jPanel1.add(canvas);
        canvas.addGLEventListener(renderer);
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                updateRenderer();
                
                renderer.onClick(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        animator = new Animator(canvas);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        
        animator.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrpAlgorithm = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnBresenham = new javax.swing.JRadioButton();
        btnLineEq = new javax.swing.JRadioButton();
        lblAlgorithm = new javax.swing.JLabel();
        densitySlider = new javax.swing.JSlider();
        lblDensity = new javax.swing.JLabel();
        btnColorPick = new javax.swing.JButton();
        lblStatusHeader = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        bgrpAlgorithm.add(btnBresenham);
        bgrpAlgorithm.add(btnLineEq);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ice Hockey");
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 530));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 530));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 530));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        btnBresenham.setText("Bresenham");
        btnBresenham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBresenhamActionPerformed(evt);
            }
        });

        btnLineEq.setSelected(true);
        btnLineEq.setText("Line equation");
        btnLineEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineEqActionPerformed(evt);
            }
        });

        lblAlgorithm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAlgorithm.setText("Tipo de algoritmo:");

        densitySlider.setMinimum(1);
        densitySlider.setValue(1);

        lblDensity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDensity.setText("Espessura:");

        btnColorPick.setText("Paleta de Cores");
        btnColorPick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorPickActionPerformed(evt);
            }
        });

        lblStatusHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStatusHeader.setText("Status");

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblStatus.setText("Aguardando");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLineEq)
                        .addGap(18, 18, 18)
                        .addComponent(btnBresenham))
                    .addComponent(lblAlgorithm))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDensity)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(densitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnColorPick)))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatusHeader)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(204, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAlgorithm, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDensity)
                        .addComponent(lblStatusHeader)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBresenham)
                            .addComponent(btnLineEq))
                        .addComponent(densitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnColorPick)
                        .addComponent(lblStatus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBresenham, btnLineEq});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnColorPickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorPickActionPerformed
        this.color = javax.swing.JColorChooser.showDialog(GUI.this, "Selecione uma cor", Color.lightGray);
        if (this.color == null) {
            this.color = Color.lightGray;
        }
    }//GEN-LAST:event_btnColorPickActionPerformed

    private void btnLineEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineEqActionPerformed
        System.out.println("changed algorithm to Line Eq");
        updateRenderer();
    }//GEN-LAST:event_btnLineEqActionPerformed

    private void btnBresenhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBresenhamActionPerformed
        System.out.println("changed algorithm to Bresenham");
        updateRenderer();
    }//GEN-LAST:event_btnBresenhamActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrpAlgorithm;
    private javax.swing.JRadioButton btnBresenham;
    private javax.swing.JButton btnColorPick;
    private javax.swing.JRadioButton btnLineEq;
    private javax.swing.JSlider densitySlider;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAlgorithm;
    private javax.swing.JLabel lblDensity;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusHeader;
    // End of variables declaration//GEN-END:variables

    private LineStrategy getCurrentLineStrategy() {
        return btnLineEq.isSelected() ? new LineEquationStrategy() : new BresenhamLineStrategy();
    }
    
    private CircleStrategy getCurrentCircleStrategy() {
        return btnLineEq.isSelected() ? new CircumferenceEquationStrategy() : new BresenhamCircleStrategy();
    }

    private void updateRenderer() {
        renderer.setLineStrategy(getCurrentLineStrategy());
        renderer.setCircleStrategy(getCurrentCircleStrategy());
    }
}
