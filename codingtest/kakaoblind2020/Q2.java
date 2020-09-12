public class Q2 {
    public String solution(final String new_id) {
        String result = new_id;
        result = convertLowercase(result);
        result = removeLetter(result);
        result = mergeDot(result);
        result = trimDot(result);
        result = convertBlank(result, "a");
        result = validateOverLength(result);
        result = validateUnderLength(result);


        return result;
    }

    private String convertLowercase(String s) {
        return s.toLowerCase();
    }

    private String removeLetter(String s) {
        s = s.replaceAll("[^a-z0-9._-]", "");
        return s;
    }

    private String mergeDot(String s) {
        return s.replaceAll("\\.{2,}", ".");
    }

    private String trimDot(String s) {
        if (s.length() < 2) {
            return "";
        }

        int startIdx = s.charAt(0) == '.' ? 1 : 0;
        int endIdx = s.charAt(s.length() - 1) == '.' ? s.length() - 1 : s.length();
        return s.substring(startIdx, endIdx);
    }

    private String convertBlank(String s, String replacedString) {
        return s.isEmpty() ? replacedString : s;
    }

    private String validateOverLength(String s) {
        final int tmpMaxLengthValidation = 15;
        if (s.length() <= tmpMaxLengthValidation) {
            return s;
        }

        int endIdx = tmpMaxLengthValidation;
        if (s.charAt(tmpMaxLengthValidation - 1) == '.') {
            endIdx--;
        }

        return s.substring(0, tmpMaxLengthValidation);
    }

    private String validateUnderLength(String s) {
        final int tmpLengthMinValidation = 2;
        if (s.length() > tmpLengthMinValidation) {
            return s;
        }

        char lastLetter = s.charAt(s.length() - 1);
        for (int i = s.length(); i < tmpLengthMinValidation + 1; i++) {
            s += lastLetter;
        }

        return s;
    }
}
