package es.iessaladillo.pedrojoya.login.base;

import es.iessaladillo.pedrojoya.login.utils.JFrameUtils;

import javax.swing.*;
import java.awt.*;

public abstract class BaseScreen {

    private JFrame frame;

    protected BaseScreen() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        JFrameUtils.center(frame);
        frame.setContentPane();
    }

    public void setContentPane(Container contentPane) {
        frame.setContentPane(contentPane);
    }

}
