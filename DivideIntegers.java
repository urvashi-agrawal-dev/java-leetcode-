// DivideIntegers.java
public class DivideIntegers {
    
    public static int divide(int dividend, int divisor) {
        
        if (divisor == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        
        long quotient = 0;
        for (int i = 31; i >= 0; i--) {
            if ((ldividend >> i) >= ldivisor) {
                quotient += (1L << i);
                ldividend -= (ldivisor << i);
            }
        }
        if (negative) {
            quotient = -quotient;
        }
        
        if (quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int) quotient;
    }

    public static void main(String[] args) {
       
        System.out.println(divide(10, 3));        
        System.out.println(divide(7, -3));       
        System.out.println(divide(-10, 3));      
        System.out.println(divide(-10, -3));      
        System.out.println(divide(1, 1));        
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(2147483647, 2));  
    }
}