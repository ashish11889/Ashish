package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dto.LoginDTO;
import com.dto.MarksheetDTO;
import com.service.LoginService;
import com.service.MarksheetService;

public class MarksheetTest
{
	public static void main(String[] args) throws Exception{
		
	
	MarksheetDTO marksheetdto=new MarksheetDTO();
	/*LoginDTO loginDTO=new LoginDTO();
	LoginService loginService=new LoginService();
	loginDTO.setUsername("raj");
	loginDTO.setPassword("raj");
	loginService.checkLogin(loginDTO);*/
	marksheetdto.setRollno(98);
	MarksheetService marksheetservice=new MarksheetService();
	marksheetdto.setName("ggg");
	marksheetdto.setChemistry(99);
	marksheetdto.setPhysics(89);
	marksheetdto.setMaths(67);
	marksheetservice.add(marksheetdto);
	
	//MarksheetService marksheetservice=new MarksheetService();
	/*marksheetdto.setRollno(56);
	marksheetservice.delete(marksheetdto);*/
	/*MarksheetService marksheetservice=new MarksheetService();
	marksheetdto.setRollno(0);
	marksheetdto.setName("aditya");
	marksheetdto.setChemistry(89);
	marksheetdto.setPhysics(99);
	marksheetdto.setMaths(90);
	marksheetservice.update(marksheetdto);*/
	/*MarksheetService marksheetservice=new MarksheetService();
	marksheetdto.setRollno(2);
	marksheetdto=marksheetservice.get(marksheetdto);
	System.out.print(marksheetdto.getRollno()+"\t");
	System.out.print(marksheetdto.getName()+"\t");
	System.out.print(marksheetdto.getChemistry()+"\t");
	System.out.print(marksheetdto.getPhysics()+"\t");
	System.out.println(marksheetdto.getMaths()+"\t");
	*/
	/*marksheetdto.setName("");
	MarksheetService marksheetService=new MarksheetService();
	List list=new ArrayList();
	list=marksheetService.Search(marksheetdto);
	Iterator it =list.iterator();
	while(it.hasNext())
	{
		marksheetdto=(MarksheetDTO)it.next();
	System.out.print(marksheetdto.getRollno()+"\t");
	System.out.print(marksheetdto.getName()+"\t");
	System.out.print(marksheetdto.getChemistry()+"\t");
	System.out.print(marksheetdto.getPhysics()+"\t");
	System.out.println(marksheetdto.getMaths()+"\t");
	
	}*/
	/*MarksheetService marksheetService=new MarksheetService();
	List list=new ArrayList();
	marksheetdto.setName("bl");
	list=marksheetService.Search(marksheetdto);
	System.out.println("List size "+list.size());
	Iterator it=list.iterator();
	while(it.hasNext())
	{
		marksheetdto=(MarksheetDTO)it.next();
		System.out.println(marksheetdto.getRollno()+"\t");
		System.out.println(marksheetdto.getName()+"\t");
		System.out.println(marksheetdto.getChemistry()+"\t");
		System.out.println(marksheetdto.getPhysics()+"\t");
		System.out.println(marksheetdto.getMaths()+"\t");
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}
	
	
	
	
	


	