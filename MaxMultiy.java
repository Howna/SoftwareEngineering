import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.omg.CORBA.portable.InputStream;
import UI_sizeyunsuan.system;
/*
 * �����˷�
 * ������
 * num1Ϊ��һ�����������ַ����鱣��
 * num2Ϊ�ڶ�������
 * sums���鱣����˵Ľ��������num1*num2=sum
 * ����ֵ����������sum����Ч���ȣ�����������λ��
 */
public class MaxMultiy {
	final static int max=100;
	public static void main(String[] args) {
		
		int len;
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String a;
			String b;
			int sum[] =new int[max*2+10]; // ��ż���Ľ������λ��ǰ����λ�ں󣬼�sum[0]�ǵ�λ    
			//System.out.println("�������һ��������");
			a = sc.nextLine();
			//System.out.println("������ڶ���������");
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
    for(j = 0, i = len1-1; i >= 0; i--) //�������ַ�ת��Ϊ������ 
        a[j++] = num1[i]-'0';
    len2 = (num2).length;
    for(j = 0, i = len2-1; i >= 0; i--)
        b[j++] = num2[i]-'0';
    for(i = 0; i < len2; i++) {			//�õڶ��������Ե�һ����,ÿ��һλ 
        for(j = 0; j < len1; j++){
            c[i+j] += b[i] * a[j]; //�ȳ�����,����ͳһ��λ
        }
    }
    for(i=0; i<max*2; i++){ 	 //ѭ��ͳһ�����λ����
        if(c[i]>=10){
            c[i+1]+=c[i]/10;
            c[i]%=10;
        }
    }
    for(i = max*2; c[i]==0 && i>=0; i--); //������λ��0
    len = i+1;                  // ��¼����ĳ��� 
    for(; i>=0; i--)
        sum[i]=c[i];
    return len; 
	}
}



