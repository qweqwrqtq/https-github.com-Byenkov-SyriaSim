package map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Map extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Map() {

		setSize(new Dimension(720, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		class Panel extends JPanel {
			private Country board;
			
			public Panel(Country board){
				this.board = board;
			}
			
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				board.paintMap(g2);
				addMouseListener(new MouseAdapter() {
		            @Override
		            public void mousePressed(MouseEvent e) {
		            	for (Province province : board.getProvinces().values()){
			                if (province.getArea().contains(e.getPoint()) && SwingUtilities.isRightMouseButton(e)) {
			                	province.empty(g2);
			                	System.out.print(province.getName() + ": " + province.getController());
			                	if(province.getController() == "USA") province.setController("ISIS");
				                else if(province.getController() == "ISIS") province.setController("Assad");
				                else if(province.getController() == "Assad") province.setController("USA");
				                System.out.print(" -> " + province.getController() + "\n");
				                Map.this.repaint();
			                } else if (province.getArea().contains(e.getPoint())) {
			                	province.empty(g2);
			                	System.out.print(province.getName() + ": " + province.getController());
			                	if(province.getController() == "USA") province.setController("Assad");
				                else if(province.getController() == "Assad") province.setController("ISIS");
				                else if(province.getController() == "ISIS") province.setController("USA");
				                System.out.print(" -> " + province.getController() + "\n");
				                Map.this.repaint();
			                }
			                	
		            	}
		            }
		        });
			}
		};
		Country syria = new Country();
		Panel panel = new Panel(syria);
		setTitle("Map");
		this.getContentPane().add(panel);
		setVisible(true);
	}
	
	public static void main(String arg[]) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new Map();
				}
			});
	}
}