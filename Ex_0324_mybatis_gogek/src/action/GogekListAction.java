package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GogekDAO;
import vo.GogekVO;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/gogeklist.do")
public class GogekListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//고객 목록 조회
		List<GogekVO> list = GogekDAO.getInstance().selectGogek();
		
		//받아온 list를 request영역에 바인딩
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("gogek_list.jsp");
		disp.forward(request, response);//포워딩
		
	}

}
