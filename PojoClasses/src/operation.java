public enum operation{
        PLUS(-2147483648,-1),
        MINUS(-2147483648,-1),
        TIMES(-2147483648,-1),
        DIVIDE(-2147483648,-1);
        
        private final int num1;
        private final int num2;
        
        operation(int num1,int num2)
        {
            this.num1=num1;
            this.num2=num2;
        }
        
        int calculate() 
        {
            switch(this) 
            {
                case PLUS:
                    return this.num1 + this.num2;
                case MINUS:
                    return this.num1 - this.num2;
                case TIMES:
                    return this.num1 * this.num2;
                case DIVIDE:
                    return this.num1 / this.num2;
                default:
                    throw new AssertionError("Unknown operations " + this);
            }
        }
    }