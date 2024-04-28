package servletapi;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import testeweb2.APIClient;

import java.io.IOException;
import javax.servlet.*;

/**
 * Servlet implementation class APIServlet
 */
public class APIServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
        url do servlet: servletapi.APIServlet.doGet(HttpServletRequest, HttpServletResponse)
	 * http://makeup-api.herokuapp.com/api/v1/products.json

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aqui você irá implementar a lógica para obter os dados da API e enviar como resposta
        String apiUrl = "http://makeup-api.herokuapp.com/api/v1/products.json"; // URL da sua API
        
        String responseData = APIClient.fetchDataFromAPI(apiUrl); // Utilize a classe APIClient para buscar os dados
       
//        
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
//        dispatcher.forward(request, response);
        
        
        response.setContentType("application/json");
        response.getWriter().write(responseData);
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
