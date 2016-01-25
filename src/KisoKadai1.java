/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai1 {
			//九九表作成課題
	public static void main(String[] args) {
		System.out.println("九九の表");
		System.out.println("最大値xを入力して下さい。");
		int input1 = new java.util.Scanner (System.in).nextInt();
		System.out.println("最大値yを入力して下さい。");
		int input2 = new java.util.Scanner (System.in).nextInt();

		int x = input1;
		int y = input2;

		int i,j;
			//最大値①,最大値②,最小値①,最小値②
		int a = String.valueOf(x*y).length();
		for(i=1; i<=x; i++){
				for (j=1; j<=y; j++) {
					int b = String.valueOf(i*j).length();
					if(a-b == 0){
						System.out.print(i*j+" ");
					}else{
						for(int c=1; c<=a-b; c++){
							System.out.print(" ");
						}
						System.out.print(i*j+" ");
					}
				}
			System.out.println("");
		}
	}

}
