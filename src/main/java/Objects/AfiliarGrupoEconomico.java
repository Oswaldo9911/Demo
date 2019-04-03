package Objects;

import org.openqa.selenium.By;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import Util.ManejoDatos;
import Util.Utilidades;

public class AfiliarGrupoEconomico {
	private AfiliarGrupoEconomico() {};
	
	static String strFecha;
	static String strCodigoGrupoEconomico;
	
	final static By MENUGRUPOECONOMICO = By.xpath("//*[@id='layout_3']/a");
	final static By LBLAFILIARGRUPO = By.xpath("//*[contains(text(), 'Afiliación')]");
	final static By STRNOMBREGRUPOECONOMICO = 
			By.xpath("//*[@class='input-block-level ng-pristine ng-untouched ng-isolate-scope ng-valid-no-spaces-at-start-or-end ng-valid-latin-alphanumeric-and ng-invalid ng-invalid-required ng-valid-minlength ng-valid-maxlength']");
	final static By RDOTAADMINUNICO = By.xpath("//*[@id='dualAdminFalse']");
	final static By RDOTAADMINDUAL = By.xpath("//*[@id='dualAdminTrue']");
	final static By RDOTAMONETARIOUNICO = By.id("dualTrxFalse");
	final static By RDOTAMONETARIODUAL = By.id("dualTrxTrue");
	final static By RDOPREREGISTROTERCEROSI = By.id("preRegisterThirdPartyTrue");
	final static By RDOPREREGISTROTERCERONO = By.id("preRegisterThirdPartyFalse");
	final static By BTNCONFIRMARDB = By.xpath("//*[@name='confirmValidBtn']");
	final static By BTNGUARDARCONTINUARDB = By.xpath("//*[@name='confirm_save']");
	final static By BTNCONFIRMARLT = By.xpath("//*[@name='confirm']");
	final static By BTNGUARDARCONTINUARLT = By.xpath("//*[@name='submitBtn']");	
	final static By LNKNUEVAEMPRESA = By.xpath("//*[@name='showAddCompany']");
	final static By CMBTIPOIDENTIFICACION = By.id("documentType");
	final static By TXTNUMEROIDENTIFICACION = By.id("documentNumber");
	final static By BTNBUSCAR = By.xpath("//*[@name='search']");	
	final static By LNKASOCIARPRODUCTO = By.xpath("//*[@title='Asociar productos']");
	final static By CHKSELECCIONARPRODUCTOS = By.xpath("//*[@ng-model='globalAffiliatedCheck']");
	final static By BTNCONFIRMARPRODUCTOS = By.xpath("//*[@ng-click='loadConfirmation(resultAffiliate)']");	
	final static By BTNGUARDARPRODUCTOS = By.id("_saveAccounts-btn");
	final static By BTNCONTINUAREMPRESAS = By.xpath("//*[@name='confirm']");
	final static By TXTCUENTACOBRODEFECTO = By.id("defaultA");
	final static By TXTCUENTACOBROCONTINGENCIA = By.id("defaultB");
	final static By TXTDESCUENTOCOBRO = By.xpath("//*[@name='rgCommissions.serviceCommissions[0].percentOff']");
	final static By CMBEXONERACIONCOBRO = By.xpath("//*[@name='rgCommissions.serviceCommissions[0].billingPeriods']");
	final static By BTNCONFIRMARCN = By.xpath("//*[@ng-show='form.$valid']");	
	final static By BTNGUARDARCONTINUARCN = By.xpath("//*[@class='btn btn-primary ng-isolate-scope']");
	
	final static By TXTCODIGOGRUPOECONOMICO = By.xpath("//*[@name='regionalGroupCode']");
	final static By CMBTIPOIDENTIFICACIONUP = By.xpath("//*[@name='mainUsers[0].identificationType']");
	final static By TXNUMEROIDENTIFICACION = By.xpath("//*[@name='mainUsers[0].identificationNumber']");
	final static By TXTNOMBRES = By.xpath("//*[@name='mainUsers[0].firstName']");
	final static By TXTAPELLIDOS = By.xpath("//*[@name='mainUsers[0].lastName']");
	final static By CMBNACIONALIDAD = By.xpath("//*[@name='mainUsers[0].nationality']");
	final static By DTPCALENDARIO = By.xpath("//*[@class='btn btn-default']");	
	final static By TXTEMAIL = By.xpath("//*[@name='mainUsers[0].email']");
	final static By BTNCONFIRMARUP = By.xpath("//*[@ng-show='form.$valid']");
	final static By BTNFINALIZAR = By.id("_submit_main_user");
	final static By BTNACEPTAR = By.xpath("//*[@class='btn btn-primary']");
	
	
	public static void afiliarGrupo() throws InterruptedException, FilloException {	
		System.out.println("Inicia proceso afiliación grupo económico.");
		String strNombreGrupoEconomico;
		Recordset rs = ManejoDatos.buscarRegistro("AfiliarGrupoEconomico/GrupoEconomico.xlsx", "GrupoEconomico", "1");
		Utilidades.click(LBLAFILIARGRUPO);
		Utilidades.waitForElement(STRNOMBREGRUPOECONOMICO, 2);
		Utilidades.type(STRNOMBREGRUPOECONOMICO, rs.getField("Nombre"));
		strNombreGrupoEconomico = "Automatización " + Utilidades.getDateYYYYMMDDHHMMSS();
		//Actualización del campo Nombre en el archivo de excel.
		ManejoDatos.actualizarRegistro("AfiliarGrupoEconomico/GrupoEconomico.xlsx", "GrupoEconomico", "1", "Nombre", strNombreGrupoEconomico);
		
		if (rs.getField("TA_Administrativa").equals("Único")) {
			Utilidades.waitForElement(RDOTAADMINUNICO, 2);
			Utilidades.click(RDOTAADMINUNICO);
			Utilidades.click(RDOTAADMINUNICO);
		}else if(rs.getField("TA_Administrativa").equals("Dual")) {
			Utilidades.waitForElement(RDOTAADMINUNICO, 2);
			Utilidades.click(RDOTAADMINDUAL);
			Utilidades.click(RDOTAADMINUNICO);
		}
		
		if (rs.getField("TA_Monetaria").equals("Único")) {
			Utilidades.click(RDOTAMONETARIOUNICO);
		}else if(rs.getField("TA_Monetaria").equals("Dual")) {
			Utilidades.click(RDOTAMONETARIODUAL);
		}
		
		if (rs.getField("PreRegistrarTerceros").equals("Si")) {
			Utilidades.click(RDOPREREGISTROTERCEROSI);
		}else if(rs.getField("PreRegistrarTerceros").equals("No")) {
			Utilidades.click(RDOPREREGISTROTERCERONO);
		}
		
		Utilidades.pageDown();
		Utilidades.wt(400);
		Utilidades.waitForElement(BTNCONFIRMARDB, 2);
		Utilidades.click(BTNCONFIRMARDB);
		Utilidades.waitForElement(BTNGUARDARCONTINUARDB, 2);
		Utilidades.click(BTNGUARDARCONTINUARDB);
		Utilidades.wt(400);
		Utilidades.waitForElement(BTNCONFIRMARLT, 2);
		Utilidades.click(BTNCONFIRMARLT);
		Utilidades.waitForElement(BTNGUARDARCONTINUARLT, 2);
		Utilidades.click(BTNGUARDARCONTINUARLT);	
		Utilidades.waitForElement(LNKNUEVAEMPRESA, 2);
		Utilidades.click(LNKNUEVAEMPRESA);
		Utilidades.waitForElement(CMBTIPOIDENTIFICACION, 2);
		Utilidades.select(CMBTIPOIDENTIFICACION, rs.getField("TipoIdentificaciónEmpresa"));
		Utilidades.type(TXTNUMEROIDENTIFICACION, rs.getField("N°IdentificaciónEmpresa"));
		Utilidades.click(BTNBUSCAR);
		Utilidades.waitForElement(LNKASOCIARPRODUCTO, 2);
		Utilidades.click(LNKASOCIARPRODUCTO);
		Utilidades.waitForElement(CHKSELECCIONARPRODUCTOS, 2);
		Utilidades.click(CHKSELECCIONARPRODUCTOS);
		Utilidades.pageDown();
		Utilidades.pageDown();
		Utilidades.wt(400);
		Utilidades.click(BTNCONFIRMARPRODUCTOS);
		Utilidades.wt(400);
		Utilidades.click(BTNGUARDARPRODUCTOS);
		Utilidades.wt(400);
		Utilidades.click(BTNCONTINUAREMPRESAS);
		Utilidades.waitForElement(TXTCUENTACOBRODEFECTO, 2);
		Utilidades.type(TXTCUENTACOBRODEFECTO, rs.getField("CuentaCobroDefecto"));
		Utilidades.wt(100);
		Utilidades.enter();
		Utilidades.type(TXTCUENTACOBROCONTINGENCIA, rs.getField("CuentaCobroContingencia"));
		Utilidades.wt(100);
		Utilidades.enter();
		Utilidades.clearElement(TXTDESCUENTOCOBRO);
		Utilidades.type(TXTDESCUENTOCOBRO, rs.getField("DescuentoCobro"));
		Utilidades.select(CMBEXONERACIONCOBRO, rs.getField("ExoneraciónCobro"));
		Utilidades.click(BTNCONFIRMARCN);
		Utilidades.waitForElement(BTNGUARDARCONTINUARCN, 2);
		Utilidades.click(BTNGUARDARCONTINUARCN);	
		Utilidades.waitForElement(CMBTIPOIDENTIFICACIONUP, 2);
		Utilidades.wt(400);
		Utilidades.select(CMBTIPOIDENTIFICACIONUP, rs.getField("TipoIdentificaciónUsuario"));
		Utilidades.type(TXNUMEROIDENTIFICACION, rs.getField("N°IdentificaciónUsuario"));
		Utilidades.type(TXTNOMBRES, rs.getField("Nombres"));
		Utilidades.type(TXTAPELLIDOS, rs.getField("Apellidos"));
		Utilidades.select(CMBNACIONALIDAD, rs.getField("Nacionalidad"));
		Utilidades.click(DTPCALENDARIO);	
		Utilidades.wt(200);
		Utilidades.enter();		
		Utilidades.type(TXTEMAIL, rs.getField("Email"));
		strFecha = Utilidades.getDateYYYYMMDDHHMMSS();
		strCodigoGrupoEconomico = Utilidades.getText(TXTCODIGOGRUPOECONOMICO);
		//Insertar registro con la fecha y código grupo ecónomico en la hoja Historico.
		ManejoDatos.insertarRegistro("AfiliarGrupoEconomico/GrupoEconomico.xlsx", "Historico", "Fecha", "CodigoGrupoEconomico", strFecha, strCodigoGrupoEconomico);
		Utilidades.click(BTNCONFIRMARUP);	
		Utilidades.pageDown();
		Utilidades.pageDown();
		Utilidades.wt(400);
		Utilidades.click(BTNFINALIZAR);			
		Utilidades.waitForElement(BTNACEPTAR, 2);
		Utilidades.pageDown();
		Utilidades.wt(400);
		Utilidades.click(BTNACEPTAR);
		
		
		System.out.println("Finaliza proceso afiliación grupo económico.");
	}
	

}
