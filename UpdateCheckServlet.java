import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRITAM DEY
 */
@WebServlet(urlPatterns = {"/UpdateCheckServlet"})
public class UpdateCheckServlet extends HttpServlet {

    private static final String UPDATE_LINK = "https://drive.usercontent.google.com/u/0/uc?id=1tdEK6J07fuhhpj8kcE3q6lguihe_JNKx&export=download";
    private static final boolean UPDATE = true;
    private static final String LICENSE_LINK = "https://drive.usercontent.google.com/u/0/uc?id=1BKLPgc2jFKNPhKC1AUudr3LNG76RCNYM&export=download";
    private static final boolean LICENSE_UPDATE = true;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildVersion = request.getParameter("buildVersion");
        String date = request.getParameter("date");
        String projectName = request.getParameter("projectName");
        String license = request.getParameter("license");
        
        // Printing the request parameters to the console
        System.out.println("Build Version: " + buildVersion);
        System.out.println("Date: " + date);
        System.out.println("Project Name: " + projectName);
        System.out.println("License: " + license);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        out.print("{");
        out.print("\"link\":\"" + UPDATE_LINK + "\",");
        out.print("\"update\":" + UPDATE + ",");
        out.print("\"licenseLink\":\"" + LICENSE_LINK + "\",");
        out.print("\"licenseUpdate\":" + LICENSE_UPDATE);
        out.print("}");

        out.flush();
    }
}
