import java.awt.Image;
import java.awt.Toolkit;

public class Pocker {
	Card[] card = new Card[52];
	String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
			"Q", "K" };
	String[] colors = { "黑桃", "红桃", "梅花", "方片" };
	Image[] imgs = new Image[52];

	public void getImages() {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < colors.length; j++) {
				imgs[i + j * 13] = Toolkit.getDefaultToolkit().getImage(
						"images\\" + (j + 1) + "-" + (i + 1) + ".gif");
			}
		}
	}

	public Pocker() {
		getImages();
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				card[i + j * 13] = new Card(values[i], colors[j], imgs[i + j
						* 13]);
			}
		}
		xipai();
	}

	public Card getCard(int i) {

		return card[i];
	}
	//洗牌的算法，随机选取两个元素交换
	public void xipai() {
		
		Card temp;
		for(int i=0; i<500; i++) {
			int a = (int) (Math.random()*52);
			int b = (int) (Math.random()*52);
			temp = card[a];
			card[a] = card[b];
			card[b] = temp;
		}
	}
}
