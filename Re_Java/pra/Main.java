/*復習しながらいろいろ試したからコードぐちゃぐちゃ */

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        System.out.println("\n--- 混沌の運動会 ---");
        
        // 「勇者」も「マタンゴ」も入る、Creatureのリストを作成
        ArrayList<Creature> runners = new ArrayList<Creature>();
        
        runners.add(new Warrior("Minato"));       // 勇者（戦士）
        runners.add(new Wizard("Merlin"));        // 勇者（魔法使い）
        runners.add(new Matango(50, 'A'));        // 敵
        runners.add(new PoisonMatango(100, 'X')); // 敵
        
        // 全員一斉に走らせる！
        for (Creature c : runners) {
            c.run();
        }

        /* 
        // キーボード入力を受け付ける準備
        Scanner sc = new Scanner(System.in);

        System.out.println("あなたの名前を入力してください >");
        
        //  入力された1行を文字列として受け取る
        String myName = sc.nextLine();
        
        // --- 勇者リスト作成 ---
        ArrayList<Hero> party = new ArrayList<Hero>();

        // 入力された名前を使って勇者を作る
        // ここで作った「名前だけのコンストラクタ」
        party.add(new Warrior(myName)); 
        

        party.add(new Warrior("Asaka"));
        //party.add(new Hero("Rinne", 150, 30));
        party.add(new Wizard("Merlin"));

        // マタンゴ用リストを作成（親クラスの型を指定）
        ArrayList<Matango> monsters = new ArrayList<Matango>();
        
        // 普通のマタンゴと、毒マタンゴを同じリストに入れる！
        monsters.add(new Matango(50, 'A'));
        monsters.add(new PoisonMatango(100, 'B')); // サブクラスも入る

        

        System.out.println("--- 戦闘開始！ ---");
        
        // リストの先頭（0番目）の敵を集中攻撃するルール
        Matango target = monsters.get(0);
        
        int turn = 1; // ターン数カウント用

        // 条件：ターゲットが生きてる（HP > 0）限り繰り返す
        while (target.hp > 0) {
            System.out.println("\n=== ターン" + turn + " ===");
            
            // 勇者たちのターン
            for (Hero h : party) {
                
                    h.attack(target);
                
                
                //攻撃するたびに「敵が死んだか？」チェックする
                if (target.hp <= 0) {
                    System.out.println("→ " + target.suffix + "を倒した！");
                    break; // forループを脱出（これ以上攻撃しない）
                }
                
                // 演出のためのウェイト
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            // ... (勇者たちの攻撃ループ) ...

            // 敵が生きていれば反撃
            if (target.hp > 0) {
                System.out.println("\n--- 敵のターン ---");
                
                // 誰を攻撃するか？
                Hero targetHero = party.get(0);
                
                target.attack(targetHero);
            }
            
            turn++;
        
        }
        
        System.out.println("--- 戦闘終了 ---");
        
        // 最後にScannerを閉じる
        sc.close();
        
        /* 
        //勇者を入れるためのリスト作成
        //<>ジェネリクス
        ArrayList<Hero> party = new ArrayList<Hero>();

        //勇者を作成し、リストに追加
        party.add(new Hero("Minato", 100, 20));
        party.add(new Hero("Asaka", 120, 15));
        party.add(new Hero("Rinne", 150, 30));
        
        //全員で攻撃
        System.out.println("---全員で攻撃---");
        for (Hero h: party){
            h.attack();

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        // リストのサイズ（人数）を表示
        System.out.println("現在のパーティ人数: " + party.size());


        //リストから削除の確認

        System.out.println("--- Minatoがパーティから離脱 ---");
        
        // 0番目の要素（Minato）を削除
        party.remove(0);

        // 削除後の人数とメンバーを確認
        System.out.println("現在のパーティ人数: " + party.size());
        
        for (Hero h : party) {
            System.out.println("残りメンバー: " + h.getName());
        }

        //リストにサブクラスを入れてみる

        System.out.println("--- 敵の出現！ ---");
        
        // マタンゴ用リストを作成（親クラスの型を指定）
        ArrayList<Matango> monsters = new ArrayList<Matango>();
        
        // 普通のマタンゴと、毒マタンゴを同じリストに入れる！
        monsters.add(new Matango(50, 'A'));
        monsters.add(new PoisonMatango(100, 'B')); // サブクラスも入る
        
        // ループで一斉に攻撃させる
        for (Matango m : monsters) {
            m.attack();
        }

        // staticの確認

        System.out.println("--- 所持金の実験 ---");

        // 1. 最初のお金を設定（クラス名.変数名 でアクセスするのが作法）
        Hero.money = 100;
        System.out.println("現在の所持金: " + Hero.money);

        // 2. 誰か一人（0番目の勇者）がお金を拾う
        // ※「party.get(0).money」と書いても動きますが、警告が出ることがある
        Hero.money += 1000;
        System.out.println("1000G拾った！");

        // 3. 別の勇者（1番目の勇者）が財布を確認
        // ここでも、実際は「Hero.money」を見ているのと同じ
        System.out.println(party.get(1).getName() + "の目線での所持金: " + Hero.money);

        //オーバーロードの確認
        // 名前だけで勇者を作成（HPと攻撃力は自動で決まる）
        Hero hNew = new Hero("Rintaro");
        
        System.out.println("--- 新入り勇者のステータス ---");
        System.out.println("名前: " + hNew.getName()); // Getterを使用
        // HPなどを確認するためのGetterも必要ならHeroクラスに追加して確認できます
        hNew.attack(); // "Rintaroは攻撃した！ ダメージ:10" となるはず

        */

        /* 1回目の復習で作成したもの
        //インスタンス生成
        Hero h1 = new Hero("Minato",100,20);
        Matango m1 = new Matango(50, 'A');
        PoisonMatango p1 = new PoisonMatango(100, 'B');
        //メソッド呼び出し
        h1.attack();
        m1.run();
        m1.attack();
        p1.attack();
        p1.run();
        */
    }
}


abstract class Hero implements Creature{
    //カプセル化の確認
    //フィールド 
    private String name;
    private int hp;
    private int attack;

    //staticはHeroクラスで共有
    static int money;

    //コンストラクタ
    Hero(String name, int hp, int attack){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    // 追加：名前だけ受け取るコンストラクタ
    Hero(String name) {
        // this() を使うと、自分自身の「別のコンストラクタ」を呼び出せる
        // ここでは「名前, 100, 10」として、上のコンストラクタに丸投げしている
        this(name, 100, 10);
    }

    //メソッド
    public abstract void attack(Matango m);/*{
   
        System.out.println(this.name + "は攻撃した！ ダメージ:" + this.attack);

        m.hp -= this.attack;

        System.out.println("お化けキノコ" + m.suffix + "に" + this.attack + "ポイントのダメージを与えた！");
        System.out.println("お化けキノコ" + m.suffix + "の残りHP: " + m.hp);
    
    }*/

    // ダメージを受けるメソッド（publicにして、外から呼べるようにする）
    public void takeDamage(int dmg) {
        this.hp -= dmg;
        
        // HPがマイナスにならないように補正
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println("【悲報】" + this.name + "は力尽きた...");
        } else {
            System.out.println(this.name + "は" + dmg + "のダメージを受けた！ (残りHP:" + this.hp + ")");
        }
    }

    public void run() {
        System.out.println(this.name + "は、ダッシュで逃げ出した！");
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
       if (name == null || name.length() == 0) {
            System.out.println("名前が不正です");
            return;
        }
        this.name = name;
    }
}

class Matango implements Creature{
    int hp;
    char suffix;

    Matango(int hp, char suffix){
        this.hp = hp;
        this.suffix = suffix;
    }

    public void run(){
        System.out.println("お化けキノコ"+this.suffix+"は逃げ出した！");
    }

    // 引数で Hero を受け取るように変更
    void attack(Hero h) {
        System.out.println("お化けキノコ" + this.suffix + "の攻撃！");
        // 10ダメージ固定で与えてみる
        h.takeDamage(10);
    }

    public void takeDamage(int dmg) {
        this.hp -= dmg;
        
        // HPがマイナスにならないように補正
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println( this.suffix + "は力尽きた...");
        } else {
            System.out.println(this.suffix + "は" + dmg + "のダメージを受けた！ (残りHP:" + this.hp + ")");
        }
    }
}

class PoisonMatango extends Matango{
int poisonCount = 5; // 毒を使える回数

    PoisonMatango(int hp, char suffix) {
        super(hp, suffix);
    }

    @Override
    // 親に合わせて引数を Hero h にする
    void attack(Hero h) {
        // まずは親クラスの attack を呼んで、通常攻撃させる
        super.attack(h);

        // 毒攻撃の残り回数が残っていれば...
        if (this.poisonCount > 0) {
            System.out.println("さらに毒の胞子をばらまいた！");
            
            // 毒ダメージ（例えば固定で30とか、勇者のHPの1/5とか）
            int dmg = 30;
            h.takeDamage(dmg);
            
            // 回数を減らす
            this.poisonCount--;
        }
    }
}

// Heroを継承する
class Wizard extends Hero {
    int mp;

    // コンストラクタ
    Wizard(String name) {
        // 親（Hero）のコンストラクタを呼ぶ
        super(name, 80, 5); // 魔法使いなのでHPと物理攻撃は低めに設定
        this.mp = 50;       // そのかわりMPを持つ
    }

    @Override
    public void attack(Matango m) {
        System.out.println(this.getName() + "の攻撃！");
        
        System.out.println("呪文を唱えた！");
        // 内部で自分のfireballメソッドを呼ぶ
        this.fireball(m); 
    }

    // 魔法攻撃メソッド
    void fireball(Matango m) {
        System.out.println(this.getName() + "は火の玉を放った！");
        
        // MPを消費
        if (this.mp >= 10) {
            this.mp -= 10;
            int dmg = 40;
            m.takeDamage(dmg);
            System.out.println("（MP残り: " + this.mp + "）");
        } else {
            System.out.println("しかしMPが足りなかった！");
        }
    }
}

// Hero（剣攻撃の基本機能）を引き継ぐ「戦士」クラス
class Warrior extends Hero {
    
    Warrior(String name) {
        super(name); // 親のコンストラクタを呼ぶ
    }
    
    // attackメソッドは書かなくても、親（Hero）の「剣攻撃」がそのまま使われる

    // 親から削除された「剣の攻撃」をここに書く（実装する）
    @Override
    public void attack(Matango m) {
        System.out.println(this.getName() + "の攻撃！");
        System.out.println("剣で斬りつけた！");
        // 攻撃力フィールドを使ってもいいし、固定でもOK
        m.takeDamage(20);
    }
}