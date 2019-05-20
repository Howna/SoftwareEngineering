import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.omg.CORBA.portable.InputStream;
import UI_sizeyunsuan.system;
/*
 * 大数乘法
 * 参数：
 * num1为第一个因数，用字符数组保存
 * num2为第二个因数
 * sums数组保存相乘的结果，即：num1*num2=sum
 * 返回值：返回数组sum的有效长度，即计算结果的位数
 */
public class MaxMultiy {
	final static int max=100;
	public static void main(String[] args) {
		
		int len;
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String a;
			String b;
			int sum[] =new int[max*2+10]; // 存放计算的结果，低位在前，高位在后，即sum[0]是低位    
			//System.out.println("请输入第一个大数：");
			a = sc.nextLine();
			//System.out.println("请输入第二个大数：");
	        b = sc.nextLine();

	        char[] num1 = a.trim().toCharArray();
	        char[] num2 = b.trim().toCharArray();

	        len = Multiplication(num1, num2, sum);
			for(int i = len-1; i>=0; i--)
				System.out.print(sum[i]); 
			    System.out.println();
		}
		
	}
	
static int Multiplication(char num1[],char num2[], int sum[]){
	int i, j, len, len1, len2;
    int a[]=new int[max+10];
    int b[]=new int[max+10];
    int c[]=new int[max*2+10];
    
    len1 = (num1).length;
    for(j = 0, i = len1-1; i >= 0; i--) //把数字字符转换为整型数 
        a[j++] = num1[i]-'0';
    len2 = (num2).length;
    for(j = 0, i = len2-1; i >= 0; i--)
        b[j++] = num2[i]-'0';
    for(i = 0; i < len2; i++) {			//用第二个数乘以第一个数,每次一位 
        for(j = 0; j < len1; j++){
            c[i+j] += b[i] * a[j]; //先乘起来,后面统一进位
        }
    }
    for(i=0; i<max*2; i++){ 	 //循环统一处理进位问题
        if(c[i]>=10){
            c[i+1]+=c[i]/10;
            c[i]%=10;
        }
    }
    for(i = max*2; c[i]==0 && i>=0; i--); //跳过高位的0
    len = i+1;                  // 记录结果的长度 
    for(; i>=0; i--)
        sum[i]=c[i];
    return len; 
	}
}



