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
 * Servlet implementation class SearchAction
 */
@WebServlet("/gogek_search.do")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//gogek_search.do?addr=서울시 마포구
		String search = "all";
		String addr = request.getParameter("addr");
		
		//.do? --> null
		//.do?addr= --> '', empty
		//정상적으로 파라미터가 전달된 경우
		if(addr != null && !addr.isEmpty()) {
			search = addr;
		}
		
		
		//목록 가져오기
		List<GogekVO> list =null;
		
		if( search.equals("all") ) {
			 list = GogekDAO.getInstance().selectGogek();
		}else {list = GogekDAO.getInstance().selectGogek(search);}
		
		//list객체 바인딩 및 포워딩
		request.setAttribute("list",list);
		RequestDispatcher disp= 
				request.getRequestDispatcher("gogek_list.jsp");
		disp.forward(request, response);
		
	}

}
