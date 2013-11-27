package com.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dto.MarksheetDTO;

public class MarksheetService {
	private static final ArrayList Arraylist = null;
	Connection con;
	PreparedStatement ps;

	public MarksheetService() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mydatabase", "root", "root");
	}

	public void add(MarksheetDTO marksheetdto) throws Exception {
		ps = con.prepareStatement("insert into marksheet values(?,?,?,?,?)");
		ps.setInt(1, marksheetdto.getRollno());
		ps.setString(2, marksheetdto.getName());
		ps.setInt(3, marksheetdto.getChemistry());
		ps.setInt(4, marksheetdto.getPhysics());
		ps.setInt(5, marksheetdto.getMaths());
		ps.executeUpdate();
		System.out.println("the data is inserted");
		con.close();

	}

	public void delete(MarksheetDTO marksheetdto) throws Exception {
		ps = con.prepareStatement("delete from marksheet where rollno=?");
		ps.setInt(1, marksheetdto.getRollno());
		ps.executeUpdate();
		System.out.println("the data is deleted");
		con.close();
	}

	public void update(MarksheetDTO marksheetdto) throws Exception {
		ps = con
				.prepareStatement("update  marksheet set  name=?,chemistry=?,physics=?,maths=? where rollno=?");
		ps.setInt(5, marksheetdto.getRollno());
		ps.setString(1, marksheetdto.getName());

		ps.setInt(2, marksheetdto.getChemistry());

		ps.setInt(3, marksheetdto.getPhysics());

		ps.setInt(4, marksheetdto.getMaths());
		ps.executeUpdate();
		System.out.println("the data is updated");
		con.close();

	}

	public MarksheetDTO get(MarksheetDTO marksheetdto) throws Exception {
		ps=con.prepareStatement("select  * from marksheet where rollno=?");
		ps.setInt(1,marksheetdto.getRollno());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			marksheetdto.setRollno(rs.getInt(1));
			marksheetdto.setName(rs.getString(2));
			marksheetdto.setChemistry(rs.getInt(3));
			marksheetdto.setPhysics(rs.getInt(4));
			marksheetdto.setMaths(rs.getInt(5));

		}
		return marksheetdto;
	}

	public List getlist() throws Exception {
		List list = new ArrayList();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery("select * from marksheet");

		while (rs.next()) {
			MarksheetDTO marksheetdto = new MarksheetDTO();
			marksheetdto.setRollno(rs.getInt(1));
			marksheetdto.setName(rs.getString(2));
			marksheetdto.setChemistry(rs.getInt(3));
			marksheetdto.setPhysics(rs.getInt(4));
			marksheetdto.setMaths(rs.getInt(5));

			list.add(marksheetdto);
		}

		System.out.println("successfull list");
		return list;

	}

	public ArrayList Search(MarksheetDTO marksheetdto) throws Exception {
		ps = con.prepareStatement("select * from marksheet where name like ?");
		ps.setString(1, marksheetdto.getName()+"%");
		ResultSet rs = ps.executeQuery();
		ArrayList list = new ArrayList();
		marksheetdto=null;
		while (rs.next()) {
			marksheetdto = new MarksheetDTO();
			marksheetdto.setRollno(rs.getInt(1));
			marksheetdto.setName(rs.getString(2));
			marksheetdto.setChemistry(rs.getInt(3));
			marksheetdto.setPhysics(rs.getInt(4));
			marksheetdto.setMaths(rs.getInt(5));

			list.add(marksheetdto);
		}

		System.out.println("successfull list");
		return list;
	}

}
