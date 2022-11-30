package com.infinite.ServletJdbc1;
public class Employ {
	 private int Empno;
	 private String name;
	 private String dept;
	 private String desig;
	 private int basic;
	@Override
	public String toString() {
		return "Employ [Empno=" + Empno + ", name=" + name + ", dept=" + dept + ", desig=" + desig + ", basic=" + basic
				+ "]";
	}
	public Employ(int empno, String name, String dept, String desig, int basic) {
	
		Empno = empno;
		this.name = name;
		this.dept = dept;
		this.desig = desig;
		this.basic = basic;
	}
	public Employ() {
		
		// TODO Auto-generated constructor stub
	}
	public int getEmpno() {
		return Empno;
	}
	public void setEmpno(int empno) {
		Empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
}
