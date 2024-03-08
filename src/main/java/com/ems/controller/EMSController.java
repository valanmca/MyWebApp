package com.ems.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.Employee;
import com.ems.dao.EmployeeDAO;

@WebServlet("/EMSController")
public class EMSController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("emsAction");
		EmployeeDAO dao = new EmployeeDAO();
		
		if(action.equals("Insert Employee")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			String ename = request.getParameter("ename");
			int esalary = Integer.parseInt(request.getParameter("esalary"));
			
			Employee employee = new Employee(eid, ename, esalary);
			
			int n = dao.insertEmployee(employee);
			
			if(n == 1) {
				response.sendRedirect("InsertEmployee.jsp?msg='Employee Record Inserted'");
			} else {
				response.sendRedirect("InsertEmployee.jsp?msg='Employee Record Not Inserted'");
			}
			
		}
		
		if(action.equals("Fetch")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			
			Employee emp = dao.getEmployee(eid);
			
			List<Integer> idList = dao.getIdList();
			
			RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployee.jsp");
			request.setAttribute("emp", emp);
			request.setAttribute("IdList", idList);
			rd.forward(request, response);
		}
		
		if(action.equals("Update Employee")) {
			String msg = "Employee Record Not Updated";
			
			int eid = Integer.parseInt(request.getParameter("eid"));
			String ename = request.getParameter("ename");
			int esalary = Integer.parseInt(request.getParameter("esalary"));
			
			Employee employee = new Employee(eid, ename, esalary);
			
			int n = dao.updateEmployee(employee);
			if(n == 1)
				msg = "Employee Record Updated";
			
			RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployee.jsp");			
			request.setAttribute("msg",msg);
			
			List<Integer> idList = dao.getIdList();
			request.setAttribute("IdList", idList);
			
			rd.forward(request, response);
		}
		
		if(action.equals("Delete Employee")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			String msg = "Employee Record Not Deleted";
			
			int n = dao.deleteEmployee(eid);
			
			if(n == 1)
				msg = "Employee Record Deleted";
			
			RequestDispatcher rd = request.getRequestDispatcher("DeleteEmployee.jsp");			
			request.setAttribute("msg",msg);
			
			List<Integer> idList = dao.getIdList();
			request.setAttribute("IdList", idList);
			
			rd.forward(request, response);
		}
		
		if(action.equals("Search")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			
			Employee emp = dao.getEmployee(eid);
			
			List<Integer> idList = dao.getIdList();
			
			RequestDispatcher rd = request.getRequestDispatcher("FindEmployee.jsp");
			request.setAttribute("emp", emp);
			request.setAttribute("IdList", idList);
			rd.forward(request, response);
		}
		
		if(action.equals("Edit/Save")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			String ename = request.getParameter("ename");
			int esalary = Integer.parseInt(request.getParameter("esalary"));
			
			Employee employee = new Employee(eid, ename, esalary);
			
			dao.updateEmployee(employee);
			
			List<Employee> empList = dao.getAllEmployee();
			RequestDispatcher rd = request.getRequestDispatcher("FindAllEmployee.jsp");
			request.setAttribute("EmpList", empList);
			rd.forward(request, response);
			
		}
		
		if(action.equals("Delete")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			
			dao.deleteEmployee(eid);
			
			List<Employee> empList = dao.getAllEmployee();
			RequestDispatcher rd = request.getRequestDispatcher("FindAllEmployee.jsp");
			request.setAttribute("EmpList", empList);
			rd.forward(request, response);
			
		}
		
		if(action.equals("Save")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			String ename = request.getParameter("ename");
			int esalary = Integer.parseInt(request.getParameter("esalary"));
			
			Employee employee = new Employee(eid, ename, esalary);
			
			dao.insertEmployee(employee);
			
			List<Employee> empList = dao.getAllEmployee();
			RequestDispatcher rd = request.getRequestDispatcher("FindAllEmployee.jsp");
			request.setAttribute("EmpList", empList);
			rd.forward(request, response);
			
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("emsAction");
		EmployeeDAO dao = new EmployeeDAO();
		
		if(action.equals("Update")) {
			List<Integer> idList = dao.getIdList();
			RequestDispatcher rd = req.getRequestDispatcher("UpdateEmployee.jsp");
			req.setAttribute("IdList", idList);
			rd.forward(req, resp);
		}
		
		if(action.equals("Delete")) {
			List<Integer> idList = dao.getIdList();
			RequestDispatcher rd = req.getRequestDispatcher("DeleteEmployee.jsp");
			req.setAttribute("IdList", idList);
			rd.forward(req, resp);
		}
		
		if(action.equals("Find")) {
			List<Integer> idList = dao.getIdList();
			RequestDispatcher rd = req.getRequestDispatcher("FindEmployee.jsp");
			req.setAttribute("IdList", idList);
			rd.forward(req, resp);
		}
		
		if(action.equals("Find-All")) {
			List<Employee> empList = dao.getAllEmployee();
			RequestDispatcher rd = req.getRequestDispatcher("FindAllEmployee.jsp");
			req.setAttribute("EmpList", empList);
			rd.forward(req, resp);
		}
	}
}
