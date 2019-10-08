public class calc {
    private final int digit1;
    private final int digit2;
    
    public calc(int digit1,int digit2)
    {
        this.digit1=digit1;
        this.digit2=digit2;
    }
    
    public int add()
    {
        return digit1+digit2;
    }
    
    public int subtrct()
    {
        return digit1-digit2;
    }
    
    public int divide()
    {
        return digit1/digit2;
    }
    
    public int multiply()
    {
        return digit1*digit2;
    }
    
    public int remainder()
    {
        return digit1%digit2;
    }
        
    public void swap()
    {
        int d1=this.digit1;
        int d2=this.digit2;
        System.out.println("Digit 1 is "+d1+" it's Binary :"+Integer.toBinaryString(d1));
        System.out.println("Digit 2 is "+d2+" it's Binary :"+Integer.toBinaryString(d2));
        d1^=d2;
        System.out.println("After d1^=d2");
        System.out.println("Digit 1 is "+d1+" it's Binary :"+Integer.toBinaryString(d1));
        System.out.println("Digit 2 is "+d2+" it's Binary :"+Integer.toBinaryString(d2));
        d2^=d1;
        System.out.println("After d2^=d1");
        System.out.println("Digit 1 is "+d1+" it's Binary :"+Integer.toBinaryString(d1));
        System.out.println("Digit 2 is "+d2+" it's Binary :"+Integer.toBinaryString(d2));
        d1^=d2;
        System.out.println("After d1^=d2");
        System.out.println("Digit 1 is "+d1+" it's Binary :"+Integer.toBinaryString(d1));
        System.out.println("Digit 2 is "+d2+" it's Binary :"+Integer.toBinaryString(d2));
    }
    
    public void increment()
    {
        System.out.println("Digit 1 is :"+this.digit1);
        int d1=this.digit1;
        System.out.println("Digit 1++ is :" + (d1++));
        System.out.println("Now Digit 1 is :" + d1);
        d1=this.digit1;
        System.out.println("++Digit 1 is :" + (++d1));
        System.out.println("Now Digit 1 is :" + d1);
    }
    
    public void decrement()
    {
        System.out.println("Digit 1 is :"+this.digit1);
        int d1=this.digit1;
        System.out.println("Digit 1-- is :" + (d1--));
        System.out.println("Now Digit 1 is :" + d1);
        d1=this.digit1;
        System.out.println("--Digit 1 is :" + (--d1));
        System.out.println("Now Digit 1 is :" + d1);
    }
    
    public void shortsum()
    {
        short c1=5;
        short c2=10;
        short sum=(short)(c1+c2);
        c1++;
        System.out.println("C1 after increment "+c1);
        System.out.println("Short Sum : "+sum);
        int c3='a';
        System.out.println(c3);
    }
    
    public void checkEven()
    {
        if(this.digit1!=0)
        {
            if(this.digit1%2==0)
            {
                System.out.println("Digit 1 is even");
            }
        }
        else
        {
            System.out.println("Digit 1 is 0");
        }
        
        if(this.digit2!=0)
        {
            if(this.digit2%2==0)
            {
                System.out.println("Digit 2 is even");
            }
        }
        else
        {
            System.out.println("Digit 2 is 0");
        }
    }
    
    public void luck()
    {
        int number=0;
        number=1+(int)(100*Math.random());
        if(number%2==0)
        {
            System.out.println("You have got an even number ,"+number);
        }
        else
        {
          System.out.println("You have got an odd number ,"+number);   
        }
    }
    
    public void greatorThan()
    {
        int result=this.digit1>this.digit2?this.digit1:this.digit2;
        System.out.println(result+" is Greator");
    }
    
    public void lessThan()
    {
        int result=this.digit1<this.digit2?this.digit1:this.digit2;
        System.out.println(result+" is Lesser");
    }
    
    public int sumlimit(int limit)
    {
        int sum=0;
        for(int i=0;i<=limit;i++)
        {
            sum+=i;
        }
        return sum;
    }
    
    public void squares()
    {
        for(int i=0,j=0;i<=10;i++,j++)
        {
            System.out.println(i*j);
        }
    }
    
    public void factorial(long limit)
    {
        for(long i=1L;i<=limit;i++)
        {
            long number=i;
            long factorial=1L;
            for(long j=number;j>1;j--)
            {
                factorial=factorial*j;
            }
            System.out.println("Factorial of "+number+"is "+factorial);
        }
    }
    
    public void primes(int limit)
    {
        boolean isPrime;
        for(int i=2;i<=limit;i++)
        {
            isPrime=true;
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    isPrime=false;
                    break;
                }
            }
            
            if(isPrime)
            {
                System.out.println("Caught Prime : "+i);
            }
        }
    }
    
    public void checkMonth(int numOfDays)
    {
        if(numOfDays==30)
        {
            System.out.println("Month is April, June, September, or November");
        }
        else if(numOfDays==31)
        {
            System.out.println("Month is January, March, May, July, August, October, or December.");
        }
        else if(numOfDays==28 && numOfDays==29)
        {
            System.out.println("Month is Feburary.");
        }
        else
        {
            assert false:"No Month Found with "+numOfDays+" days";
        }
    }
    
    public static void main(String[] args)
    {
//        //Division of -ve largest magnitude integer
//        calc c1=new calc(-2147483648,-1);
//        System.out.println(c1.divide());
//        
//        //Division by zero
//        calc c5=new calc(25,0);
//        System.out.println(c5.divide());
//        
//        //Increment and Decrement
//        calc c2 = new calc(11,14);
//        c2.increment();
//        c2.decrement();
//        
//        //Short Sum
//        calc c3 = new calc(11,14);
//        c3.shortsum();
//        
//        //Xor Swap
//        calc c4 = new calc(25,30);
//        c4.swap();
        
        //check Even
        calc c10=new calc(25,30);
        c10.checkEven();
        
//        //Luck
        calc c6=new calc(25,30);
        c6.luck();
        
//        //Greator Than
        calc c7=new calc(25,30);
        c7.greatorThan();
        c7.lessThan();
        
//        //Sum Limit
        calc c8=new calc(25,30);
        int sum=c8.sumlimit(20);
        System.out.println("Sum = " + sum);
        
//        //squares
        calc c9=new calc(25,30);
        c9.squares();
        c9.factorial(20L);
        c9.primes(50);
        c9.checkMonth(12);
    }
}