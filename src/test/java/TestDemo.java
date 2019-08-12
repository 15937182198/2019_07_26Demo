import java.util.Scanner;
public class TestDemo{						//“Test07”需与文件名相同
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);		//键盘控制器
        System.out.println("请输入金字塔层数：");
        int a = sc.nextInt();				//将输入的数值赋给变量“a”
        long x=1;
        for(int i=1;i<=a;i++){				//循环输出，有几行
            for(int n=1;n<=a-i;n++){		//根据有几行来确定输出几个空格
//                System.out.print(" ");		//输出填充的空格
            }
            int z=2;
            if (i>2){
                for (int c=0;c<i-2;c++){
                    z=z*2;
                }
            }
            if (i<2){
                z=i;
            }
            for(int j=1;j<=z;j++){	//循环输出，每行有几个“*”
//                System.out.print(x);
//                System.out.print(" ");
                x++;
            }
            System.out.println();

        }
        System.out.println(x-1);
    }
}