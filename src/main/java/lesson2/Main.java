package lesson2;

public class Main {
    public static void main(String[] args) {

//        example1();
//        strAssembly();
//        strCompression();
        strComprVarTwo();
    }

    private static void strComprVarTwo() {
        String str = "aaaabbbcdd";
        System.out.println(str);
        if (str.length() == 0) {
            System.out.println("Строка пуста");
            return;
        }
        char[] array = str.toCharArray();
        int count = 1;
        char current = array[0];
        char next = 0;
        StringBuilder res = new StringBuilder(String.valueOf(current));
        for (int i = 0; i < str.length() - 1; i++) {
            current = array[i];
            next = array[i + 1];
            if (next != current) {
                if (count > 1) {
                    res.append(count);
                }
                res.append(next);
                count = 0;
            }
            count++;
        }
        if (count > 1) {
            res.append(count);
        }
        System.out.println(res);
    }

    private static void strCompression() {
        String str = "aaaabbbcdd";
        char[] charArr = str.toCharArray();
        char[] charArr2 = new char[charArr.length + 1];
        for (int i = 0; i < charArr.length; i++) {
            charArr2[i] = charArr[i];
        }
        charArr2 [charArr2.length - 1] = '.';
        int count = 1;
        int ind = 0;
        String strRes = "";
        while (ind < charArr2.length - 1) {
            if (charArr2[ind] == charArr2[ind + 1]){
                count ++;
            } else {
                if (count == 1){
                    strRes = strRes + Character.toString(charArr2[ind]);
                } else {
                    strRes = strRes + Character.toString(charArr2[ind]) + count;
                    count = 1;
                }
            }
            ind ++;
        }

        System.out.println(charArr);
        System.out.println(strRes);
    }

    private static void strAssembly() {
        int n = 10;
        char c1 = 'A';
        char c2 = 'B';
        String str1 = Character.toString(c1);
        String str2 = Character.toString(c2);
        String resultStr = "";
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                resultStr+=str1;
            } else {
                resultStr+=str2;
            }
        }
        System.out.println(resultStr);
    }

    private static void example1() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            sb.append(i).append(": ").append((char)i).append(System.lineSeparator());
            String strResult = sb.toString();
            System.out.println(strResult);
        }
    }
}
