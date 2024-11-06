package sampleServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	//　セッションオブジェクトの生成or取得
    HttpSession session = req.getSession(true);
    // セッションオブジェクトからcartを取得
    ArrayList<String> booklist = (ArrayList<String>)session.getAttribute("cart");
    
    if(booklist == null){
      booklist = new ArrayList<String>();  // 初回アクセス
    } else {
      req.setCharacterEncoding("utf-8");   // 2回目以降
      String book = req.getParameter("book");
      booklist.add(book);
    }
    session.setAttribute("cart", booklist);
    
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();
    out.println("<html><head>");
    out.println("<title>注文画面</title>");
    out.println("</head><body>");
    out.println("<h2>商品を選択してください</h2>");

    // 修正した部分
    out.println("<form action=\"" + req.getContextPath() + "/session\" method=\"post\">");

    out.println("<select name=\"book\" size=\"1\">");
    out.println("<option value=\"超絶わかるJava\">超絶わかるJava</option>");
    out.println("<option value=\"小学生からはじめるJava\">小学生からはじめるJava</option>");
    out.println("<option value=\"Oracle試験100%合格本\">Oracle試験100%合格本</option>");
    out.println("</select><input type=\"submit\" value=\"追加\" /></form>");
    out.println("<h2>カートの中身</h2>");

    for(int i = 0; i < booklist.size(); i++){
      out.println(booklist.get(i) + "<br/>");
    }
    
    out.println("</body></html>");
  }
  
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    doPost(req, res);
  }
}
































