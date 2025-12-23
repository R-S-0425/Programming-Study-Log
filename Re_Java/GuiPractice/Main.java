import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Main{
    public static void main(String[] args) {
        new GameWindow();
        /*以下はすべてmainクラスで記述する方法
        //ウィンドウの枠を作る
        JFrame frame = new JFrame("RPG");
        //xボタンを押したときの動作を決める
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ウィンドウのサイズを指定
        frame.setSize(400,300);

        //レイアウトの設計、左から右に
        frame.setLayout(new FlowLayout());
        //部品を作る
        JLabel label = new JLabel("勇者リンネのHP:100");
        JButton button = new JButton("ダメージを受ける");

        //ボタンに監視役をつける
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("ダメージを受けた");
                label.setText("勇者リンネのHP:90");
            }
        });

        //フレームに部品をadd
        frame.add(label);
        frame.add(button);
        //画面を見えるようにする
        frame.setVisible(true);

        System.out.println("ウィンドウを表示しました。");
        */
    }
}