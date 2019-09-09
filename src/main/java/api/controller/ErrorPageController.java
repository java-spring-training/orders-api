//package api.controller;
//
//import org.apache.log4j.Logger;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//public class ErrorPageController implements ErrorController {
//
//    private Logger log = Logger.getLogger(ErrorPageController.class);
//
//    @RequestMapping("/error")
//    public Error handleError(HttpServletRequest request, Throwable throwable) {
//
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        if (status != null) {
//            int statusCode = Integer.parseInt(status.toString());
//            if(statusCode == HttpStatus.NOT_FOUND.value()) {
//                log.error("URL is not found");
//                return new Error(HttpStatus.NOT_FOUND.value(),
//                        HttpStatus.NOT_FOUND.getReasonPhrase(), "URL is not found");
//            }
//        }
//        final int errorStatusCode = (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//        return new Error(errorStatusCode, exception.getMessage(), exception.getCause().getLocalizedMessage());
//    }
//
//    @Override
//    public String getErrorPath() {
//
//        return "/error";
//    }
//}
