package d100._5day;

public class BinarySumLeet {
    static String addBinary(String a, String b) {
        if (a==null || a=="0" || a.isEmpty())    return b;
        if (b==null || b=="0" || b.isEmpty())    return a;
        if (a.length()>b.length()){
            int li = a.length()-1;
            int si = b.length()-1;
            return (add(new StringBuilder(a), li, b, si, '0')).toString();
        } else {
            int li = b.length()-1;
            int si = a.length()-1;
            return (add(new StringBuilder(b), li, a, si, '0')).toString();
        }
    }

    static StringBuilder add(StringBuilder lString, int li, String sString, int si, char carry){
        char m = li<0?'0':lString.charAt(li);
        char n = si<0?'0':sString.charAt(si);
        if ((li<0 && si<0) || (si<0 && carry==48)) return carry==49?lString.insert(0, '1'):lString;
        switch (m+n+carry){
            case 147:
                lString.setCharAt(li, '1');
                carry = 49;
                break;
            case 146:
                lString.setCharAt(li, '0');
                carry = 49;
                break;
            case 145:
                lString.setCharAt(li, '1');
                carry = 48;
                break;
            case 144:
                lString.setCharAt(li, '0');
                carry = 48;
                break;
        }
        return add(lString, (li-1), sString, (si-1), carry);
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1001";
        System.out.println(addBinary(a, b));
    }
}
