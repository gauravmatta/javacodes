/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class alphabets 
{
    public void binaryOperations()
    {
        char c1='A';
        char c2='Z';
        System.out.println("Char\tBinary");
        System.out.println(c1+"\t"+Integer.toBinaryString(c1));
        System.out.println(c2+"\t"+Integer.toBinaryString(c2));
        int c3=(int)c1&(int)c2;
        System.out.println(c1+"&"+c2+"="+(char)c3+"\tBinary:"+Integer.toBinaryString(c3));
        int c4=(int)c1|(int)c2;
        System.out.println(c1+"|"+c2+"="+(char)c4+"\tBinary:"+Integer.toBinaryString(c4));
        int c5=(int)c1^(int)c2;
        System.out.println(c1+"^"+c2+"="+(char)c5+"\tBinary:"+Integer.toBinaryString(c5));
        int c6=~c1;
        System.out.println("~"+c1+"="+(char)c6+"\tBinary:"+Integer.toBinaryString(c6));
    }
    
    public long packLetters()
    {
        char c1='A';
        char c2='B';
        char c3='C';
        char c4='D';
        long packed=0L;
        packed=c4;
        packed=(packed << 16)|c3;
        packed=(packed << 16)|c2;
        packed=(packed << 16)|c1;
        return packed;
    }
    
    public void unpackLatters(long pack)
    {
        System.out.println("Packed now contains Hex 0X"+Long.toHexString(pack));
        System.out.println("Packed now contains Binary "+Long.toBinaryString(pack));
        long mask=0XFFFF; //Left 16 Bits as 1111111111111111
        char letter=(char)(pack&mask);
        System.out.println("From right to left the letters in packed are:");
        System.out.println("Charcter :"+letter+" Hex: 0X"+Long.toHexString(letter));
        pack>>=16;
        System.out.println("Packed now contains Binary "+Long.toBinaryString(pack));
        letter=(char)(pack&mask);
        System.out.println("Charcter :"+letter+" Hex: 0X"+Long.toHexString(letter));
        pack>>=16;
        System.out.println("Packed now contains Binary "+Long.toBinaryString(pack));
        letter=(char)(pack&mask);
        System.out.println("Charcter :"+letter+" Hex: 0X"+Long.toHexString(letter));
        pack>>=16;
        System.out.println("Packed now contains Binary "+Long.toBinaryString(pack));
        letter=(char)(pack&mask);
        System.out.println("Charcter :"+letter+" Hex: 0X"+Long.toHexString(letter));
    }
    
    public void showAllAlphabets()
    {
        char c1;
        System.out.println("Char\tDec\tHex\tBinary");
        for(c1='A';c1<='z';c1++)
        {
            System.out.println(c1+"\t"+(int)c1+"\t"+Integer.toHexString(c1)+"\t"+Integer.toBinaryString(c1));
        }
    }
    
    public static void main(String args[])
    {
        alphabets a1=new alphabets();
//        a1.showAllAlphabets();
//        a1.binaryOperations();
        long pack=a1.packLetters();
        a1.unpackLatters(pack);
    }
}
