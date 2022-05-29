package com.highradius.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HashMap<Object,Object> Response = new HashMap<Object, Object>();
			int sl_no = Integer.parseInt(request.getParameter("sl_no"));
			String business_code = request.getParameter("business_code");
			String cust_number = request.getParameter("cust_number");
			String clear_date = request.getParameter("clear_date");
			String buisness_year = request.getParameter("buisness_year");
			String doc_id = request.getParameter("doc_id");
			String posting_date = request.getParameter("posting_date");
			String document_create_date = request.getParameter("document_create_date");
            String document_create_date1 = request.getParameter("document_create_date1");
			String due_in_date = request.getParameter("due_in_date");
			String invoice_currency = request.getParameter("invoice_currency");
			String document_type = request.getParameter("document_type");
			String posting_id = request.getParameter("posting_id");
			String area_business = request.getParameter("area_business");
            String total_open_amount = request.getParameter("total_open_amount");
			String baseline_create_date = request.getParameter("baseline_create_date");
			String cust_payment_terms = request.getParameter("cust_payment_terms");
			String invoice_id = request.getParameter("invoice_id");
			int isOpen = Integer.parseInt(request.getParameter("isOpen"));
			String aging_bucket = request.getParameter("aging_bucket");
            int is_deleted = Integer.parseInt(request.getParameter("is_deleted"));


			

            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","");
			String sql = "UPDATE winter_internship set business_code=?,cust_number=?,clear_date=?,buisness_year=?,doc_id=?,posting_date=?,document_create_date=?,document_create_date1=?,due_in_date=?,invoice_currency=?,document_type=?,posting_id=?,area_business=?,total_open_amount=?,baseline_create_date=?,cust_payment_terms=?,invoice_id=?,isOpen=?,aging_bucket=?,is_deleted=? where sl_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, business_code);
            ps.setString(2, cust_number);
            ps.setString(3, clear_date);
            ps.setString(4, buisness_year);
            ps.setString(5, doc_id);
            ps.setString(6, posting_date);
            ps.setString(7, document_create_date);
            ps.setString(8, document_create_date1);
            ps.setString(9, due_in_date);
            ps.setString(10, invoice_currency);
            ps.setString(11, document_type);
            ps.setString(12, posting_id);
            ps.setString(13, area_business);
            ps.setString(14, total_open_amount);
            ps.setString(15, baseline_create_date);
            ps.setString(16, cust_payment_terms);
            ps.setString(17, invoice_id);
            ps.setInt(18, isOpen);
            ps.setString(19, aging_bucket);
            ps.setInt(20, is_deleted);
            ps.setInt(21, sl_no);


            if(ps.executeUpdate() > 0) {
            	Response.put("update", true);
            }
            else {
            	Response.put("update", false);
            }
    		Gson gson = new Gson();
    		String JSONresponse = gson.toJson(Response);
    		response.setHeader("Access-Control-Allow-Origin", "*");
    		response.getWriter().append(JSONresponse);
        } catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
