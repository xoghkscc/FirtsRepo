package swing.quiz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class S03_KakaoImageInsert extends JButton{
	public static final int RYON = 0;
	public static final int APHEACH = 1;
	public static final int MUJI = 2;
	public static final int TUBE = 3;
	public static final HashMap<Integer, Image> btn_images = new HashMap<Integer, Image>();
	
	static {
		try {
			BufferedImage src = ImageIO.read(new File("./JavaStudy/files/kakaoImage/kakao.jpg"));
			
			btn_images.put(RYON, src.getSubimage(0, 0, src.getWidth()/2 + 44, src.getHeight()/2+44));
			btn_images.put(APHEACH, src.getSubimage(src.getWidth()/2, 0, src.getWidth()/2-44, src.getHeight()/2+44));
			btn_images.put(MUJI, src.getSubimage(0, src.getWidth()/2, src.getWidth()/2+44, src.getWidth()/2-25));
			btn_images.put(TUBE, src.getSubimage(src.getWidth()/2, src.getHeight()/2, src.getWidth()/2-40, src.getHeight()/2-25));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public S03_KakaoImageInsert(int picture, int x, int y, int width, int height) {
		setIcon(new ImageIcon(btn_images.get(picture)));
		setBounds(x, y, width, height);
		
		
	}
}










