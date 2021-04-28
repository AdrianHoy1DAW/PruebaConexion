package es.mordor.mordorLloguer.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MySqlDataBase implements AlmacenDatosDB {

	private ArrayList<Empleado> getCustomEmpleados(String where) {
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		DataSource ds = MyDataSource.getMySQLDataSource();
		
		String query = "SELECT * FROM EMPLEADO ";
		if(where != null) 
			query += "WHERE " + where;
		

		
		
		try(Connection con = ds.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);) {
			
			Empleado empleado;
			
			while(rs.next()) {
				
				empleado = new Empleado(rs.getInt("idEmpleado"),
										rs.getString("DNI"),
										rs.getString("nombre"),
										rs.getString("apellidos"),
										rs.getString("CP"),
										rs.getString("email"),
										rs.getDate("fechaNac"),
										rs.getString("cargo"),
										rs.getString("domicilio"),
										rs.getString("password"));	
		
				empleados.add(empleado);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empleados;
		
		
	}
	
	@Override
	public ArrayList<Empleado> getEmpleados() {
		
		return getCustomEmpleados(null);

	}

	@Override
	public ArrayList<Empleado> getEmpleadoPorCP(String cp) {
	
		return getCustomEmpleados("CP=" + cp);
	}

	@Override
	public ArrayList<Empleado> getEmpleadoPorCargo(String cargo) {
		
		return getCustomEmpleados("cargo='" +cargo + "'");
	}

	@Override
	public Empleado getEmpleadoPorDNI(String DNI) {
		
		Empleado e = getCustomEmpleados("dni='"+DNI+"'").get(0);
		return e;
	}
	
	@Override

	public boolean updateEmpleado(Empleado empleado) {

	boolean actualizado = false;

	DataSource ds = MyDataSource.getMySQLDataSource();

	try (Connection con = ds.getConnection();

	Statement stmt = con.createStatement();) {

	String query = "UPDATE EMPLEADO SET nombre=\""+empleado.getNombre()+"\", "+ 
					"apellidos=\""+empleado.getApellidos()+"\","+ 
					((empleado.getDomicilio() != null)?"domicilio=\""+empleado.getDomicilio()+"\",":"")+ 
					((empleado.getCP() != null)?"CP=\""+empleado.getCP()+"\",":"")+ 
					"email=\""+empleado.getEmail()+"\","+ 
					"fechaNac=\""+empleado.getFechaNac()+"\","+ 
					"cargo=\""+empleado.getCargo()+"\" "+ 
					"WHERE DNI=\"" + empleado.getDNI() +"\"";

	stmt.executeUpdate(query);
	
	actualizado = (stmt.executeUpdate(query)==1)?true:false;
	
	

	} catch (SQLException e) {

	e.printStackTrace();

	}

	return actualizado;

	}

	@Override
	public boolean deleteEmpleado(String DNI) {
		
		boolean actualizado = false;
		DataSource ds = MyDataSource.getMySQLDataSource();
		
		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "DELETE FROM EMPLEADO WHERE DNI = '" + DNI + "'";
			
			System.out.println(query);
			
			
			actualizado = (stmt.executeUpdate(query)==1)?true:false;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return actualizado;
	}

}
