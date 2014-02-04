package com.vaannila.web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.CouncilDAO;
import com.vaannila.dao.CouncilImpl;
import com.vaannila.domain.Council;
import com.vaannila.domain.Country;

public class CouncilAction extends ActionSupport implements ModelDriven<Council>{

	private Council council= new Council();
	private CouncilDAO councilDAO=new CouncilImpl();
	private List<Council> councilList=new ArrayList<Council>();
	
	@Override
	public Council getModel() {
		// TODO Auto-generated method stub
		return council;
	}

	public String saveOrUpdate()
	{	
		if(council.getCouncilName()==null){
			return SUCCESS;	
		}else{
			councilDAO.saveOrUpdateCouncil(council);
			return SUCCESS;
		}
	}
	
	public String list(){
		councilList=councilDAO.listCouncil();
		return SUCCESS;
	}

	public String edit(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		council = councilDAO.listCouncilById(Integer.parseInt(request.getParameter("councilId")));
		councilList=councilDAO.listCouncil();
		return SUCCESS;
	}
	
	public String delete(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		councilDAO.deleteCouncil(Integer.parseInt(request.getParameter("councilId")));
		councilList=councilDAO.listCouncil();
		return SUCCESS;
	}
	
	public String search(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		council=councilDAO.selectCouncil(request.getParameter("councilName"));
		System.out.println(council.getEmail());
		return SUCCESS;
	}
	
	public void run() {
		 
		String csvFile = "/Users/mkyong/Downloads/GeoIPCountryWhois.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] country = line.split(cvsSplitBy);
	 
				System.out.println("Country [code= " + country[4] 
	                                 + " , name=" + country[5] + "]");
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
	  }
	
	public Council getCouncil() {
		return council;
	}

	public void setCouncil(Council council) {
		this.council = council;
	}

	public CouncilDAO getCouncilDAO() {
		return councilDAO;
	}

	public void setCouncilDAO(CouncilDAO councilDAO) {
		this.councilDAO = councilDAO;
	}

	public List<Council> getCouncilList() {
		return councilList;
	}

	public void setCouncilList(List<Council> councilList) {
		this.councilList = councilList;
	}
	
	
}