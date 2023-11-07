package phoenix.partyquest.domain.toyarticle.myexception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class ArticleException extends  RuntimeException {

    public final Map<String, String> validations = new HashMap<>();

    public abstract int getStatus();
    public ArticleException(String message) {
        super(message);
    }

    public ArticleException(String message, Throwable cause) {
        super(message, cause);
    }

    public void addValidations(String fieldName, String message) {
        validations.put(fieldName, message);
    }

}
