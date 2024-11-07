package sampleServlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form3")
public class form3 extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    req.setCharacterEncoding("utf-8");

    String age = req.getParameter("age");
    if(age.equals("child")){
      age = "18歳未満";
    } else {
      age = "18以上";
    }
    req.setAttribute("age", age);

    String langs = "";
    String[] lang = req.getParameterValues("lang");
    for(int i = 0; i < lang.length; i++){
      langs = langs + lang[i] + " ";
    }
    req.setAttribute("langs", langs);
    
    RequestDispatcher rd = req.getRequestDispatcher("/form3.jsp");
    rd.forward(req, res);
  }
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    doPost(req, res);
  }
}





