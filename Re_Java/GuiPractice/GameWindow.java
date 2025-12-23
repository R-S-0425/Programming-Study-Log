import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class GameWindow extends JFrame{
    private int hp;
    private JLabel label;
    
    public GameWindow(){
        super("RPG");

        // 基本設定
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        // 部品の配置
        this.label = new JLabel("現在のHP: " + this.hp);
        JButton atkButton = new JButton("攻撃する！");
        JButton healButton = new JButton("回復する");

        // 攻撃ボタンの動き
        atkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attack(); 
            }
        });
        
        // 回復ボタンの動き
        healButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heal();
            }
        });

        // 画用紙（this）に貼り付け
        this.add(this.label);
        this.add(atkButton);
        this.add(healButton);
        
        // 最後に表示
        this.setVisible(true);
    }

    // 攻撃処理メソッド
    public void attack() {
        this.hp -= 10; // HPを減らす
        if (this.hp < 0) {
            this.hp = 0;
        }
        updateText();
    }
    
    // 回復処理メソッド
    public void heal() {
        this.hp += 20;
        if (this.hp > 100) {
            this.hp = 100;
        }
        updateText();
    }
    
    // 画面の文字を更新するメソッド
    public void updateText() {
        this.label.setText("現在のHP: " + this.hp);
        
        // HPによって色を変える演出
        if (this.hp <= 30) {
            this.label.setForeground(java.awt.Color.RED); // ピンチなら赤字
        } else {
            this.label.setForeground(java.awt.Color.BLACK);
        }
    }
}
