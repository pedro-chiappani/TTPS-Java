package ttps.entregable;

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

/**
 * Servlet implementation class ImprimeCupon
 */
public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprimeCupon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String txtPersonalizado = request.getParameter("texto");
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

    	graphics.drawString(txtPersonalizado, 490, 700);

    	graphics.setColor(new Color(98,0,87));
    	graphics.fillRect(1000, 750, 550, 150); 
    	
    	graphics.setColor(new Color(188,209,90));

    	
    	graphics.drawString("Código de retiro:", 1100, 800);
    	graphics.drawString(("#"+codigoRetiro.toString()), 1200, 850);

    	ImageIO.write(image, "jpg", outputStream);
    	outputStream.close();
		
//		doGet(request, response);
	}

}
