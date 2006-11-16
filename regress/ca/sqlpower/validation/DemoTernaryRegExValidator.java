package ca.sqlpower.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A non-general demo Validator that uses RegEx matching and
 * looks for strings like Pass, Warn or Fail.
 */
public class DemoTernaryRegExValidator implements Validator {

    private Pattern pattern;
    private String message;

    /**
     * Construct a Validator for regexes
     * @param pattern The regex pattern
     *
     */
    public DemoTernaryRegExValidator() {
        super();
        String pattern = "^(OK|WARN|FAIL)$";
        this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        this.message = "Must match " + pattern;
    }

    public String getMessage() {
        return message;
    }

    public Status validate(Object contents) {
        String value = (String)contents;
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            String match = matcher.group(1);
            return Status.valueOf(match.toUpperCase());
        } else
            return Status.FAIL;
    }

}
