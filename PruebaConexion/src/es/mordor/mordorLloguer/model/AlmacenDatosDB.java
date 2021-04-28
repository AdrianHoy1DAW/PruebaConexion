package es.mordor.mordorLloguer.model;

import java.util.ArrayList;

public interface AlmacenDatosDB {

	public ArrayList<Empleado> getEmpleados();
	public ArrayList<Empleado> getEmpleadoPorCP(String cp);
	public ArrayList<Empleado> getEmpleadoPorCargo(String cargo);
	public Empleado getEmpleadoPorDNI(String DNI);
	public boolean updateEmpleado(Empleado empleado);
	
	
}
