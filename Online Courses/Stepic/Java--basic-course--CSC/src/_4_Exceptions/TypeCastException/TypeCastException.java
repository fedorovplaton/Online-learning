package _4_Exceptions.TypeCastException;


public class TypeCastException {
    public static void main(String[] args)
    {
        System.out.println(getCallerClassAndMethodName());
        sqrt(2);
    }
    public class A{
        int value;
    }

    public class B extends A{
        int value;
    }

    public static double sqrt(double x) {
        System.out.println(getCallerClassAndMethodName());
        if (x < 0) {
            throw new java.lang.IllegalArgumentException("Expected non-negative number, got " + x);
        } else
            return Math.sqrt(x);
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        String message = "";
        if(stackTraceElements.length >= 4) {
            StackTraceElement element = stackTraceElements[3];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            message = className + "#" + methodName;
            return message;
        }
        return null; // your implementation here
    }
}
