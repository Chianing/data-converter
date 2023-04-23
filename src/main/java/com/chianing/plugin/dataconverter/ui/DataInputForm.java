package com.chianing.plugin.dataconverter.ui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author chianing
 * @description TODO
 * @date 2023/04/23 17:00
 */
public class DataInputForm {
    private JPanel background;
    private JTextArea inputArea;
    private JButton cancelButton;
    private JButton sqlCompressButton;
    private JButton jsonCompressButton;
    private JButton jsonFormatButton;
    private JPanel dataArea;
    private JPanel buttonArea;
    private JTextPane outputArea;

    public DataInputForm() {
        jsonFormatButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}
