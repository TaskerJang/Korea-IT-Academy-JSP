package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GogekDAO;
import vo.GogekVO;

/**
 * Servlet implementation class GogekInsertAction
 */
@WebServlet("/insert_form.do")
public class GogekInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post로 전달받은 정보의 한글이 깨지는 것을 방지
		request.setCharacterEncoding("utf-8");
		
		//insert_form.do? name= 홍길동&addr= 서울시 &jumin=9011111...&godam=10;
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String jumin = request.getParameter("jumin");
		int godam = Integer.parseInt(request.getParameter("godam"));
		
		//정보들을 vo로 묶어서 DAO에 전달
		GogekVO vo = new GogekVO();
		vo.setGoname(name);
		vo.setGoaddr(addr);
		vo.setGojumin(jumin);
		vo.setGodam(godam);
		
		GogekDAO.getInstance().insert(vo);
		
		response.sendRedirect("gogeklist.do");
	}

}
