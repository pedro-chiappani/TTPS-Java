

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;


public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ImprimeCupon() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String txtPersonalizado = request.getParameter("txtPersonalizado");
		Integer codigoRetiro = ThreadLocalRandom.current().nextInt(1000000, 9999999);
		
		ServletOutputStream outputStream = response.getOutputStream();
		
    	BufferedImage image = new BufferedImage(1702, 980, BufferedImage.TYPE_INT_BGR);
    	Graphics2D graphics = image.createGraphics();
    	
    	graphics.setBackground(Color.WHITE);
    	graphics.clearRect(0, 0, 1702, 980);

    	BufferedImage img = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/cupon3.jpg")); 
    	graphics.drawImage(img, 0, 0, null, null);

    	graphics.setFont(new Font("TimesRoman", Font.BOLD, 50));
    	graphics.setColor(Color.WHITE);

    	graphics.drawString(txtPersonalizado, 430, 669);

    	Color colorBack = new Color(98, 0, 87);
    	graphics.setColor(colorBack);
    	graphics.fillRect(1000, 750, 550, 150); 
    	
    	Color colorText = new Color(188, 209, 90);
    	graphics.setColor(colorText);
    	graphics.drawString("Código de retiro:", 1100, 800); // Ajusta las coordenadas según tu diseño.
    	graphics.drawString(("#"+codigoRetiro.toString()), 1200, 850);

    	ImageIO.write(image, "jpg", outputStream);
    	outputStream.close();
	}
	

}
