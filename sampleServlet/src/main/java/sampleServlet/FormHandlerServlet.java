package sampleServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formHandler")
public class FormHandlerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームから送信されたデータを取得
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // レスポンスのコンテンツタイプを設定
        response.setContentType("text/html; charset=UTF-8");

        // レスポンスの出力ストリームを取得してHTMLを出力
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Form Submission Result</title></head>");
        out.println("<body>");
        out.println("<h2>Submitted Data</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
