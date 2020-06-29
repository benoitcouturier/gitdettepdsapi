package com.pds.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TestDAOImpl;
import Entities.Frequentation;
import serviceRest.ControlerFreq;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TestDAOImpl dao= new TestDAOImpl();
		Integer an= Integer.parseInt(request.getParameter("annee"));
		int annee=an.intValue()	;
		Integer mo = Integer.parseInt(request.getParameter("mois"));
		int mois = mo.intValue();
		
		ControlerFreq controlerfreq=new ControlerFreq();
		ArrayList<Frequentation> freq=controlerfreq.getAnnalyse(annee, mois);
		request.setAttribute("freq", freq);
		this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
	}

}
