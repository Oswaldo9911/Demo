package Objects;

import org.openqa.selenium.By;
import Util.Utilidades;

public class CerrarSesion {
	private CerrarSesion() {};
	final static By MENUBANK1 = By.xpath("//*[@id='_145_userAvatar']/a/span");
	final static By MENUSALIR = By.xpath("//*[@class='sign-out ']/a");

	
	public static void cerrarSesion() {	
		System.out.println("Inicia cierre de sesión.");
		Utilidades.click(MENUBANK1);
		Utilidades.click(MENUSALIR);
		System.out.println("Finaliza cierre de sesión.");
	}

}
