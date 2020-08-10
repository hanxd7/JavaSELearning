public class TestStringBuilder {
    public static void main(String[] args) {
        String str;
        //可变的字符序列 char value[];
        StringBuilder sb = new StringBuilder("abcdefg");
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
        sb.setCharAt(1,'B');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder();
        for (int i=0;i<26;i++){
            char c = (char) ('a'+i);
            sb1.append(c );
        }
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
        sb1.setCharAt(0,'A');
        System.out.println(sb1);
        sb1.insert(1,'a');//return this;
        System.out.println(sb1);
        sb1.delete(0,1);
        System.out.println(sb1);
    }
}
