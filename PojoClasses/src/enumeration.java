public class enumeration 
{   
    public static void main(String args[])
    {
        int result = operation.DIVIDE.calculate();
        System.out.println(result);
        result = operation.PLUS.calculate();
        System.out.println(result);
        
        operator add=operator.PLUS;
        result=add.calculate(12,12);
        System.out.println(result);
        
        if(add.equals(operator.PLUS))
        {
            System.out.println("This symbol represents PLUS");
        }
        
        //Collection based for loop
        for(operation or:operation.values())
        {
            System.out.println(or+" "+or.calculate());
        }
        
        
    }
}
