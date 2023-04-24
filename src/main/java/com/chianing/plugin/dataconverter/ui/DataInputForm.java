package com.chianing.plugin.dataconverter.ui;

import com.chianing.plugin.dataconverter.util.CheckEmptyUtil;
import com.chianing.plugin.dataconverter.util.JsonUtil;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author chianing
 * @description TODO
 * @date 2023/04/23 17:00
 */
@Getter
public class DataInputForm {
    private final JFrame jFrame;

    private JPanel background;
    private JTextArea inputArea;
    private JButton cancelButton;
    private JButton sqlCompressButton;
    private JButton jsonCompressButton;
    private JButton jsonFormatButton;
    private JPanel dataArea;
    private JPanel buttonArea;
    private JTextPane outputArea;

    public DataInputForm(JFrame jFrame) {
        this.jFrame = jFrame;

        // json格式化
        jsonFormatButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String inputText = inputArea.getText();
                if (CheckEmptyUtil.isEmpty(inputText)) {
                    outputArea.setText("");
                    return;
                }

                String outputText;
                try {
                    outputText = JsonUtil.prettifyJson(inputText);
                } catch (Exception ex) {
                    String errMsg = "parse error: " + ex.getMessage();
                    JOptionPane.showMessageDialog(null, errMsg);
                    outputText = "";
                }

                outputArea.setText(outputText);

            }
        });
        // json压缩
        jsonCompressButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String inputText = inputArea.getText();
                if (CheckEmptyUtil.isEmpty(inputText)) {
                    outputArea.setText("");
                    return;
                }

                String outputText = inputText.replace(" ", "")
                        .replace("\r", "")
                        .replace("\n", "");

                outputArea.setText(outputText);

            }
        });
        // 关闭窗口
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.dispose();
            }
        });
    }

}
