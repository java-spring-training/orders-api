package api.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController {


    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error HandlerErrorNotFoundUrl() {
        return new Error(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                "API_NOT_FOUND");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
