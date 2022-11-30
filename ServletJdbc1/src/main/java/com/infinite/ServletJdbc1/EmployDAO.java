package com.infinite.ServletJdbc1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDAO {
	Connection connection;
	PreparedStatement pst;
	
	
	public String UpdateEmploy(Employ employnew) throws ClassNotFoundException, SQLException{
		Employ employ = SearchEmploy(employnew.getEmpno());
		connection=ConnectionHelper.getConnection();
		String cmd="update Employ SET name=?,dept=?,desig=?,"+"basic=? where empno=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, employnew.getName());
		pst.setString(2, employnew.getDept());
		pst.setString(3, employnew.getDesig());
		pst.setInt(4, employnew.getBasic());
		pst.setInt(5, employnew.getEmpno());
		pst.executeUpdate();
		return "Record upadte";
	}
	
	
	
	public String DeleteEmploy(int empno) throws SQLException, ClassNotFoundException{
		Employ employ = SearchEmploy(empno);
		connection=ConnectionHelper.getConnection();
		String cmd="delete from Employ Where empno=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		pst.executeUpdate();
		return "Record Delete....";}
	
	
	public String addEmploy(Employ employ) throws SQLException, ClassNotFoundException
	{
		connection=ConnectionHelper.getConnection();
		String cmd="insert into Employ (name,dept,desig,basic)"+ "value(?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, employ.getName());
		pst.setString(2, employ.getDept());
		pst.setString(3, employ.getDesig());
		pst.setInt(4, employ.getBasic());
		pst.executeUpdate();
		return"Record insert....";
	}
	
	public Employ SearchEmploy(int Empno) throws ClassNotFoundException, SQLException{
		connection=ConnectionHelper.getConnection();
		String cmd="select * from Employ where empno=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, Empno);
		ResultSet rs =pst.executeQuery();
		Employ employ=null;
		if(rs.next()){
			employ=new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getInt("basic"));
		}
		return employ;
	}
	public List<Employ>showEmploy() throws ClassNotFoundException, SQLException{
		List<Employ> employlist=new ArrayList<Employ>();
		connection=ConnectionHelper.getConnection();
		String cmd="select * from Employ";
		pst=connection.prepareStatement(cmd);
		ResultSet rs =pst.executeQuery();
		Employ employ=null;
		while(rs.next()) 
		{
			employ=new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getInt("basic"));
			employlist.add(employ);
		}
		return employlist;
	}
	
	
	
	

}
