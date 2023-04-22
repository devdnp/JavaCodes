package leet_code._daily_prob.apr23;
//12Apr
//#71
public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }
    public static String simplifyPath(String path) {
        char[] ans = new char[path.length()];
        int offset = 0;
        int index = path.length() - 1;
        int depthCounter = 0;
        boolean inWord = false;
        for (int i = path.length() - 1; i >= 0; i--) {
            if (path.charAt(i) == '/') {
                if (inWord && depthCounter > 0) {
                    depthCounter--;
                }
                inWord = false;
                while (i > 0 && path.charAt(i - 1) == '/') {
                    i--;
                    offset++;
                }
                if (index < path.length() - 1 && ans[index + 1] != '/') {
                    ans[index] = '/';
                    index--;
                } else {
                    offset++;
                }
            } else if (path.charAt(i) == '.' && !inWord) {
                if (path.charAt(i - 1) == '/') {
                    offset++;
                } else if (path.charAt(i - 1) == '.') {
                    if (path.charAt(i - 2) != '/') {
                        inWord = true;
                        i++;
                    } else {
                        depthCounter++;
                        offset += 2;
                        i--;
                    }
                } else {
                    inWord = true;
                    i++;
                }
            } else {
                inWord = true;
                if (depthCounter == 0) {
                    ans[index] = path.charAt(i);
                    index--;
                } else {
                    offset++;
                }
            }
        }
        String string = new String(ans, offset, path.length() - offset);
        if (string.length() == 0) {
            string = "/";
        }
        return string;
    }
}
