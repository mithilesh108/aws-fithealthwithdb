package com.fithealth.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/allPatientDetails" })
public class AllPatientDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AllPatientDetailServlet  service method start");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean flag = false;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("SELECT * FROM patient");
			rs = pstmt.executeQuery();
			List<PatientDetails> l = new ArrayList<>();
			while(rs.next()) {
				PatientDetails pd = new PatientDetails();
				pd.setId(rs.getInt("patient_no"));
				pd.setFullName(rs.getString("patient_nm"));
				pd.setAge(rs.getInt("age"));
				pd.setEmailAddress(rs.getString("email_address"));
				pd.setMobileNo(rs.getString("mobile_nbr"));
				pd.setGender(rs.getString("gender"));
				l.add(pd);
			}
				req.setAttribute("patientDetails", l);
				req.getRequestDispatcher("/patient-details.jsp").forward(req, resp);
			flag = true;
		} catch (SQLException | ClassNotFoundException e) {
			flag = false;
			throw new ServletException(e);
		} finally {
			try {
				if (con != null) {
					if (flag) {

						con.commit();

					} else {
						con.rollback();
					}
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("AllPatientDetailServlet  service method end");
	}

	private Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
		Connection con = null;
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));

		Class.forName(props.getProperty("db.driverClassName"));
		con = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"),
				props.getProperty("db.password"));
		con.setAutoCommit(false);
		return con;
	}

}
