package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class uploadController
 */
@WebServlet("/uploadController")
public class uploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public uploadController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		System.out.println("doget method called.");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost method called.");

		String path = "H:\\eclipse-workspace\\File_upload\\WebContent\\Files" + File.separator;
		RequestDispatcher dispatcher = null;

		if (ServletFileUpload.isMultipartContent(request)) {
			try {

				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				System.out.println("List >>");
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						System.out.println("items >>");

						String name = item.getName(); // getting the name of the uploaded file
						System.out.println("name=" + name);
						String new_name = name.substring(0, name.lastIndexOf(".")); // extracting only name portion

						String ext = name.substring(name.lastIndexOf(".")); // extracting extension of file
						System.out.println("name : " + new_name + ", Ext:" + ext);
						item.write(new File(path + new_name + ext)); // creating file on the mention path

						
						request.setAttribute("status", "done");
						
					}
				}
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				request.setAttribute("status", "error");
				
				request.setAttribute("message", "File Upload Failed due to " + ex);
				ex.printStackTrace();
			}
		}
		System.out.println("Done");
		dispatcher = request.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);
	}

}
