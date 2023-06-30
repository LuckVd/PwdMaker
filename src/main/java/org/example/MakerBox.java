package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class MakerBox extends Thread implements ActionListener, WindowListener {


    public static ArrayList<Integer> listnum = new ArrayList<>();


    @Override
    public void run() {
        super.run();

        JFrame jFrame = new JFrame("JFrame");

        jFrame.setLocation(800,300);
        jFrame.setSize(600,500);
        jFrame.setBackground(Color.darkGray);
        jFrame.setResizable(true);
        jFrame.setVisible(true);

        JPanel jp = new JPanel();
        JPanel jp2 = new JPanel();


        jp.setLayout(null);
        jp.setSize(600,80);
//        jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));
        jp2.setLayout(null);
        jp2.setBounds(0,80,580,400);

        Container container = jFrame.getContentPane();
        container.setLayout(null);
        container.add(jp);
        container.add(jp2);


        placeComponents(jp,jp2);

//        jFrame.pack();
        jFrame.setVisible(true);
    }

    private static void placeComponents(JPanel panel,JPanel panel2){

        JLabel userLabel = new JLabel("生成规则:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField textFieldurl = new JTextField();
        textFieldurl.setBounds(100,20,300,25);
        panel.add(textFieldurl);

        JButton loginButton = new JButton("add");
        loginButton.setBounds(450, 20, 80, 25);
        panel.add(loginButton);

        ActionListener addlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listnum.add(0);
                String currentText = textFieldurl.getText();
                String insertedText = "$insert$";
                int caretPosition = textFieldurl.getCaretPosition();
                String newText = currentText.substring(0, caretPosition) +
                        insertedText +
                        currentText.substring(caretPosition);
                textFieldurl.setText(newText);

                JComboBox comboBox = new JComboBox();
                comboBox.setBounds(0,listnum.size()*20,500,20);

                String[] strArray = { "list1", "list2", "list3" };
                for (String item : strArray)
                {
                    comboBox.addItem(item);
                }

                panel2.add(comboBox);

                // 重新绘制面板以显示新增的组件
                panel2.revalidate();
                panel2.repaint();

            }
        };

        loginButton.addActionListener(addlistener);

    }

    private void pack() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
