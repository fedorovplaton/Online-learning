package wholeshit;

public class wholeshit {
    public static void main(String[] args) {

    }
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] b = new int [a1.length + a2.length];
        int i = 0, j = 0;
        for(; i < a1.length && j < a2.length;){
            if(a1[i] < a2[j]){
                b[i + j] = a1[i];
                i++;
            }
            else{
                b[i + j] = a2[j];
                j++;
            }
        }

        while(i < a1.length){
            b[i + j] = a1[i];
            i++;
        }
        while(j < a2.length){
            b[j + i] = a2[j];
            j++;
        }
        return b;
    }
    private String printTextPerRole(String[] roles, String[] textLines) {
        return "";

    }
}
