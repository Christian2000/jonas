import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
    private static final Server server = new Server(8080);

    @Test
    public void run() throws IOException {
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setDescriptor("WEB-INF/web.xml");
        webAppContext.setResourceBase(".");
        webAppContext.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");
        webAppContext.setContextPath("/jonas");

        server.setHandler(webAppContext);
        try {
            server.start();
            System.out.println("Server running");
        } catch (Exception e) {
            System.out.println("Failed to start server:");
            e.printStackTrace();
        }
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press enter to shut down server.");
        br.readLine();
    }
}
