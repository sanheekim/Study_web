package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet implements Servlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject totalObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날센돌이");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "27");
		memberInfo.put("gender", "여성");
		memberInfo.put("nickname", "제왕");
		membersArray.add(memberInfo);
		totalObject.put("members", membersArray);
		
		JSONArray bookArray = new JSONArray();
		JSONObject bookInfo = new JSONObject();
		bookInfo.put("title","초보자를 위한 자바 프로그래밍");
		bookInfo.put("writer","이병승");
		bookInfo.put("price","30000");
		bookInfo.put("genre","IT");
		bookInfo.put("image","http://localhost:8787/pro16/image/image1.JPG");
		bookArray.add(bookInfo);
		
		bookInfo = new JSONObject();
		bookInfo.put("title","모두의 파이썬");
		bookInfo.put("writer","이승찬");
		bookInfo.put("price","12000");
		bookInfo.put("genre","IT");
		bookInfo.put("image","http://localhost:8787/pro16/image/image2.JPG");
		bookArray.add(bookInfo);
		
		totalObject.put("books", bookArray);
		String jsonInfo = totalObject.toJSONString();
		System.out.println(jsonInfo);
		writer.print(jsonInfo);
		
	}

}
