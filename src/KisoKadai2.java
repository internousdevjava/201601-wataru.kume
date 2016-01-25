/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai2 {
			//数当てゲーム作成課題
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("数当てゲーム！！");
		System.out.println("10回以内に数字を当ててください。");
		int ans = new java.util.Random().nextInt(100)+1;

		for(int count=1; count<=10; count++){
			System.out.println(count+"回目です。");
			System.out.println("回答を入力して下さい。");
			int kaitou = new java.util.Scanner (System.in).nextInt();
			if(kaitou == ans){
				System.out.println("正解です！！");
				System.out.println("おめでとうございます");
				System.out.println("あなたは"+count+"回で正解しました。");
				break;
			}else if(kaitou < ans){
				System.out.println("小さすぎます。");
			}else{
				System.out.println("大きすぎます。");
			}
			System.out.println("残念でした。");
			if(count == 10){
				System.out.println("10回回答したので終了です。");
				System.out.println("答えは「"+ans+"」です。");
			}
		}
	}


}
