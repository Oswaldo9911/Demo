package Util;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ManejoDatos {
	final static String STRRUTA = "src/test/resources/DataDriven/";
	static Fillo objConnection = new Fillo();

	
	public static Connection cargarExcel(String strRuta) {
		try {
			Connection connection = objConnection.getConnection(STRRUTA + strRuta);
			return connection;
		} catch (Exception e) {

		}
		return null;
	}

	public static Recordset buscarRegistro(String strRuta, String strHoja, String strId) {
		String strQuery = "SELECT * FROM " + strHoja+ " WHERE ID = " + strId;
		
		try {
			Recordset objRecordset = cargarExcel(strRuta).executeQuery(strQuery);
			
			while (objRecordset.next()) {
				return objRecordset;
			}
			
			objRecordset.close();
			cargarExcel(strHoja).close();
		} catch (FilloException e){
			System.err.println(e);
			throw new RuntimeException("Consulta " + strQuery + " no válida");
		}
		return null;
	}
	
	public static void actualizarRegistro(String strRuta, String strHoja, String strId, String strCampo, String strValor) {
		String strQuery = "UPDATE " + strHoja + " SET " + strCampo + " = '" + strValor + "' WHERE ID = '" + strId + "'";
		try {
			cargarExcel(strRuta).executeUpdate(strQuery);
		} catch (Exception e) {
			throw new RuntimeException("Consulta " + strQuery + " no válida");
		}
	}
	
	public static void insertarRegistro(String strRuta, String strHoja, String strCampo1, String strCampo2, String strValor1, String strValor2) {
		String strQuery = "INSERT INTO " + strHoja + "(" + strCampo1 + ", " + strCampo2 + ") VALUES('" + strValor1 + "', '" + strValor2 + "')";
		try {
			cargarExcel(strRuta).executeUpdate(strQuery);
		} catch (Exception e) {
			throw new RuntimeException("Consulta " + strQuery + " no válida");
		}
	}

}
