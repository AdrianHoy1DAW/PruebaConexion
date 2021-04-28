package es.mordor.mordorLloguer.test;

import java.util.ArrayList;

import es.mordor.mordorLloguer.model.AlmacenDatosDB;
import es.mordor.mordorLloguer.model.Empleado;
import es.mordor.mordorLloguer.model.MyOracleDataBase;
import es.mordor.mordorLloguer.model.MySqlDataBase;

public class Test {

	public static void main(String[] args) {
		
		AlmacenDatosDB modelo = new MySqlDataBase();
		ArrayList<Empleado> empleados = new ArrayList<>();
		
		
		
		
		
		System.out.println(modelo.deleteEmpleado("76543210Y"));

	}

}
