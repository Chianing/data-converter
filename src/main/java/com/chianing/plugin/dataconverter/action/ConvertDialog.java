package com.chianing.plugin.dataconverter.action;

import com.chianing.plugin.dataconverter.ui.DataConvertForm;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;

public class ConvertDialog extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        JFrame frame = new JFrame("Data Converter");
        frame.setContentPane(new DataConvertForm(frame).getBackground());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
