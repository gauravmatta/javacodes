import java.util.*;
public class SubJect_Marks {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);  

        int row = sc.nextInt();   
        int col = sc.nextInt();
        int avg[]= new int[row];
        int ans[] = new int[row];
        int arr[][]= new int[row][col];
        int res[]= new int[row];
        for(int i = 0; i <row; i++) {
            for(int j=0;j<col;j++) {
                arr[i][j]= sc.nextInt();
            }
        }

        /*//verifying i/p
        for(int i = 0; i <row; i++) {
            for(int j=0;j<col;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }*/

        for(int i = 0; i <row; i++) { //calculating and storing average of each column
            for(int j=0;j<row;j++) {
            ans[i] += arr[j][i];

            }
        avg[i] = ans[i]/row; 

        }

    int min = avg[0];
        int eleminate_Index =0;
        for(int i = 1; i < row; i++) { // minimum average calculated and ..
            if(avg[i]<min) {
                min = avg[i];
                eleminate_Index = i; //..index of it stored.
            }
        }

        /*
        System.out.println(min);
        System.out.println(p);
        */
        for(int i = 0 ; i<row; i++) {
            for(int j=0; j<col; j++){
                if(eleminate_Index!=j) {//calculating sum of remaining subjects
                    res[i]+=arr[i][j];
                }
        }

        }
        for(int j=0; j<row; j++){
            System.out.print(res[j]+" ");
            }



        sc.close();
    }
}