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
		
		
		
		Empleado e = modelo.getEmpleadoPorDNI("87654321Z");
		e.setDomicilio("La vereda");
		modelo.updateEmpleado(e);

	}

}
