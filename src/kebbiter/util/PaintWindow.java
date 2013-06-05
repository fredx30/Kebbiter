package kebbiter.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Time;

/**
 * @author Fredrik
 */

@SuppressWarnings("serial")
public class PaintWindow extends JFrame {

	public static int kebbitsBagged = 0;

	private final static String KEBBITER_VERSION = "2.0";

	private static final long startTime = System.currentTimeMillis();

	private static int kPrice = 0; // Gui info

	private static int startExp = 0; // gui info
	private static int startLvl = 0; // gui info

	private static final int iniCordsX = 0;
	private static final int iniCordsY = 0;
	private static final int iniCordsW = 510;
	private static final int iniCordsH = 140;

    private static final Font calibri = new Font("calibri",Font.PLAIN,12);

	private final PaintArea paintArea;

	public PaintWindow() {

        Msg.rep("Checking GE price...");
        kPrice = GrandExchange.getItem(10117).getPrice();
        Msg.rep("Current price is: " + kPrice + " gp");

		this.setLayout(new BorderLayout());

		paintArea = new PaintArea();
		this.add(paintArea, BorderLayout.CENTER);

        startExp = Skills.getExperience(Skills.HUNTER);
        startLvl = Skills.getLevel(Skills.HUNTER);

		setTitle("Kebbiter Paint");
		setLocation(100, 100);
		pack();
		setResizable(false);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	public void repaint(){
		if(paintArea!=null)
			paintArea.repaint();
	}

	public Graphics getWinGraphics() {
		return paintArea.getGraphics();
	}

	public static class PaintArea extends JPanel {
		public PaintArea() {
			this.setPreferredSize(new Dimension(iniCordsW, iniCordsH));
			this.setBackground(Color.BLACK);
			this.setDoubleBuffered(true);
		}

		public void paint(Graphics g) {

			super.paint(g);

			long elapsedTime = System.currentTimeMillis() - startTime;

			g.setFont(calibri);
			g.setColor(Color.RED);

			String time = Time.format(elapsedTime);
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			int min = Integer.parseInt(time.split(":")[1].trim());
			int hours = Integer.parseInt(time.split(":")[0].trim());
			int totalMins = min + hours * 60;

			if (totalMins > 0) {
				int xpPh = (Skills.getExperience(Skills.HUNTER) - startExp)
						/ totalMins * 60;
				g.drawString("Xp per hour : " + xpPh, iniCordsX + 10,
						iniCordsY + 80);
			} else {
				g.drawString("Xp per hour : Calculating...", iniCordsX + 10,
						iniCordsY + 80);
			}

			g.drawString("Kebbiter " + KEBBITER_VERSION + " by Darkk && Fred",
					iniCordsX + 5, iniCordsY + 15);
			
			g.drawString("Running For: " + Time.format(elapsedTime),
					iniCordsX + 170, iniCordsY + 15);
			
			g.drawString("Kebbits Bagged : " + kebbitsBagged, iniCordsX + 10,
					iniCordsY + 35);
			
			g.drawString("Xp Gained : "
					+ (Skills.getExperience(Skills.HUNTER) - startExp),
					iniCordsX + 10, iniCordsY + 50);
			g.drawString("Levels Gained : "
					+ (Skills.getLevel(Skills.HUNTER) - startLvl),
					iniCordsX + 10, iniCordsY + 65);

			g.drawString("Price per Kebbit : " + kPrice + " gp",
					iniCordsX + 170, iniCordsY + 30);
			g.drawString("Money Earned : " + (kPrice * kebbitsBagged),
					iniCordsX + 170, iniCordsY + 45);

			if (kebbitsBagged > 5) {
				double d = (kebbitsBagged * kPrice) / totalMins * 60;
				g.drawString("Money per hour: " + decimalFormat.format(d),
						iniCordsX + 170, iniCordsY + 60);
			} else {
				g.drawString("Money per hour: Calculating...", iniCordsX + 170,
						iniCordsY + 60);
			}
			g.drawString("Status: " + Msg.lastRep, iniCordsX + 10, iniCordsY + 120);

			g.drawString("Current Level : " + Skills.getLevel(Skills.HUNTER),
					iniCordsX + 10, iniCordsY - 27);
			g.drawString("Start Level : " + startLvl, iniCordsX + 10,
					iniCordsY - 45);

		}
	}
}
