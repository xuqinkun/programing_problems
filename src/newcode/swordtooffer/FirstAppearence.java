package newcode.swordtooffer;

public class FirstAppearence {
    int []a;
    Character c;

    {
        a = new int[256];
    }

    public void Insert(char ch)
    {
        a[ch]++;
        if (c == null) {
            c = ch;
        }
        else if (a[ch] == 1 && a[c] > 1) {
            c = ch;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (a[c] == 1)
            return c;
        else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 1)
                    return (char)i;
            }
            return '#';
        }
    }

    public static void main(String[] args) {
        String str = "BabyBaby";
        FirstAppearence op = new FirstAppearence();
        char[] chars = str.toCharArray();
        for (char c :
                chars) {
            op.Insert(c);
            System.out.println(op.FirstAppearingOnce());
        }
    }
}
