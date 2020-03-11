package leetcode.medium.others;

public class ReadLine {
    //已知函数
    private static int count = 0;
    private String recv(){
        switch (++count){
            case 1: return "123\n45\n6789";
            case 2: return "abc";
            case 3: return "de\n";
            case 4: return "fg\n789";
            case 5: return "ok\nover";
            default:return "\n";
        }
    }

    /**
     * 请观察以上已知函数，每次调用时返回一段字符，其中有零，一或多个换行符
     * 请实现下面的read()函数，每次调用时返回一段String,要求下面main函数打印如下五行结果：

     123
     45
     6789abcde
     fg
     789ok

     *
     * read() 函数要把 recv() 来的一个字符流重新按照 \n 分割，每次调用 read()时返回一行，你的答案必须满足其他可能的情况。
     * 比如4行，5行，100行...
     */
    public static void main(String[] args){
        ReadLine readLine = new ReadLine();
        for (int i = 0; i <= 4; i++) {
            System.out.println(readLine.read());
        }
    }


    private String tmpStr = new String();
    private int pos = 0;
    private static final int BUFFER_SIZE = 1024;

    public String read(){
        tmpStr += recv();
        StringBuffer buffer = new StringBuffer();
        while (pos < tmpStr.length() && tmpStr.charAt(pos) != '\n') {
            buffer.append(tmpStr.charAt(pos++));
        }
        pos++;
        if(pos >= BUFFER_SIZE) {
            tmpStr = cleanBuffer(tmpStr, pos);
            pos -= BUFFER_SIZE;
        }
        return buffer.toString();
    }

    /**
     * 每隔BUFFER_SIZE个字符进行缓存清理
     * @param tmpStr
     */
    private String cleanBuffer(String tmpStr, int pos) {
        StringBuffer buffer = new StringBuffer();
        int len = tmpStr.length();
        for (int i = pos; i < len; i++) {
            buffer.append(tmpStr.charAt(i));
        }
        return buffer.toString();
    }
}