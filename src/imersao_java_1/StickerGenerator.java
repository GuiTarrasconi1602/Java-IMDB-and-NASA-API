package imersao_java_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StickerGenerator {

  public void createSticker(InputStream inputStream, String nameFile) throws Exception {

      BufferedImage originalImg = ImageIO.read(inputStream);

      int width = originalImg.getWidth();
      int height = originalImg.getHeight();
      int newHeight = height + 200;

      BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

      Graphics2D graphics = (Graphics2D) newImg.getGraphics();

      graphics.drawImage(originalImg, 0, 0, null);

      var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);

      graphics.setColor(Color.YELLOW);
      graphics.setFont(font);
      graphics.drawString("TOPZERA", 164, newHeight - 100);

      ImageIO.write(newImg, "png", new File(nameFile));
  }
  
}

