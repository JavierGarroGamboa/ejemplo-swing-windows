import cr.una.views.AppointmentView;
import cr.una.views.PatientView;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InternalFrame extends JFrame implements InternalFrameListener, ActionListener {
    JDesktopPane desktop;
    JInternalFrame patientWindow;
    JInternalFrame appointmentWindow;
    ArrayList<String> globalData;

    static final String PATIENT = "PAT";
    static final String APPOINTMENT = "APP";

    static final int DESKTOP_WIDTH = 500;
    static final int DESKTOP_HEIGHT = 300;

    public InternalFrame(String title) {
        super(title);
        JMenuItem menuItem1 = null;
        JMenuItem menuItem2 = null;
        JMenuItem menuExit = null;

        globalData = new ArrayList<String>();


        //Set up the GUI.
        desktop = new JDesktopPane();
        desktop.putClientProperty("JDesktopPane.dragMode",
                "outline");

        //Because we use pack, it's not enough to call setSize.
        //We must set the desktop's preferred size.
        desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
        setContentPane(desktop);

        loadPatientView(globalData);
        loadAppointmentView(globalData);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Mi Menu");

        // create menu items
        menuItem1 = new JMenuItem("Paciente");
        menuItem1.addActionListener(this);
        menuItem1.setActionCommand(PATIENT);

        menuItem2 = new JMenuItem("Cita");
        menuItem2.addActionListener(this);
        menuItem2.setActionCommand(APPOINTMENT);

        menuExit = new JMenuItem("Salir de la aplicación");
        menuExit.addActionListener((event) -> System.exit(0));

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuExit);

        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    private void loadPatientView(ArrayList<String> _globalData) {
        Dimension displaySize = null;

        patientWindow = new PatientView("Pacientes", _globalData).createInternalFrame();
        desktop.add(patientWindow); //DON'T FORGET THIS!!!
        displaySize = patientWindow.getSize();
        patientWindow.setSize(DESKTOP_WIDTH, displaySize.height);
    }

    private void loadAppointmentView(ArrayList<String> _globalData) {
        Dimension displaySize = null;

        appointmentWindow = new AppointmentView("Citas", _globalData).createInternalFrame();
        desktop.add(appointmentWindow); //DON'T FORGET THIS!!!
        displaySize = appointmentWindow.getSize();
        appointmentWindow.setSize(DESKTOP_WIDTH, displaySize.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (PATIENT.equals(e.getActionCommand())) {
            patientWindow.setVisible(true);
        } else if (APPOINTMENT.equals(e.getActionCommand())) {
            appointmentWindow.setVisible(true);
        }
    }

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

}
