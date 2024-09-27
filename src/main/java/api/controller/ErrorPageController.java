package api.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController {

    @RequestMapping("/404")
    public Error HandlerErrorNotFoundUrl() {
        return new Error(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                "Entry Api with wrong Url");
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}