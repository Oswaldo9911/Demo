package Objects;

import org.openqa.selenium.By;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Util.ManejoDatos;
import Util.Utilidades;

public class Autenticacion {
	private Autenticacion() {};
	final static By TXTUSUARIO = By.id("_58_FakeLogin");
	final static By TXTCLAVE = By.id("_58_FakePassword");
	final static By BTNCONTINUAR = By.id("_58_submitButton");	

	
	public static void ingresarSitio() throws FilloException {	
		System.out.println("Inicia Ingreso al sistema.");
		Recordset rs = ManejoDatos.buscarRegistro("Autenticacion/Autenticacion.xlsx", "Autenticacion", "1");
		Utilidades.type(TXTUSUARIO, rs.getField("Usuario"));
		Utilidades.type(TXTCLAVE, rs.getField("Clave"));
		Utilidades.click(BTNCONTINUAR);
		System.out.println("Finaliza Ingreso al sistema.");
	}

}
