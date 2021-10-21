package ua.lpnu;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

public class EmailValidator {
    private static final String[] SPECIAL_CHARACTERS_FOR_USERNAME = new String[] {
            "..", "__", ",", "/", "<", ">", "?", ";", ":", "\"", "\"",
            "{", "}", "[", "]", "|", "\\", "!", "@", "#", "$", "%", "^",
            "&", "*", "(", ")", "+", "=", "~", "`" };

    private static final char[] SPECIAL_CHARACTERS_WITH_NUMBERS = new char[] {
            '.', ',', '/', '<', '>', '?', ';', ':', '\'', '\"', '{',
            '}', '[', ']', '|', '\\', '!', '@', '#', '$', '%', '^', '&',
            '*', '(', ')', '-', '_', '+', '=', '~', '`', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '0' };

    public static boolean isEmailValid(String email) {
        String[] emailChunks = StringUtils
                .splitByWholeSeparatorPreserveAllTokens(email,
                        "@");

        if (emailChunks.length != 2 || isEmailUserNameInvalid(emailChunks[0])
                || StringUtils.isBlank(emailChunks[1])) {
            return false;
        }

        String[] domainNames = StringUtils
                .splitByWholeSeparatorPreserveAllTokens(emailChunks[1],
                        ".");
        if (domainNames.length < 2) {
            return false;
        }

        int topLevelDomainNameIndex = domainNames.length - 1;
        if (isTopLevelDomainNameInvalid(domainNames[topLevelDomainNameIndex])) {
            return false;
        }

        domainNames = ArrayUtils.remove(domainNames, topLevelDomainNameIndex);

        return (isDomainNameValid(domainNames));
    }

    private static boolean isEmailUserNameInvalid(String emailUserName) {
        return (StringUtils.isBlank(emailUserName) || StringUtils.containsAny(
                emailUserName, SPECIAL_CHARACTERS_FOR_USERNAME));
    }

    private static boolean isTopLevelDomainNameInvalid(String topLevelDomain) {
        return (StringUtils.isBlank(topLevelDomain) || StringUtils.containsAny(
                topLevelDomain, SPECIAL_CHARACTERS_WITH_NUMBERS));
    }

    private static boolean isDomainNameValid(String[] domainNames) {
        for (String domainName : domainNames) {
            if ((StringUtils.isBlank(domainName) || StringUtils.containsAny(
                    domainName, SPECIAL_CHARACTERS_WITH_NUMBERS))) {
                return false;
            }
        }
        return true;
    }
}
