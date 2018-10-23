import javax.swing.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;
import java.util.logging.*;
import java.util.Arrays;
class Titrus implements KeyListener {
	JPanel a, panel;
	JButton b;
	ArrayList<Block> blocks;
	class FullScreenFrame extends JFrame {
            FullScreenFrame () {
        	    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	            if(gd.isFullScreenSupported()) {
                	    setUndecorated(true);
         	    	    gd.setFullScreenWindow(this);
               	    }
            }
	}
	JFrame frame;
	int downs = 0;
	Titrus() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(520, 740);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		a = new JPanel();
		a.setLayout(null);
		a.setSize(width, height);
		a.setLocation(0, 0);
		b = new JButton("Quit");
		b.setSize(60, 40);
		b.setLocation(100, 580);
		panel.setLocation(width/2 - 520/2, height/2 - 740/2);
		frame = new FullScreenFrame();
		frame.setLayout(null);
		b.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				System.exit(-1);
			}
		});
		a.add(panel);
		frame.add(a);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.show();
		frame.addKeyListener(this);
		frame.setTitle("Titrus");
		play();
	}
	void bg() {
		ImageIcon ic;
		ic = new ImageIcon(getClass().getClassLoader().getResource("bg.png"));
		Image img;
		img = ic.getImage();
		Graphics g;
		g = panel.getGraphics();
		g.drawImage(img, 0, 0, 500, 700, null);
	}
	void play() {
		try {
			Thread.sleep(1);
		} catch(Exception e) {}
		Graphics g = a.getGraphics();
		ImageIcon ic = new ImageIcon(getClass().getClassLoader().getResource("background.png"));
		Image image = ic.getImage();
		g.drawImage(image, 0, 0, a.getWidth(), a.getHeight(), null);
		JPanel c = new JPanel();
		c.setLayout(null);
		c.setSize(60, 40);
		c.setLocation(100, 580);
		b.setLocation(0, 0);
		c.add(b);
		a.add(c);
		c.repaint();
		this.blocks = new ArrayList<Block>();
		Block block1, block2, block3, block4; 
		block1 = null;
		block2 = null;
		block3 = null;
		block4 = null;
		do {
			if(block1 != null && block2 != null && block3 != null && block4 != null && (block1.get("y") == 50 || block2.get("y") == 50 || block3.get("y") == 50 || block4.get("y") == 50) && blocksAreStacked()) {
				play();
			}
			if((block1 == null && block2 == null && block3 == null && block4 == null) || blocksAreStacked() || (block1.get("y") >= 610 || block2.get("y") >= 610 || block3.get("y") >= 610 || block4.get("y") >= 610)) {
				java.util.Random rndm = new java.util.Random();
				int tVal = rndm.nextInt(7) + 1;
				if(tVal == 1) {
					block1 = new Block();
					block1.set("x", 0+100+50+50);
					block1.set("y", 100-100);
					block1.setInfo("pointing", "up");
					block1.setInfo("type", "line");
					block2 = new Block();
					block2.set("x", 0+100+50+50);
					block2.set("y", 150-100);
					block2.setInfo("pointing", "up");
					block2.setInfo("type", "line");
					block3 = new Block();
					block3.set("x", 0+100+50+50);
					block3.set("y", 200-100);
					block3.setInfo("pointing", "up");
					block3.setInfo("type", "line");
					block4 = new Block();
					block4.set("x", 0+100+50+50);
					block4.set("y", 250-100);
					block4.setInfo("pointing", "up");
					block4.setInfo("type", "line");
				} else if(tVal == 2) {
					block1 = new Block();
					block1.set("x", 0+100+100);
					block1.set("y", 100-100);
					block2 = new Block();
					block2.set("x", 50+100+100);
					block2.set("y", 100-100);
					block3 = new Block();
					block3.set("x", 0+100+100);
					block3.set("y", 150-100);
					block4 = new Block();
					block4.set("x", 50+100+100);
					block4.set("y", 150-100);
				} else if(tVal == 3) {
					block1 = new Block();
					block1.set("x", 50+100+100);
					block1.set("y", 100-100);
					block1.setInfo("pointing", "up");
					block1.setInfo("type", "hat");
					block2 = new Block();
					block2.set("x", 0+100+100);
					block2.set("y", 150-100);
					block2.setInfo("pointing", "up");
					block2.setInfo("type", "hat");
					block3 = new Block();
					block3.set("x", 50+100+100);
					block3.set("y", 150-100);
					block3.setInfo("pointing", "up");
					block3.setInfo("type", "hat");
					block4 = new Block();
					block4.set("x", 100+100+100);
					block4.set("y", 150-100);
					block4.setInfo("pointing", "up");
					block4.setInfo("type", "hat");
				} else if(tVal == 4) {
					block1 = new Block();
					block1.set("x", 50+100+100);
					block1.set("y", 100-100);
					block1.setInfo("pointing", "up");
					block1.setInfo("type", "ls");
					block2 = new Block();
					block2.set("x", 0+100+100);
					block2.set("y", 150-100);
					block2.setInfo("pointing", "up");
					block2.setInfo("type", "ls");
					block3 = new Block();
					block3.set("x", 50+100+100);
					block3.set("y", 150-100);
					block3.setInfo("pointing", "up");
					block3.setInfo("type", "ls");
					block4 = new Block();
					block4.set("x", 0+100+100);
					block4.set("y", 200-100);
					block4.setInfo("pointing", "up");
					block4.setInfo("type", "ls");
				} else if(tVal == 5) {
					block1 = new Block();
					block1.set("x", 0+100+100);
					block1.set("y", 100-100);
					block1.setInfo("pointing", "up");
					block1.setInfo("type", "ra");
					block2 = new Block();
					block2.set("x", 0+100+100);
					block2.set("y", 150-100);
					block2.setInfo("pointing", "up");
					block2.setInfo("type", "ra");
					block3 = new Block();
					block3.set("x", 0+100+100);
					block3.set("y", 200-100);
					block3.setInfo("pointing", "up");
					block3.setInfo("type", "ra");
					block4 = new Block();
					block4.set("x", 50+100+100);
					block4.set("y", 200-100);
					block4.setInfo("pointing", "up");
					block4.setInfo("type", "ra");
				} else if(tVal == 6) {
					block1 = new Block();
					block1.set("x", 50+100+100);
					block1.set("y", 100-100);
					block1.setInfo("pointing", "up");
					block1.setInfo("type", "la");
					block2 = new Block();
					block2.set("x", 50+100+100);
					block2.set("y", 150-100);
					block2.setInfo("pointing", "up");
					block2.setInfo("type", "la");
					block3 = new Block();
					block3.set("x", 0+100+100);
					block3.set("y", 200-100);
					block3.setInfo("pointing", "up");
					block3.setInfo("type", "la");
					block4 = new Block();
					block4.set("x", 50+100+100);
					block4.set("y", 200-100);
					block4.setInfo("pointing", "up");
					block4.setInfo("type", "la");
				} else if(tVal == 7) {
					block1 = new Block();
					block1.set("x", 0+100+100);
					block1.set("y", 100-100);
					block1.setInfo("pointing", "up");
					block1.setInfo("type", "rs");
					block2 = new Block();
					block2.set("x", 0+100+100);
					block2.set("y", 150-100);
					block2.setInfo("pointing", "up");
					block2.setInfo("type", "rs");
					block3 = new Block();
					block3.set("x", 50+100+100);
					block3.set("y", 150-100);
					block3.setInfo("pointing", "up");
					block3.setInfo("type", "rs");
					block4 = new Block();
					block4.set("x", 50+100+100);
					block4.set("y", 200-100);
					block4.setInfo("pointing", "up");
					block4.setInfo("type", "rs");
				}
				blocks.add(block1);
				blocks.add(block2);
				blocks.add(block3);
				blocks.add(block4);
			}
			bg();
			downs();
			clearCompleteLine();
			draw();
			try {
				Thread.sleep(1000);
			} catch(Exception ex) {}
		} while( true);
	}
	void clearCompleteLine() {
		ArrayList clearBlocks = new ArrayList();
		for(int line=0; line<=13; line++) {
			int clearThisLine = 0;
			for(int i=0; i<blocks.size(); i++) {
				int x = blocks.get(i).get("x");
				int y = blocks.get(i).get("y");
				int theline = line * 50;
				if(y == theline) {
					clearThisLine++;
				}
			}
			if(clearThisLine == 10) {
				clearThisLine = 0;
				clearBlocks.add(""+line);
			}
		}
		for(int i=0; i<clearBlocks.size(); i++) {
			for(int j=0; j<blocks.size(); j++) {
				if(blocks.get(j).get("y")/50 == Integer.parseInt((String)clearBlocks.get(i))) {
					blocks.get(j).set("y", 1000);
				} else if(blocks.get(j).get("y")/50 < Integer.parseInt((String)clearBlocks.get(i))) {
					blocks.get(j).set("y", blocks.get(j).get("y") + 50);
				}
			}
		}			
	}	
	void draw() {
		Graphics g;
		g = this.panel.getGraphics();
		ImageIcon ico;
		ico = new ImageIcon(getClass().getClassLoader().getResource("block.png"));
		Image imge;
		imge = ico.getImage();
		for(int ndex = 0; ndex < blocks.size(); ndex++) {
			g.drawImage(imge, blocks.get(ndex).get("x"), blocks.get(ndex).get("y"), 50, 50, null);
		}
	}
	void rotateBlocks() {
		Block bl1 = blocks.get(blocks.size()-4);
		Block bl2 = blocks.get(blocks.size()-3);
		Block bl3 = blocks.get(blocks.size()-2);
		Block bl4 = blocks.get(blocks.size()-1);
		if(bl1.getInfo("type").equals("line") &&
			bl2.getInfo("type").equals("line") &&
			bl3.getInfo("type").equals("line") &&
			bl4.getInfo("type").equals("line")) {
			if(bl1.getInfo("pointing").equals("up") &&
				bl2.getInfo("pointing").equals("up") &&
				bl3.getInfo("pointing").equals("up") &&
				bl4.getInfo("pointing").equals("up")) {
				bl1.setInfo("pointing", "right");
				bl2.setInfo("pointing", "right");
				bl3.setInfo("pointing", "right");
				bl4.setInfo("pointing", "right");
				bl1.set("x", bl1.get("x") + 150);
				bl1.set("y", bl1.get("y") + 150);
				bl2.set("x", bl2.get("x") + 100);
				bl2.set("y", bl2.get("y") + 100);
				bl3.set("x", bl3.get("x") + 50);
				bl3.set("y", bl3.get("y") + 50);
				if(bl1.get("x") > 450 || bl2.get("x") > 450 || bl3.get("x") > 450 || bl4.get("x") > 450) {
					bl1.set("x", bl1.get("x") - 150);
					bl1.set("y", bl1.get("y") - 150); 
					bl2.set("x", bl2.get("x") - 100);
					bl2.set("y", bl2.get("y") - 100); 
					bl3.set("x", bl3.get("x") - 50);
					bl3.set("y", bl3.get("y") - 50);
				}
			} else if(bl1.getInfo("pointing").equals("right") &&
				bl2.getInfo("pointing").equals("right") &&
				bl3.getInfo("pointing").equals("right") &&
				bl4.getInfo("pointing").equals("right")) {
				bl1.setInfo("pointing", "down");
				bl2.setInfo("pointing", "down");
				bl3.setInfo("pointing", "down");
				bl4.setInfo("pointing", "down");
				bl1.set("x", bl1.get("x") - 150);
				bl1.set("y", bl1.get("y") + 150);
				bl2.set("x", bl2.get("x") - 100);
				bl2.set("y", bl2.get("y") + 100);
				bl3.set("x", bl3.get("x") - 50);
				bl3.set("y", bl3.get("y") + 50);
			} else if(bl1.getInfo("pointing").equals("down") &&
				bl2.getInfo("pointing").equals("down") &&
				bl3.getInfo("pointing").equals("down") &&
				bl4.getInfo("pointing").equals("down")) {
				bl1.setInfo("pointing", "left");
				bl2.setInfo("pointing", "left");
				bl3.setInfo("pointing", "left");
				bl4.setInfo("pointing", "left");
				bl1.set("x", bl1.get("x") - 150);
				bl1.set("y", bl1.get("y") - 150);
				bl2.set("x", bl2.get("x") - 100);
				bl2.set("y", bl2.get("y") - 100);
				bl3.set("x", bl3.get("x") - 50);
				bl3.set("y", bl3.get("y") - 50);
				if(bl1.get("x") < 0 || bl2.get("x") < 0 || bl3.get("x") < 0 || bl4.get("x") < 0) {
					bl1.set("x", bl1.get("x") + 150);
					bl1.set("y", bl1.get("y") + 150); 
					bl2.set("x", bl2.get("x") + 100);
					bl2.set("y", bl2.get("y") + 100); 
					bl3.set("x", bl3.get("x") + 50);
					bl3.set("y", bl3.get("y") + 50);
				}
			} else if(bl1.getInfo("pointing").equals("left") &&
				bl2.getInfo("pointing").equals("left") &&
				bl3.getInfo("pointing").equals("left") &&
				bl4.getInfo("pointing").equals("left")) {
				bl1.setInfo("pointing", "up");
				bl2.setInfo("pointing", "up");
				bl3.setInfo("pointing", "up");
				bl4.setInfo("pointing", "up");
				bl1.set("x", bl1.get("x") + 150);
				bl1.set("y", bl1.get("y") - 150);
				bl2.set("x", bl2.get("x") + 100);
				bl2.set("y", bl2.get("y") - 100);
				bl3.set("x", bl3.get("x") + 50);
				bl3.set("y", bl3.get("y") - 50);
			}
		} else if(bl1.getInfo("type").equals("hat") &&
			bl2.getInfo("type").equals("hat") &&
			bl3.getInfo("type").equals("hat") &&
			bl4.getInfo("type").equals("hat")) {
			if(bl1.getInfo("pointing").equals("up") &&
				bl2.getInfo("pointing").equals("up") &&
				bl3.getInfo("pointing").equals("up") &&
				bl4.getInfo("pointing").equals("up")) {
				bl1.setInfo("pointing", "right");
				bl2.setInfo("pointing", "right");
				bl3.setInfo("pointing", "right");
				bl4.setInfo("pointing", "right");
				bl2.set("y", bl2.get("y") - 100);
				bl3.set("x", bl3.get("x") - 50);
				bl3.set("y", bl3.get("y") - 50);
				bl4.set("x", bl4.get("x") - 100);
			} else if(bl1.getInfo("pointing").equals("right") &&
				bl2.getInfo("pointing").equals("right") &&
				bl3.getInfo("pointing").equals("right") &&
				bl4.getInfo("pointing").equals("right")) {
				bl1.setInfo("pointing", "down");
				bl2.setInfo("pointing", "down");
				bl3.setInfo("pointing", "down");
				bl4.setInfo("pointing", "down");
				bl2.set("x", bl2.get("x") + 100);
				bl3.set("x", bl3.get("x") + 50);
				bl3.set("y", bl3.get("y") - 50);
				bl4.set("y", bl4.get("y") - 100);
				if(bl1.get("x") > 450 || bl2.get("x") > 450 || bl3.get("x") > 450 || bl4.get("x") > 450) {
					bl2.set("x", bl2.get("x") - 100);
					bl3.set("x", bl3.get("x") - 50);
					bl3.set("y", bl3.get("y") + 50);
					bl4.set("y", bl4.get("y") + 100);
				}
			} else if(bl1.getInfo("pointing").equals("down") &&
				bl2.getInfo("pointing").equals("down") &&
				bl3.getInfo("pointing").equals("down") &&
				bl4.getInfo("pointing").equals("down")) {
				bl1.setInfo("pointing", "left");
				bl2.setInfo("pointing", "left");
				bl3.setInfo("pointing", "left");
				bl4.setInfo("pointing", "left");
				bl2.set("y", bl2.get("y") + 100);
				bl3.set("x", bl3.get("x") + 50);
				bl3.set("y", bl3.get("y") + 50);
				bl4.set("x", bl4.get("x") + 100);
			} else if(bl1.getInfo("pointing").equals("left") &&
				bl2.getInfo("pointing").equals("left") &&
				bl3.getInfo("pointing").equals("left") &&
				bl4.getInfo("pointing").equals("left")) {
				bl1.setInfo("pointing", "up");
				bl2.setInfo("pointing", "up");
				bl3.setInfo("pointing", "up");
				bl4.setInfo("pointing", "up");
				bl2.set("x", bl2.get("x") - 100);
				bl3.set("x", bl3.get("x") - 50);
				bl3.set("y", bl3.get("y") + 50);
				bl4.set("y", bl4.get("y") + 100);
			}
		} else if(bl1.getInfo("type").equals("ls") &&
			bl2.getInfo("type").equals("ls") &&
			bl3.getInfo("type").equals("ls") &&
			bl4.getInfo("type").equals("ls")) {
			if(bl1.getInfo("pointing").equals("up") &&
				bl2.getInfo("pointing").equals("up") &&
				bl3.getInfo("pointing").equals("up") &&
				bl4.getInfo("pointing").equals("up")) {
				bl1.setInfo("pointing", "right");
				bl2.setInfo("pointing", "right");
				bl3.setInfo("pointing", "right");
				bl4.setInfo("pointing", "right");
				bl3.set("x", bl3.get("x") - 50);
				bl3.set("y", bl3.get("y") - 50);
				bl2.set("y", bl2.get("y") - 100);
				bl4.set("x", bl4.get("x") - 50);
				bl4.set("y", bl4.get("y") - 150);
				if(bl1.get("x") < 0 || bl2.get("x") < 0 || bl3.get("x") < 0 || bl4.get("x") < 0) {
					bl3.set("x", bl3.get("x") + 50);
					bl3.set("y", bl3.get("y") + 50);
					bl2.set("y", bl2.get("y") + 100);
					bl4.set("x", bl4.get("x") + 50);
					bl4.set("y", bl4.get("y") + 150);
				}
			} else if(bl1.getInfo("pointing").equals("right") &&
				bl2.getInfo("pointing").equals("right") &&
				bl3.getInfo("pointing").equals("right") &&
				bl4.getInfo("pointing").equals("right")) {
				bl1.setInfo("pointing", "down");
				bl2.setInfo("pointing", "down");
				bl3.setInfo("pointing", "down");
				bl4.setInfo("pointing", "down");
				bl3.set("x", bl3.get("x") + 50);
				bl3.set("y", bl3.get("y") - 50);
				bl2.set("x", bl2.get("x") + 100);
				bl4.set("x", bl4.get("x") + 150);
				bl4.set("y", bl4.get("y") - 50);
				if(bl1.get("x") > 450 || bl2.get("x") > 450 || bl3.get("x") > 450 || bl4.get("x") > 450) {
					bl3.set("x", bl3.get("x") - 50);
					bl3.set("y", bl3.get("y") + 50);
					bl2.set("y", bl2.get("y") - 100);
					bl4.set("x", bl4.get("x") - 150);
					bl4.set("y", bl4.get("y") + 50);
				}
			} else if(bl1.getInfo("pointing").equals("down") &&
				bl2.getInfo("pointing").equals("down") &&
				bl3.getInfo("pointing").equals("down") &&
				bl4.getInfo("pointing").equals("down")) {
				bl1.setInfo("pointing", "left");
				bl2.setInfo("pointing", "left");
				bl3.setInfo("pointing", "left");
				bl4.setInfo("pointing", "left");
				bl3.set("x", bl3.get("x") + 50);
				bl3.set("y", bl3.get("y") + 50);
				bl2.set("y", bl2.get("y") + 100);
				bl4.set("x", bl4.get("x") + 50);
				bl4.set("y", bl4.get("y") + 150);
				if(bl1.get("x") > 450 || bl2.get("x") > 450 || bl3.get("x") > 450 || bl4.get("x") > 450) {
					bl3.set("x", bl3.get("x") - 50);
					bl3.set("y", bl3.get("y") - 50);
					bl2.set("y", bl2.get("y") - 100);
					bl4.set("x", bl4.get("x") - 50);
					bl4.set("y", bl4.get("y") - 150);
				}
			} else if(bl1.getInfo("pointing").equals("left") &&
				bl2.getInfo("pointing").equals("left") &&
				bl3.getInfo("pointing").equals("left") &&
				bl4.getInfo("pointing").equals("left")) {
				bl1.setInfo("pointing", "up");
				bl2.setInfo("pointing", "up");
				bl3.setInfo("pointing", "up");
				bl4.setInfo("pointing", "up");
				bl3.set("x", bl3.get("x") - 50);
				bl3.set("y", bl3.get("y") + 50);
				bl2.set("x", bl2.get("x") - 100);
				bl4.set("x", bl4.get("x") - 150);
				bl4.set("y", bl4.get("y") + 50);
			}
		} else if(bl1.getInfo("type").equals("rs") &&
			bl2.getInfo("type").equals("rs") &&
			bl3.getInfo("type").equals("rs") &&
			bl4.getInfo("type").equals("rs")) {
			if(bl1.getInfo("pointing").equals("up") &&
				bl2.getInfo("pointing").equals("up") &&
				bl3.getInfo("pointing").equals("up") &&
				bl4.getInfo("pointing").equals("up")) {
				bl1.setInfo("pointing", "right");
				bl2.setInfo("pointing", "right");
				bl3.setInfo("pointing", "right");
				bl4.setInfo("pointing", "right");
				bl2.set("x", bl2.get("x") - 50);
				bl2.set("y", bl2.get("y") - 50);
				bl3.set("x", bl3.get("x") - 100);
				bl4.set("x", bl4.get("x") - 150);
				bl4.set("y", bl4.get("y") - 50);
				if(bl1.get("x") < 0 || bl2.get("x") < 0 || bl3.get("x") < 0 || bl4.get("x") < 0) {
					bl3.set("x", bl2.get("x") + 50);
					bl3.set("y", bl2.get("y") + 50);
					bl2.set("y", bl3.get("y") + 100);
					bl4.set("x", bl4.get("x") + 150);
					bl4.set("y", bl4.get("y") + 50);
				}
			} else if(bl1.getInfo("pointing").equals("right") &&
				bl2.getInfo("pointing").equals("right") &&
				bl3.getInfo("pointing").equals("right") &&
				bl4.getInfo("pointing").equals("right")) {
				bl1.setInfo("pointing", "down");
				bl2.setInfo("pointing", "down");
				bl3.setInfo("pointing", "down");
				bl4.setInfo("pointing", "down");
				bl2.set("x", bl2.get("x") + 50);
				bl2.set("y", bl2.get("y") - 50);
				bl3.set("y", bl3.get("y") - 100);
				bl4.set("x", bl4.get("x") + 50);
				bl4.set("y", bl4.get("y") - 150);
			} else if(bl1.getInfo("pointing").equals("down") &&
				bl2.getInfo("pointing").equals("down") &&
				bl3.getInfo("pointing").equals("down") &&
				bl4.getInfo("pointing").equals("down")) {
				bl1.setInfo("pointing", "left");
				bl2.setInfo("pointing", "left");
				bl3.setInfo("pointing", "left");
				bl4.setInfo("pointing", "left");
				bl2.set("x", bl2.get("x") + 50);
				bl2.set("y", bl2.get("y") + 50);
				bl3.set("x", bl3.get("x") + 100);
				bl4.set("x", bl4.get("x") + 150);
				bl4.set("y", bl4.get("y") + 50);
				if(bl1.get("x") > 450 || bl2.get("x") > 450 || bl3.get("x") > 450 || bl4.get("x") > 450) {
					bl2.set("x", bl2.get("x") - 50);
					bl2.set("y", bl2.get("y") - 50);
					bl3.set("y", bl3.get("y") - 100);
					bl4.set("x", bl4.get("x") - 150);
					bl4.set("y", bl4.get("y") - 50);
				}
			} else if(bl1.getInfo("pointing").equals("left") &&
				bl2.getInfo("pointing").equals("left") &&
				bl3.getInfo("pointing").equals("left") &&
				bl4.getInfo("pointing").equals("left")) {
				bl1.setInfo("pointing", "up");
				bl2.setInfo("pointing", "up");
				bl3.setInfo("pointing", "up");
				bl4.setInfo("pointing", "up");
				bl2.set("x", bl2.get("x") - 50);
				bl2.set("y", bl2.get("y") + 50);
				bl3.set("y", bl3.get("y") + 100);
				bl4.set("x", bl4.get("x") - 50);
				bl4.set("y", bl4.get("y") + 150);
			}
		} else if(bl1.getInfo("type").equals("ra") &&
			bl2.getInfo("type").equals("ra") &&
			bl3.getInfo("type").equals("ra") &&
			bl4.getInfo("type").equals("ra")) {
			if(bl1.getInfo("pointing").equals("up") &&
				bl2.getInfo("pointing").equals("up") &&
				bl3.getInfo("pointing").equals("up") &&
				bl4.getInfo("pointing").equals("up")) {
				bl1.setInfo("pointing", "right");
				bl2.setInfo("pointing", "right");
				bl3.setInfo("pointing", "right");
				bl4.setInfo("pointing", "right");
				bl2.set("x", bl2.get("x") - 50);
				bl2.set("y", bl2.get("y") - 50);
				bl3.set("x", bl3.get("x") - 100);
				bl3.set("y", bl3.get("y") - 100);
				bl4.set("x", bl4.get("x") - 150);
				bl4.set("y", bl4.get("y") - 50);
				if(bl1.get("x") < 0 || bl2.get("x") < 0 || bl3.get("x") < 0 || bl4.get("x") < 0) {
					bl2.set("x", bl2.get("x") + 50);
					bl2.set("y", bl2.get("y") + 50);
					bl3.set("y", bl3.get("y") + 100);
					bl3.set("y", bl3.get("y") + 100);
					bl4.set("x", bl4.get("x") + 150);
					bl4.set("y", bl4.get("y") + 50);
				}
			} else if(bl1.getInfo("pointing").equals("right") &&
				bl2.getInfo("pointing").equals("right") &&
				bl3.getInfo("pointing").equals("right") &&
				bl4.getInfo("pointing").equals("right")) {
				bl1.setInfo("pointing", "down");
				bl2.setInfo("pointing", "down");
				bl3.setInfo("pointing", "down");
				bl4.setInfo("pointing", "down");
				bl2.set("x", bl2.get("x") + 50);
				bl2.set("y", bl2.get("y") - 50);
				bl3.set("x", bl3.get("x") + 100);
				bl3.set("y", bl3.get("y") - 100);
				bl4.set("x", bl4.get("x") + 50);
				bl4.set("y", bl4.get("y") - 150);
			} else if(bl1.getInfo("pointing").equals("down") &&
				bl2.getInfo("pointing").equals("down") &&
				bl3.getInfo("pointing").equals("down") &&
				bl4.getInfo("pointing").equals("down")) {
				bl1.setInfo("pointing", "left");
				bl2.setInfo("pointing", "left");
				bl3.setInfo("pointing", "left");
				bl4.setInfo("pointing", "left");
				bl2.set("x", bl2.get("x") + 50);
				bl2.set("y", bl2.get("y") + 50);
				bl3.set("x", bl3.get("x") + 100);
				bl3.set("y", bl3.get("y") + 100);
				bl4.set("x", bl4.get("x") + 150);
				bl4.set("y", bl4.get("y") + 50);
				if(bl1.get("x") > 450 || bl2.get("x") > 450 || bl3.get("x") > 450 || bl4.get("x") > 450) {
					bl2.set("x", bl2.get("x") - 50);
					bl2.set("y", bl2.get("y") - 50);
					bl3.set("x", bl3.get("x") - 100);
					bl3.set("y", bl3.get("y") - 100);
					bl4.set("x", bl4.get("x") - 150);
					bl4.set("y", bl4.get("y") - 50);
				}
			} else if(bl1.getInfo("pointing").equals("left") &&
				bl2.getInfo("pointing").equals("left") &&
				bl3.getInfo("pointing").equals("left") &&
				bl4.getInfo("pointing").equals("left")) {
				bl1.setInfo("pointing", "up");
				bl2.setInfo("pointing", "up");
				bl3.setInfo("pointing", "up");
				bl4.setInfo("pointing", "up");
				bl2.set("x", bl2.get("x") - 50);
				bl2.set("y", bl2.get("y") + 50);
				bl3.set("x", bl3.get("x") - 100);
				bl3.set("y", bl3.get("y") + 100);
				bl4.set("x", bl4.get("x") - 50);
				bl4.set("y", bl4.get("y") + 150);
			}
		} else if(bl1.getInfo("type").equals("la") &&
			bl2.getInfo("type").equals("la") &&
			bl3.getInfo("type").equals("la") &&
			bl4.getInfo("type").equals("la")) {
			if(bl1.getInfo("pointing").equals("up") &&
				bl2.getInfo("pointing").equals("up") &&
				bl3.getInfo("pointing").equals("up") &&
				bl4.getInfo("pointing").equals("up")) {
				bl1.setInfo("pointing", "right");
				bl2.setInfo("pointing", "right");
				bl3.setInfo("pointing", "right");
				bl4.setInfo("pointing", "right");
				bl2.set("x", bl2.get("x") - 50);
				bl2.set("y", bl2.get("y") - 50);
				bl4.set("x", bl4.get("x") - 100);
				bl4.set("y", bl4.get("y") - 100);
				bl3.set("x", bl3.get("x") - 50);
				bl3.set("y", bl3.get("y") - 150);
				if(bl1.get("x") < 0 || bl2.get("x") < 0 || bl3.get("x") < 0 || bl4.get("x") < 0) {
					bl2.set("x", bl2.get("x") + 50);
					bl2.set("y", bl2.get("y") + 50);
					bl4.set("x", bl4.get("x") + 100);
					bl4.set("y", bl4.get("y") + 100);
					bl3.set("x", bl3.get("x") + 50);
					bl3.set("y", bl3.get("y") + 150);
				}
			} else if(bl1.getInfo("pointing").equals("right") &&
				bl2.getInfo("pointing").equals("right") &&
				bl3.getInfo("pointing").equals("right") &&
				bl4.getInfo("pointing").equals("right")) {
				bl1.setInfo("pointing", "down");
				bl2.setInfo("pointing", "down");
				bl3.setInfo("pointing", "down");
				bl4.setInfo("pointing", "down");
				bl2.set("x", bl2.get("x") + 50);
				bl2.set("y", bl2.get("y") - 50);
				bl4.set("x", bl4.get("x") + 100);
				bl4.set("y", bl4.get("y") - 100);
				bl3.set("x", bl3.get("x") + 150);
				bl3.set("y", bl3.get("y") - 50);
			} else if(bl1.getInfo("pointing").equals("down") &&
				bl2.getInfo("pointing").equals("down") &&
				bl3.getInfo("pointing").equals("down") &&
				bl4.getInfo("pointing").equals("down")) {
				bl1.setInfo("pointing", "left");
				bl2.setInfo("pointing", "left");
				bl3.setInfo("pointing", "left");
				bl4.setInfo("pointing", "left");
				bl2.set("x", bl2.get("x") + 50);
				bl2.set("y", bl2.get("y") + 50);
				bl4.set("x", bl4.get("x") + 100);
				bl4.set("y", bl4.get("y") + 100);
				bl3.set("x", bl3.get("x") + 50);
				bl3.set("y", bl3.get("y") + 150);
				if(bl1.get("x") > 450 || bl2.get("x") > 450 || bl3.get("x") > 450 || bl4.get("x") > 450) {
					bl2.set("x", bl2.get("x") - 50);
					bl2.set("y", bl2.get("y") - 50);
					bl4.set("x", bl4.get("x") - 100);
					bl4.set("y", bl4.get("y") - 100);
					bl3.set("x", bl3.get("x") - 50);
					bl3.set("y", bl3.get("y") - 150);
				}
			} else if(bl1.getInfo("pointing").equals("left") &&
				bl2.getInfo("pointing").equals("left") &&
				bl3.getInfo("pointing").equals("left") &&
				bl4.getInfo("pointing").equals("left")) {
				bl1.setInfo("pointing", "up");
				bl2.setInfo("pointing", "up");
				bl3.setInfo("pointing", "up");
				bl4.setInfo("pointing", "up");
				bl2.set("x", bl2.get("x") - 50);
				bl2.set("y", bl2.get("y") + 50);
				bl4.set("x", bl4.get("x") - 100);
				bl4.set("y", bl4.get("y") + 100);
				bl3.set("x", bl3.get("x") - 150);
				bl3.set("y", bl3.get("y") + 50);
			}
		}
	}
	boolean juxtaposedRight() {
		for(int i=0; i<blocks.size(); i++) {
			if((i != blocks.size()-4 && i != blocks.size()-3 && i != blocks.size()-2 && i != blocks.size()-1) && ((blocks.get(i).get("x") + 50 == blocks.get(blocks.size()-4).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-4).get("y")) || (blocks.get(i).get("x") + 50 == blocks.get(blocks.size()-3).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-3).get("y")) || (blocks.get(i).get("x") + 50 == blocks.get(blocks.size()-2).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-2).get("y")) || (blocks.get(i).get("x") + 50 == blocks.get(blocks.size()-1).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-1).get("y")))) {
				return true;
			}
		}
		return false;
	}
	boolean juxtaposedLeft() {
		for(int i=0; i<blocks.size(); i++) {
			if((i != blocks.size()-4 && i != blocks.size()-3 && i != blocks.size()-2 && i != blocks.size()-1) && ((blocks.get(i).get("x") - 50 == blocks.get(blocks.size()-4).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-4).get("y")) || (blocks.get(i).get("x") - 50 == blocks.get(blocks.size()-3).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-3).get("y")) || (blocks.get(i).get("x") - 50 == blocks.get(blocks.size()-2).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-2).get("y")) || (blocks.get(i).get("x") - 50 == blocks.get(blocks.size()-1).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-1).get("y")))) {
				return true;
			}
		}
		return false;
	}
	void left() {
		int fNdex;
		fNdex = blocks.size()-1;
		blocks.get(fNdex).set("x", blocks.get(fNdex).get("x") - 50);
		fNdex = blocks.size()-2;
		blocks.get(fNdex).set("x", blocks.get(fNdex).get("x") - 50);
		fNdex = blocks.size()-3;
		blocks.get(fNdex).set("x", blocks.get(fNdex).get("x") - 50);
		fNdex = blocks.size()-4;
		blocks.get(fNdex).set("x", blocks.get(fNdex).get("x") - 50);
	}
	private void right() {
		int fNdex;
		fNdex = blocks.size()-1;
		blocks.get(fNdex).set("x", blocks.get(fNdex).get("x") + 50);
		fNdex = blocks.size()-2;
		blocks.get(fNdex).set("x", blocks.get(fNdex).get("x") + 50);
		fNdex = blocks.size()-3;
		blocks.get(fNdex).set("x", blocks.get(fNdex).get("x") + 50);
		fNdex = blocks.size()-4;
		blocks.get(fNdex).set("x", blocks.get(fNdex).get("x") + 50);
	}
	private void downs() {
		int fNdex;
		fNdex = blocks.size()-1;
		blocks.get(fNdex).set("y", blocks.get(fNdex).get("y") + (50 - downs));
		fNdex = blocks.size()-2;
		blocks.get(fNdex).set("y", blocks.get(fNdex).get("y") + (50 - downs));
		fNdex = blocks.size()-3;
		blocks.get(fNdex).set("y", blocks.get(fNdex).get("y") + (50 - downs));
		fNdex = blocks.size()-4;
		blocks.get(fNdex).set("y", blocks.get(fNdex).get("y") + (50 - downs));
		downs = 0;
	}
	public void keyClicked(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyExited(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		bg();
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			rotateBlocks();
		} else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(blocks.get(blocks.size()-1).get("x") > 0 && blocks.get(blocks.size()-2).get("x") > 0 && blocks.get(blocks.size()-3).get("x") > 0 && blocks.get(blocks.size()-4).get("x") > 0) {
				if(!juxtaposedRight()) {
					left();
				}
			}
		} else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(blocks.get(blocks.size()-1).get("x") < 450 && blocks.get(blocks.size()-2).get("x") < 450 && blocks.get(blocks.size()-3).get("x") < 450 && blocks.get(blocks.size()-4).get("x") < 450) {
				if(!juxtaposedLeft()) {
					right();
				}
			}
		} else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if((blocks.get(blocks.size()-1) != null && blocks.get(blocks.size()-2) != null && blocks.get(blocks.size()-3) != null && blocks.get(blocks.size()-4) != null) && (blocks.get(blocks.size()-1).get("y") < 560 && blocks.get(blocks.size()-2).get("y") < 560 && blocks.get(blocks.size()-3).get("y") < 560 && blocks.get(blocks.size()-4).get("y") < 560) && !blocksAreStacked()) {
				blocks.get(blocks.size()-4).set("y", blocks.get(blocks.size()-4).get("y") + 10);
				blocks.get(blocks.size()-3).set("y", blocks.get(blocks.size()-3).get("y") + 10);
				blocks.get(blocks.size()-2).set("y", blocks.get(blocks.size()-2).get("y") + 10);
				blocks.get(blocks.size()-1).set("y", blocks.get(blocks.size()-1).get("y") + 10);
				downs = blocks.get(blocks.size()-1).get("y") % 50;
			}
		}
		draw();
	}
	boolean blocksAreStacked() {
		for(int i=0; i<blocks.size(); i++) {
			if((i != blocks.size()-4 && i != blocks.size()-3 && i != blocks.size()-2 && i != blocks.size()-1) && ((blocks.get(i).get("x") == blocks.get(blocks.size()-4).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-4).get("y") + 50) || (blocks.get(i).get("x") == blocks.get(blocks.size()-3).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-3).get("y") + 50) || (blocks.get(i).get("x") == blocks.get(blocks.size()-2).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-2).get("y") + 50) || (blocks.get(i).get("x") == blocks.get(blocks.size()-1).get("x") && blocks.get(i).get("y") == blocks.get(blocks.size()-1).get("y") + 50))) {
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]) {
		try {
            		URL url = BigClip.class.getClassLoader().getResource("mario.wav");
            		BigClip clip = new BigClip();
            		AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            		clip.open(ais);
            		clip.loop(1000000);
		} catch(Exception e) {}
		Titrus t = new Titrus();
	}
}