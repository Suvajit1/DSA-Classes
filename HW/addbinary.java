public class addbinary {
    static String carry = "0";
    static String str = "";

    public static String addBinary(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) {
            if (carry.equals("1")) {
                str = "1" + str;
            }
            return str;
        } else if (b.isEmpty() && !a.isEmpty()) {
            String s1 = "" + a.charAt(a.length() - 1);
            if (carry.equals("0")) {
                str = s1 + str;
            } else if (carry.equals("1") && s1.equals("1")) {
                str = "0" + str;

            } else {
                str = "1" + str;
                carry = "0";
            }
            return addBinary(a.substring(0, a.length() - 1), "");

        } else if (a.isEmpty() && !b.isEmpty()) {
            return addBinary(b, a);
        } else {
            String s1 = "" + a.charAt(a.length() - 1);
            String s2 = "" + b.charAt(b.length() - 1);
            if (s1.equals("1") && s2.equals("1")) {
                if (carry.equals("0")) {
                    carry = "1";
                    str = "0" + str;
                } else {
                    carry = "1";
                    str = "1" + str;
                }
            } else if (s1.equals("1") || s2.equals("1")) {
                if (carry == "0") {
                    str = "1" + str;
                } else {
                    str = "0" + str;
                    carry = "1";
                }
            } else {
                if (carry.equals("1")) {
                    str = "1" + str;
                }
                carry = "0";
            }
            return addBinary(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));

        }

    }

    public static void main(String[] args) {
        System.out.println(addBinary("1011", "101"));
    }

}
