package net.manager.servlets;

import net.manager.dbmodels.DBManager;
import net.manager.modelmanagers.CountryManager;
import net.manager.models.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class GetCountryData
 */
@WebServlet("/getcountrydata.do")
public class GetCountryData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryData() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//make sure user is logged in
		String target = "";
		HttpSession s = request.getSession();

		//get the countries using models
		if (getServletContext().getAttribute("WorldDBManager") != null)
		{
			DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
			CountryManager cm = new CountryManager();
			//build a list of country objects using the query
			ArrayList<Country> allCountries = cm.getCountryData(dbm);
			s.setAttribute("countryData", allCountries);
			//
			target = "listCountries.jsp";
		}
		else
		{
			target = "login.jsp";
		}
		response.sendRedirect(target);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
