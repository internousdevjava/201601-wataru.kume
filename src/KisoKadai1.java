/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai1 {
			//九九表作成課題
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("九九の表");

		int x=9,y=9,i,j;
			//最大値①,最大値②,最小値①,最小値②
		for(i=1; i<=x; i++){
				for (j=1; j<=y; j++) {
					System.out.print(i*j);
					System.out.print(" ");
				}
			System.out.println("");
		}
	}

}
