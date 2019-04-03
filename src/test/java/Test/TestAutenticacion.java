package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import Objects.Autenticacion;
import Objects.CerrarSesion;
import Util.Utilidades;


public class TestAutenticacion {			    
	@BeforeMethod
	public void beforeMethod() throws InterruptedException{
		Utilidades.openUrl();
	}	
	
	@Test
	public void testAutenticacion() throws InterruptedException, FilloException {   	
		Autenticacion.ingresarSitio();
		
	}
	
	@AfterMethod
	public static void closeBrowser() {
		CerrarSesion.cerrarSesion();
		Utilidades.cerrarExplorador();
		Utilidades.cerrarProceso();
	}	
}
