package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import Objects.AfiliarGrupoEconomico;
import Objects.Autenticacion;
import Objects.CerrarSesion;
import Util.Utilidades;

public class TestAfiliarGrupoEconomico {
	@BeforeMethod
	public void beforeMethod() throws InterruptedException{
		Utilidades.openUrl();
	}	
	
	@Test
	public void testAfiliarGrupoEconomico() throws InterruptedException, FilloException {   	
		Autenticacion.ingresarSitio();
		AfiliarGrupoEconomico.afiliarGrupo();
	}
	
	@AfterMethod
	public static void closeBrowser() {
	CerrarSesion.cerrarSesion();
		Utilidades.cerrarExplorador();
		Utilidades.cerrarProceso();
	}

}
