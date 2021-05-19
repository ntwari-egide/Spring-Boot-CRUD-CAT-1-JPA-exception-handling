package rw.ac.rca_student_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarksNotFoundException extends RuntimeException {
    public MarksNotFoundException(String message) {
        super(message);
    }
}
