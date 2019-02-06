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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends javax.swing.JFrame {
    private final GLCanvas canvas;
    private Animator animator;
    private GLRenderer renderer;
    public Color color = Color.BLUE;
            
    public GUI() {
        initComponents();
        
        renderer = new GLRenderer(new GLU(), jPanel1.getWidth(), jPanel1.getHeight(), densitySlider.getValue(), color, getCurrentLineStrategy(), getCurrentCircleStrategy());
        renderer.status = lblStatus;
        btnColorPick.setBackground(color);
        
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
                System.out.printf("Clicou em x=%d, y=%d\n", e.getX(), e.getY());
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
        
        densitySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateRenderer();
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
        btnReset = new javax.swing.JButton();
        cboxGlobalThickness = new javax.swing.JCheckBox();
        lblDensity1 = new javax.swing.JLabel();
        cboxGlobalColor = new javax.swing.JCheckBox();

        bgrpAlgorithm.add(btnBresenham);
        bgrpAlgorithm.add(btnLineEq);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ice Hockey");
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));
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
            .addGap(0, 730, Short.MAX_VALUE)
        );

        btnBresenham.setText("Bresenham");
        btnBresenham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBresenhamActionPerformed(evt);
            }
        });

        btnLineEq.setSelected(true);
        btnLineEq.setText("Line / Circumference equation");
        btnLineEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineEqActionPerformed(evt);
            }
        });

        lblAlgorithm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAlgorithm.setText("Tipo de algoritmo");

        densitySlider.setMaximum(20);
        densitySlider.setMinimum(1);
        densitySlider.setValue(1);

        lblDensity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDensity.setText("Espessura");

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

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(0, 14, 2, 14));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cboxGlobalThickness.setText("Global");
        cboxGlobalThickness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxGlobalThicknessActionPerformed(evt);
            }
        });

        lblDensity1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDensity1.setText("Cor");

        cboxGlobalColor.setText("Global");
        cboxGlobalColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxGlobalColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLineEq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBresenham))
                    .addComponent(lblAlgorithm))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(densitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDensity)
                        .addGap(18, 18, 18)
                        .addComponent(cboxGlobalThickness)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblDensity1)
                        .addGap(18, 18, 18)
                        .addComponent(cboxGlobalColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnColorPick)
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatusHeader)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnReset)
                .addContainerGap(201, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAlgorithm, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDensity)
                                    .addComponent(cboxGlobalThickness, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBresenham)
                                        .addComponent(btnLineEq))
                                    .addComponent(densitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnColorPick)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDensity1)
                            .addComponent(cboxGlobalColor, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblStatusHeader)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblStatus)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBresenham, btnLineEq});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnColorPickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorPickActionPerformed
        Color newColor = javax.swing.JColorChooser.showDialog(GUI.this, "Selecione uma cor", Color.lightGray);
        if (newColor != null) {
            color = newColor;
            btnColorPick.setBackground(color);
        }
        updateRenderer();
    }//GEN-LAST:event_btnColorPickActionPerformed

    private void btnLineEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineEqActionPerformed
        System.out.println("changed algorithm to Line Eq");
        updateRenderer();
    }//GEN-LAST:event_btnLineEqActionPerformed

    private void btnBresenhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBresenhamActionPerformed
        System.out.println("changed algorithm to Bresenham");
        updateRenderer();
    }//GEN-LAST:event_btnBresenhamActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        renderer.reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void cboxGlobalThicknessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxGlobalThicknessActionPerformed
        updateRenderer();
    }//GEN-LAST:event_cboxGlobalThicknessActionPerformed

    private void cboxGlobalColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxGlobalColorActionPerformed
        updateRenderer();
    }//GEN-LAST:event_cboxGlobalColorActionPerformed

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
    private javax.swing.JButton btnReset;
    private javax.swing.JCheckBox cboxGlobalColor;
    private javax.swing.JCheckBox cboxGlobalThickness;
    private javax.swing.JSlider densitySlider;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAlgorithm;
    private javax.swing.JLabel lblDensity;
    private javax.swing.JLabel lblDensity1;
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
        renderer.setBrushSize(densitySlider.getValue());
        renderer.setBrushColor(color);
        renderer.setGlobalBrushSize(cboxGlobalThickness.isSelected());
        renderer.setGlobalBrushColor(cboxGlobalColor.isSelected());
    }
}
