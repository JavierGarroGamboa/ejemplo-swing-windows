package cr.una.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Component.CENTER_ALIGNMENT;

public class AppointmentView extends BaseView implements ActionListener {
    TextArea display;

    static final String ADD = "add";
    static final int desktopWidth = 500;
    static final int desktopHeight = 300;

    public AppointmentView(String title, ArrayList<String> _globalData) {
        super(title, _globalData);
        setHeight(desktopHeight);
        setWitdh(desktopWidth);

        display = new TextArea(3, 30);
        display.setEditable(false);
    }

    @Override
    protected JPanel createDisplayView() {
        JPanel contentPane = new JPanel();

        JButton b1 = new JButton("Agregar");

        b1.setActionCommand(ADD);
        b1.addActionListener(this);

        JScrollPane textScroller = new JScrollPane(display);
        //Have to supply a preferred size, or else the scroll
        //area will try to stay as large as the text area.
        textScroller.setPreferredSize(new Dimension(200, 75));
        textScroller.setMinimumSize(new Dimension(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        contentPane.setLayout(new BoxLayout(contentPane,
                BoxLayout.PAGE_AXIS));
        b1.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(b1);
        contentPane.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPane.add(textScroller);
        contentPane.add(Box.createRigidArea(new Dimension(0, 5)));

        display.append(getGlobalData().toString());

        return contentPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ADD.equals(e.getActionCommand())) {
            ArrayList<String> localData = getGlobalData();
            localData.add("Lunes");
            setGlobalData(localData);
            display.append(getGlobalData().toString());
            System.out.println(getGlobalData().toString());
        }
    }
}
