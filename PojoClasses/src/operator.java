public enum operator{
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;
    
    int calculate(int num1,int num2) 
    {
        switch(this) 
        {
            case PLUS:
                return num1 + num2;
            case MINUS:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            case DIVIDE:
                return num1 / num2;
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }
}
