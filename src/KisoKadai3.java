import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisoKadai3 {
	//メインメソッド
	public static void main(String[] args) {
		System.out.println("Hello World!!");
		menu();
	}


	//メニュー
	public static void menu() {
		System.out.println("+-----------------+");
		System.out.println("|･   create   : 1 |");
		System.out.println("|･    load    : 2 |");
		System.out.println("|･ overewrite : 3 |");
		System.out.println("|･ postscript : 4 |");
		System.out.println("|･    exit    : 5 |");
		System.out.println("+-----------------+");

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	     String command;
		try {
			command = input.readLine();
			switch(command){
				case "1":
					create();
				case "2":
					load();
				case "3":
					overwrite();
				case "4":
					postscript();
				case "5":
					System.out.println("goodbye");
					System.exit(0);
				default :
					System.out.println("無効なコマンドです。");
					System.out.println("もう一度入力して下さい。");
					menu();
			}
		}catch(IOException err) {
			System.out.println(err);
		}
	}

	//読み込み処理
	public static void load() {
		System.out.println("file or directory?");

		BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
		String command;
		try {
			command = input2.readLine();

		switch(command){
			case "file":
				loadfile();
			case "directory":
				loaddirectory();
			default :
				System.out.println("無効なコマンドです。");
				System.out.println("もう一度入力して下さい。");
				load();
		}
		} catch (IOException err) {
			System.out.println(err);
			countinue();
		}
	}

	//ファイル読み込み
	public static void loadfile() {
		System.out.println("file name?");
		System.out.print(System.getProperty("user.home")+"\\");
		BufferedReader input3 = new BufferedReader(new InputStreamReader(System.in));
		try{
			String path = input3.readLine();
			File filepath = new File((System.getProperty("user.home")+"\\" + path));
			String str;
			if(checkBeforeReadfile(filepath)){
				BufferedReader br = new BufferedReader(new FileReader(filepath));
				System.out.println("--------実行結果--------");
				while((str = br.readLine()) != null){
					System.out.println(str);
				}
				br.close();
				System.out.println("------------------------");
			}else{
				System.out.println("ファイルが見つからないか、開けません。");
			}
		}catch(FileNotFoundException err){
			System.out.println(err);
			countinue();
		}catch(IOException err){
			System.out.println(err);
			countinue();

		}
		countinue();
	}

	//ディレクトリ読み込み
	public static void loaddirectory() {
		System.out.println("directory name?");
		System.out.print(System.getProperty("user.home")+"\\");
		BufferedReader input4 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String path = input4.readLine();
			File d = new File((System.getProperty("user.home")+"\\" + path));
			File[] filelistd = d.listFiles();
			System.out.println("--------実行結果--------");
			for (int i=0; i<filelistd.length; i++)
				if(filelistd[i].isFile()){
					System.out.println("[F]"+filelistd[i].getName());
				}else if(filelistd[i].isDirectory()){
					System.out.println("[D]"+filelistd[i].getName());
				}else{
					System.out.println("[?]"+filelistd[i].getName());
				}
			System.out.println("------------------------");
		}catch(IOException err){
			System.out.println(err);
			countinue();
		}
		countinue();
	}

	//処理の継続判定
	public static void countinue() {
		System.out.println("処理を継続しますか？");
		System.out.println("[yes],[no]");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = input.readLine();
			switch (str) {
			case "yes":
				System.out.println("メニューに戻ります。");
				menu();
			case "no":
				System.out.println("Goodbye World");
				System.exit(0);
			default:
				System.out.println("無効なコマンドです。");
				System.out.println("もう一度入力して下さい。");
			}
		}catch(IOException err) {
			System.out.println(err);
			countinue();
		}
		countinue();
	}

	//新規メニュー
		public static void create() {
			System.out.println("file or directory?");

			BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
			String command;
			try {
				command = input2.readLine();

			switch(command){
				case "file":
					newfile();
				case "directory":
					newdirectory();
				default :
					System.out.println("無効なコマンドです。");
					System.out.println("もう一度入力して下さい。");
					create();
			}
			} catch (IOException err) {
				System.out.println(err);
				countinue();
			}
		}

	//ファイルの作成
	public static void newfile() {
		System.out.println("newfile name?");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String nfname;
		try {
			nfname = input.readLine();
			File newfile;
			newfile = new File("C:\\Users\\internous\\"+nfname+".txt");
			newfile.createNewFile();
			System.out.println(nfname+".txtを作成しました。");
			System.out.println("Path:"+System.getProperty("user.home")+"\\"+nfname+".txt");
		}catch(IOException err) {
			System.out.println(err);
			countinue();
		}
		countinue();
	}

	//フォルダの作成
		public static void newdirectory() {
			System.out.println("newdirectory name?");
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String nfname;
			try {
				nfname = input.readLine();
				File newfile;
				newfile = new File("C:\\Users\\internous\\"+nfname);
				newfile.mkdir();
				System.out.println(nfname+"を作成しました。");
				System.out.println("Path:"+System.getProperty("user.home")+"\\"+nfname);
			}catch(IOException err) {
				System.out.println(err);
				countinue();
			}
			countinue();
		}

	//ファイル上書き
	public static void overwrite() {
		System.out.println("file name?");
		System.out.print(System.getProperty("user.home")+"\\");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			String fname = input.readLine();
			File file = new File(System.getProperty("user.home")+"\\"+fname);
			if (checkBeforeWritefile(file)){
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				System.out.println("上書きする内容を入力して下さい。");
				BufferedReader input2= new BufferedReader(new InputStreamReader(System.in));
				String str = input2.readLine();

				bw.write(str);

				bw.close();

				if(checkBeforeReadfile(file)){
					String str2;
					BufferedReader br = new BufferedReader(new FileReader(file));
					System.out.println("--------実行結果--------");
					while((str2 = br.readLine()) != null){
						System.out.println(str2);
					}
					br.close();
					System.out.println("------------------------");
				}
			}else{
				System.out.println("ファイルに書き込めません");
			}
			//上書きしたものを表示
		}catch(FileNotFoundException err){
			System.out.println(err);
			countinue();
		}catch(IOException err) {
			System.out.println(err);
			countinue();
		}
		countinue();
	}
	//ファイル追記
		public static void postscript() {
			System.out.println("file name?");
			System.out.print(System.getProperty("user.home")+"\\");
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			try {
				String fname = input.readLine();
				File file = new File(System.getProperty("user.home")+"\\"+fname);
				if (checkBeforeWritefile(file)){
					BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
					System.out.println("追記する内容を入力して下さい。");
					BufferedReader input2= new BufferedReader(new InputStreamReader(System.in));
					String str = input2.readLine();
					bw.write(str);
					bw.close();
					if(checkBeforeReadfile(file)){
						String str2;
						BufferedReader br = new BufferedReader(new FileReader(file));
						System.out.println("--------実行結果--------");
						while((str2 = br.readLine()) != null){
							System.out.println(str2);
						}
						br.close();
						System.out.println("------------------------");
					}
				}else{
					System.out.println("ファイルに書き込めません");
				}
			}catch(FileNotFoundException err){
				System.out.println(err);
				countinue();
			}catch(IOException err) {
				System.out.println(err);
				countinue();
			}
			countinue();
		}
	//ファイルの状態チェック
	private static boolean checkBeforeReadfile(File path){
		if (path.exists()){
			if (path.isFile() && path.canRead()){
				return true;
			}
		}
		return false;
		}
	private static boolean checkBeforeWritefile(File file){
		if (file.exists()){
		if (file.isFile() && file.canWrite()){
				return true;
		}
		}
		return false;
	}
}