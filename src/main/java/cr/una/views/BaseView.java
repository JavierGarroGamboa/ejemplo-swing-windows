package cr.una.views;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class BaseView extends JFrame
        implements InternalFrameListener {

    private JInternalFrame windowInternal;
    private String title;
    private int witdh;
    private int height;
    private ArrayList<String> globalData;

    public BaseView(String title, ArrayList<String> _globalData) {
        windowInternal = new JInternalFrame(title,
                false,  //resizable
                true, //not closable
                false, //not maximizable
                true); //iconifiable
        globalData = _globalData;
    }

    public JInternalFrame createInternalFrame() {
        JPanel contentPane = createDisplayView();
        windowInternal.setContentPane(contentPane);
        windowInternal.pack();
        windowInternal.setPreferredSize(new Dimension(witdh, height));
        windowInternal.setVisible(false);
        windowInternal.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        return windowInternal;
    }

    protected abstract JPanel createDisplayView();

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public int getWitdh() {
        return witdh;
    }

    public void setWitdh(int witdh) {
        this.witdh = witdh;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<String> getGlobalData() {
        return globalData;
    }

    public void setGlobalData(ArrayList<String> globalData) {
        this.globalData = globalData;
    }
}
