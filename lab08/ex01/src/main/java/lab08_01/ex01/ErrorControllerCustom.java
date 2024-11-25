package lab08_01.ex01;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorControllerCustom implements ErrorController {
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String handleError(HttpServletRequest request, Model model) {
        String error = request.getParameter("error");
        int httpErrorCode = getErr(request);

        switch (httpErrorCode) {
            case 400: {
                error = "Bad Request";
                break;
            }
            case 401: {
                error = "Unauthorized";
                break;
            }
            case 403: {
                error = "Forbidden";
                break;
            }
            case 404: {
                error = "Not Found";
                break;
            }
            case 405: {
                error = "Method Not Allowed";
                break;
            }
            case 406: {
                error = "Not Acceptable";
                break;
            }
            case 500: {
                error = "Internal Server Error";
                break;
            }
            case 503: {
                error = "Service Unavailable";
                break;
            }
            case 504: {
                error = "Gateway Timeout";
                break;
            }
            default: {
                error = "Internal Server Error";
                break;
            }
        }
        model.addAttribute("errorMsg", error);
        return "errorPage";
    }
    private int getErr(HttpServletRequest request) {
        Object status = request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return Integer.parseInt(status.toString());
        }
        return 0;
    }
}
