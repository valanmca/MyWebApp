package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ems.bean.Employee;
import com.ems.util.DBUtil;

public class EmployeeDAO {

	public int insertEmployee(Employee employee) {
		int n = 0;
		try {
			Connection con = DBUtil.getDBConnection();
			String sql = "insert into tbl_employee values(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employee.getEid());
			ps.setString(2, employee.getEname());
			ps.setInt(3, employee.getEsalary());
			n = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return n;
	}

	public List<Integer> getIdList() {
		List<Integer> idList = new ArrayList<>();
		try {
			Connection con = DBUtil.getDBConnection();
			String sql = "select id from tbl_employee";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				idList.add(rs.getInt("id"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return idList;
	}

	public Employee getEmployee(int eid) {
		Employee emp = null;
		try {
			Connection con = DBUtil.getDBConnection();
			String sql = "select * from tbl_employee where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("salary"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return emp;
	}
	
	public int updateEmployee(Employee employee) {
		int n = 0;
		try {
			Connection con = DBUtil.getDBConnection();
			String sql = "update tbl_employee set name=?, salary=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);			
			ps.setString(1, employee.getEname());
			ps.setInt(2, employee.getEsalary());
			ps.setInt(3, employee.getEid());
			n = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return n;
	}
	
	public int deleteEmployee(int eid) {
		int n = 0;
		try {
			Connection con = DBUtil.getDBConnection();
			String sql = "delete from tbl_employee where id=?";
			PreparedStatement ps = con.prepareStatement(sql);			
			ps.setInt(1, eid);
			
			n = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return n;

	}
	
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		try {
			Connection con = DBUtil.getDBConnection();
			String sql = "select * from tbl_employee";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("salary"));
			    list.add(emp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
