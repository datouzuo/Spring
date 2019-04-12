package mengzuo.xin.springmvc;

import java.util.Scanner;

/**
 * 前端控制控制器
 * @author 左利伟
 *
 */
public class DispatcherServlet {
	
private static int i = 1;
	
    static String calculate(int m, int k) {
    int[] arr = new int[Integer.MAX_VALUE];
    	zhu(m,arr);
    	int j=0;
     String s ="";
     for(int i : arr) {
    	s= s+String.valueOf(arr[j]);
    	 j++;
     }
    	return s;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
public static int  zhu(int m,int[] arr){
   
	
	if(m==1)
        return 2;
         if(m==2)
        	return 3;
         if(m==3)
        	 return 4;
         int n=  zhu(m-2,arr)+zhu(m-3,arr);
         arr[i++]=n;
      return n;
   
}
}

