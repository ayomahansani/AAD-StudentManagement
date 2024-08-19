package lk.ijse.stumanagement.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*") // context path ekata passe oona ekak danna puluvan vena vidiyata thama wild card mappping danne , mokada context path eka saha servlet path eka madde thama filter eka thiyenna one
public class CORSFilter extends HttpFilter {


    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        var origin = req.getHeader("Origin"); // Origin header eke thiyena value eka gannava
        var configuredOrigin = getServletContext().getInitParameter("origin");

        // CORS policy eka resolve karanna thama me configurations tika thiyenne
        if(origin.contains(configuredOrigin)){

            res.setHeader("Access-Control-Allow-Origin", origin);

            res.setHeader("Access-Control-Allow-Origin", "*");

            // request eka kiyanava server eka pathe thiyena methods allow karanna access one kiayala
            res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

            // request eka kiyanava server eka pathe thiyena content-type header eka access karanna one kiyala
            res.setHeader("Access-Control-Allow-Headers", "Content-Type");

            res.setHeader("Access-Control-Expose-Headers", "Content-Type");
        }

        // filter chain eka issarahata aran aynna one nisa
        chain.doFilter(req, res);

    }
}
