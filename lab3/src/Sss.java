import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
public class Sss extends HttpServlet implements Servlet {
	
protected void service(HttpServletRequest rq, HttpServletResponse rs)
throws ServletException, IOException {
HttpClient hc = new HttpClient(); 
PostMethod pm = new PostMethod("http://ba3eb090ce0b.ngrok.io"
+ rq.getContextPath() + "/PostExample?press=OK"); 
NameValuePair[] parms = { new NameValuePair("firstname", "hell"),
new NameValuePair("lastname", "ad"), 
new NameValuePair("sex", "male") }; 
pm.addParameters(parms); 
hc.executeMethod(pm); 
if (pm.getStatusCode() == HttpStatus.SC_OK) { 
InOutServlet inout = new InOutServlet(rs.getOutputStream(), 
pm.getResponseBodyAsStream()); 
inout.perform(); 
} else 
System.out.println("Sss:service:getStatusCode()=" 
+ pm.getStatusCode()); 
} 
}