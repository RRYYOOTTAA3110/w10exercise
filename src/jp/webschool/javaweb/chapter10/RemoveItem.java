package jp.webschool.javaweb.chapter10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveItem
 */
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String item = request.getParameter("item");

		HttpSession session = request.getSession(false);

		//商品カートから削除
		String[] items = (String[])session.getAttribute("item");
		int i = 0;
		for(int j = 0; items[j] != null; j++){
			if(!items[j].equals(item)){
				items[i] = items[j];
				i++;
			}
		}
		items[i] = null;
		session.setAttribute("item", items);

		response.sendRedirect("/w10exercise/cart.jsp");

	}

}
