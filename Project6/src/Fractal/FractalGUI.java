package Fractal;

// From TutorialsPoint:  https://www.tutorialspoint.com/swing/swing_jmenubar_control.htm
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * GUI class for making the settings GUI for fractal generation
 * @author evankoh
 * @version csc143
 */
public class FractalGUI extends JFrame {

	private static final long serialVersionUID = -7250473974520993288L;
	private Toolkit toolkit;
    private JPanel picker1, picker2;
    private Color cactusColor = Color.GREEN;
    private Color pearColor = Color.PINK;
    private int depth;
    private int ratio;
    
    /**
     * creates the Swing GUI for setting up the fractal
     */
    public FractalGUI() {
        setSize(400, 425);
        toolkit = getToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        JFrame drawFrame = new JFrame();
        drawFrame.setSize(800, 800);
        drawFrame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); 
        setLocation((screenSize.width - getWidth())/2, (screenSize.height - getHeight())/2);
        setTitle("Fractal GUI settings");

        setResizable(false);
        ImageIcon open = new ImageIcon(getClass().getResource("color.png"));
        JToolBar toolbar1 = new JToolBar();
        JToolBar toolbar2 = new JToolBar();
        JButton openb1 = new JButton(open);
        JButton openb2 = new JButton(open);
        openb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JColorChooser clr = new JColorChooser();
                Color color = clr.showDialog(panel, "Choose Color",
                        Color.white);
                cactusColor = color;
                picker1.setBackground(color);
            }
        });
        openb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JColorChooser clr = new JColorChooser();
                Color color = clr.showDialog(panel, "Choose Color",
                        Color.white);
                pearColor = color;
                picker2.setBackground(color);
            }
        });
        toolbar1.add(openb1);
        picker1 = new JPanel();
        picker1.setBackground(Color.GREEN);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        toolbar2.add(openb2);
        picker2 = new JPanel();
        picker2.setBackground(Color.PINK);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        JLabel lab1 = new JLabel("Project 6: Fractal GUI");
        JLabel lab2 = new JLabel("evan kohout ••• csc143 - spr 2018");
        JLabel lab3 = new JLabel("cactus color");
        JLabel lab4 = new JLabel("pear color");


        lab1.setFont(new Font("Serif", Font.BOLD, 36));

        JSlider slider1 = new JSlider(JSlider.HORIZONTAL, 2, 10, 2);
        JSlider slider2 = new JSlider(JSlider.HORIZONTAL, 40, 70, 40);

        JButton drawButton = new JButton("Draw!");
        
        slider1.setMajorTickSpacing(1);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setSnapToTicks(true);
        slider1.setLabelTable(slider1.createStandardLabels(1));
        depth = slider1.getValue();
        JLabel lab5 =  new JLabel("Recursion Depth: " + String.valueOf(depth));
        
        slider2.setMinorTickSpacing(1);
        slider2.setMajorTickSpacing(5);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setSnapToTicks(true);

        slider2.setLabelTable(slider2.createStandardLabels(10));
        ratio = slider2.getValue();
        JLabel lab6 = new JLabel("Ratio of Child to Parent Radius: " + ratio + "%");

        panel.add(lab1);
        panel.add(lab2);
        panel.add(createHorizontalSeparator());
        panel.add(lab3);
        panel.add(picker1);
        panel.add(toolbar1);
        panel.add(createHorizontalSeparator());
        panel.add(lab4);
        panel.add(picker2);
        panel.add(toolbar2);
        panel.add(createHorizontalSeparator());
        panel.add(lab5);
        panel.add(slider1);

        panel.add(createHorizontalSeparator());
        panel.add(lab6);
        panel.add(slider2);
        panel.add(drawButton);
        
        getContentPane().add(panel);
        slider1.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				depth = ((JSlider)e.getSource()).getValue();
				lab5.setText("Recursion Depth: " + String.valueOf(depth));
			}});
        slider2.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				ratio = ((JSlider)e.getSource()).getValue();
				lab6.setText("Ratio of Child to Parent Radius: " + ratio + "%");
			}});
        drawButton.addChangeListener(new ChangeListener(){

 			@Override
 			public void stateChanged(ChangeEvent e) {
 				FractalGen newGen = new FractalGen(depth, ratio, cactusColor, pearColor, drawFrame);
 			}});
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /*
     * Private helper for making seperators
     */
    private JComponent createHorizontalSeparator() {
        JSeparator x = new JSeparator(SwingConstants.HORIZONTAL);
        x.setPreferredSize(new Dimension(300,5));
        return x;
    }
}