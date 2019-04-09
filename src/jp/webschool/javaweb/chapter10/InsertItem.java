package jp.webschool.javaweb.chapter10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//セッションを使用するためのインターフェース
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertItem
 */
public class InsertItem extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String item = request.getParameter("item");

		//セッションを取得
		HttpSession session = request.getSession(true);
		String[] items = (String[])session.getAttribute("item");

		//商品をカートに追加
		if(items != null && items[0] != null){
			boolean duplication = false;
			int i = 0;
			for(; items[i] != null; i++){
				if(items[i].equals(item)){
					duplication = true;
				}
			}
			if(!duplication){
				items[i] = item;
			}
		}else{
			items = new String[5];
			items[0] = item;
		}
		session.setAttribute("item", items);

		response.sendRedirect("/w10exercise/cart.jsp");




	}


}
