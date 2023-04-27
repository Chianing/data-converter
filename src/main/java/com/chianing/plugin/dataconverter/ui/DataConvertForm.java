package com.chianing.plugin.dataconverter.ui;

import com.chianing.plugin.dataconverter.common.enums.DataTypeEnum;
import com.chianing.plugin.dataconverter.service.AbstractDataConvertService;
import com.chianing.plugin.dataconverter.service.DataConvertServiceManager;
import com.chianing.plugin.dataconverter.util.CheckEmptyUtil;
import com.google.common.base.Preconditions;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 数据转换窗体
 *
 * @author chianing
 * @description 数据转换窗体
 * @date 2023/04/26 17:27
 */
@Getter
public class DataConvertForm {
    private final JFrame frame;

    private JPanel background;
    private JButton cancelButton;
    private JButton compressButton;
    private JButton formatButton;
    private JPanel dataPanel;
    private JPanel buttonPanel;
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JScrollPane inputScrollPanel;
    private JScrollPane outputScrollPanel;
    private JPanel outputPanel;
    private JPanel inputPanel;
    private JLabel dataTypeLabel;
    private JPanel headerPanel;
    private JRadioButton jsonRadio;
    private JRadioButton sqlRadio;

    public DataConvertForm(JFrame frame) {
        this.frame = frame;

        // 格式化
        formatButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String inputText = inputArea.getText();
                String outputText;
                try {
                    outputText = getDataConvertService().format(inputText);
                } catch (Exception ex) {
                    outputText = ex.toString();
                    ex.printStackTrace();
                }

                outputArea.setText(outputText);
            }
        });
        // 压缩
        compressButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String inputText = inputArea.getText();
                if (CheckEmptyUtil.isEmpty(inputText)) {
                    outputArea.setText("");
                    return;
                }

                String outputText;
                try {
                    outputText = getDataConvertService().compress(inputText);
                } catch (Exception ex) {
                    outputText = ex.toString();
                    ex.printStackTrace();
                }

                outputArea.setText(outputText);
            }
        });
        // 关闭窗口
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });
    }

    private AbstractDataConvertService getDataConvertService() {
        AbstractDataConvertService dataConvertService = DataConvertServiceManager.getService(getDataType());
        Preconditions.checkArgument(CheckEmptyUtil.isNotEmpty(dataConvertService), "unsupported data type");
        return dataConvertService;
    }

    private DataTypeEnum getDataType() {
        if (jsonRadio.isSelected()) {
            return DataTypeEnum.JSON;
        }
        if (sqlRadio.isSelected()) {
            return DataTypeEnum.SQL;
        }

        return null;
    }

}
