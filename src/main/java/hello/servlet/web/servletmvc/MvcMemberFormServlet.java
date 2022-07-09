package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // WEB-INF 하위의 자원들은 외부에서 호출 불가능 (컨트롤러를 거쳐야함!)
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // 서버 내부에서 다시 호출 발생
        // 리다이렉트 : 클라이언트에 응답이 나갔다가 재요청 (클라이언트가 인지 가능, URL 경로가 실제로 변경)
        // forward : 서버 내부에서 일어나는 호출, 클라이언트 인지 불가
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
}
