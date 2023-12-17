package ua.knu.vlasenko;
import ua.knu.vlasenko.Dealer;
import ua.knu.vlasenko.DealerSQL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DealerServlet extends HttpServlet {
    // Оброблювач HTTP-методу Get()
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	response.setContentType("text / html; charset = UTF-8");
	try (PrintWriter out = response.getWriter();
            Dealer dealer = DealerSQL.connect();
	    ) {
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title> Таблиця марок та виробників </ title>");
	    out.println("<link href = \" defcss.css \"" +
			"Rel = \" stylesheet \"type = \" text / css \">");
	    out.println("</ head>");
	    out.println("<body>");
	    out.println("<h1> Таблиця марок та виробників </h1>");
	    out.println("<table>");
	    out.println("<tr>");
	    out.println("<th> марка </th><th> виробник </th>");
	    out.println("</tr>");

	    for (String whole: dealer.getModelList()) {
		String[] pair = whole.split(" ");
		out.println("<tr>");
		out.println("<td>" + pair[0] + "</td>");
		out.println("<td>" + pair[1] + "</td>");
		out.println("</tr>");
	    }
	    out.println("</table>");
	    out.println("</body>");
	    out.println("</html>");
	}
    }
}

public String getServletInfo() {
    return "Таблиця марок та виробників";
}
