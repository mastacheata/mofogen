package com.android.forge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.android.forge.calendar.CalendarGenerator;
import com.android.forge.contacts2.CallGenerator;
import com.android.forge.contacts2.ContactGenerator;

/**
 *
 * @author benedikt
 */
public class ConfigDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form ConfigDialog
	 */
	public ConfigDialog() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {
		// Connect Panel
		connectPanel = new JPanel();

		connectText = new JLabel();
		connectButton = new JButton();

		// Types Panel
		typesPanel = new JPanel();

		typesLabel = new JLabel();

		createLabel = new JLabel();
		updateLabel = new JLabel();
		deleteLabel = new JLabel();

		callsCheckBox = new JCheckBox();
		contactsCheckBox = new JCheckBox();
		calendarCheckBox = new JCheckBox();

		createCallsSpinner = new JSpinner();
		updateCallsSpinner = new JSpinner();
		deleteCallsSpinner = new JSpinner();

		createContactsSpinner = new JSpinner();
		updateContactsSpinner = new JSpinner();
		deleteContactsSpinner = new JSpinner();

		createCalendarSpinner = new JSpinner();
		updateCalendarSpinner = new JSpinner();
		deleteCalendarSpinner = new JSpinner();

		createCallsSpinner.setModel(new SpinnerNumberModel());
		updateCallsSpinner.setModel(new SpinnerNumberModel());
		deleteCallsSpinner.setModel(new SpinnerNumberModel());
		createContactsSpinner.setModel(new SpinnerNumberModel());
		updateContactsSpinner.setModel(new SpinnerNumberModel());
		deleteContactsSpinner.setModel(new SpinnerNumberModel());
		createCalendarSpinner.setModel(new SpinnerNumberModel());
		updateCalendarSpinner.setModel(new SpinnerNumberModel());
		deleteCalendarSpinner.setModel(new SpinnerNumberModel());

		// Time Panel
		timePanel = new JPanel();

		startDateLabel = new JLabel();
		startDayCombo = new JComboBox<String>();
		startMonthCombo = new JComboBox<String>();
		startYearCombo = new JComboBox<String>();

		endDateLabel = new JLabel();
		endDayCombo = new JComboBox<String>();
		endMonthCombo = new JComboBox<String>();
		endYearCombo = new JComboBox<String>();

		// Continue and Save Button
		continuePanel = new JPanel();
		continueLabel = new JLabel();
		continueButton = new JButton();

		// Panel Borders
		connectPanel.setBorder(BorderFactory.createTitledBorder("Connect Device"));
		typesPanel.setBorder(BorderFactory.createTitledBorder("Types and amount of Data"));
		timePanel.setBorder(BorderFactory.createTitledBorder("Timeframe"));
		continuePanel.setBorder(BorderFactory.createTitledBorder("Transfer and Save"));

		// Texts
		connectText.setText("Connect Android device and enable USB debugging");
		connectButton.setText("Connect and Transfer Phonedata");
		typesLabel.setText("Type");
		createLabel.setText("Create");
		updateLabel.setText("Update");
		deleteLabel.setText("Delete");
		callsCheckBox.setText("Calls");
		contactsCheckBox.setText("Contacts");
		calendarCheckBox.setText("Calendar Events");
		startDateLabel.setText("Start Date");
		endDateLabel.setText("End Date");
		continueLabel.setText("Transfer generated data to device and save report");
		continueButton.setText("Continue and Save");

		setTitle("MoFoGen - The Mobile Forensics Generator");

		// Disable Spinners
		createCallsSpinner.setEnabled(false);
		updateCallsSpinner.setEnabled(false);
		deleteCallsSpinner.setEnabled(false);
		createContactsSpinner.setEnabled(false);
		updateContactsSpinner.setEnabled(false);
		deleteContactsSpinner.setEnabled(false);
		createCalendarSpinner.setEnabled(false);
		updateCalendarSpinner.setEnabled(false);
		deleteCalendarSpinner.setEnabled(false);

		// Define ComboBox Models
		startDayCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		startMonthCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
		startYearCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));
		endDayCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		endMonthCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
		endYearCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000" }));

		// Define ActionListeners
		connectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				connectButtonActionPerformed(evt);
			}
		});

		callsCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				callsCheckBoxActionPerformed(evt);
			}
		});

		contactsCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				contactsCheckBoxActionPerformed(evt);
			}
		});

		calendarCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				calendarCheckBoxActionPerformed(evt);
			}
		});

		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				continueButtonActionPerformed(evt);
			}
		});

		// ConnectPanel Layout BEGIN
		GroupLayout connectPanelLayout = new GroupLayout(connectPanel);
		connectPanel.setLayout(connectPanelLayout);

		connectPanelLayout.setAutoCreateGaps(true);
		connectPanelLayout.setAutoCreateContainerGaps(true);

		connectPanelLayout.setHorizontalGroup(
				connectPanelLayout.createSequentialGroup()
				.addComponent(connectText)
				.addComponent(connectButton)
				);

		connectPanelLayout.setVerticalGroup(
				connectPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(connectText)
				.addComponent(connectButton)
				);
		// ConnectPanel Layout END

		// TypesPanel Layout BEGIN
		GroupLayout typesPanelLayout = new GroupLayout(typesPanel);
		typesPanel.setLayout(typesPanelLayout);

		typesPanelLayout.setAutoCreateGaps(true);
		typesPanelLayout.setAutoCreateContainerGaps(true);

		typesPanelLayout.setHorizontalGroup(
				typesPanelLayout.createSequentialGroup()
				.addGroup(typesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(typesLabel)
						.addComponent(callsCheckBox)
						.addComponent(contactsCheckBox)
						.addComponent(calendarCheckBox)
						)
						.addGroup(typesPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(createLabel)
								.addComponent(createCallsSpinner)
								.addComponent(createContactsSpinner)
								.addComponent(createCalendarSpinner)
								)
								.addGroup(typesPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
										.addComponent(updateLabel)
										.addComponent(updateCallsSpinner)
										.addComponent(updateContactsSpinner)
										.addComponent(updateCalendarSpinner)
										)
										.addGroup(typesPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
												.addComponent(deleteLabel)
												.addComponent(deleteCallsSpinner)
												.addComponent(deleteContactsSpinner)
												.addComponent(deleteCalendarSpinner)
												)
				);

		typesPanelLayout.setVerticalGroup(
				typesPanelLayout.createSequentialGroup()
				.addGroup(typesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(typesLabel)
						.addComponent(createLabel)
						.addComponent(updateLabel)
						.addComponent(deleteLabel)
						)
						.addGroup(typesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(callsCheckBox)
								.addComponent(createCallsSpinner)
								.addComponent(updateCallsSpinner)
								.addComponent(deleteCallsSpinner)
								)
								.addGroup(typesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(contactsCheckBox)
										.addComponent(createContactsSpinner)
										.addComponent(updateContactsSpinner)
										.addComponent(deleteContactsSpinner)
										)
										.addGroup(typesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(calendarCheckBox)
												.addComponent(createCalendarSpinner)
												.addComponent(updateCalendarSpinner)
												.addComponent(deleteCalendarSpinner)
												)
				);
		// TypesPanel Layout END

		// TimePanel Layout BEGIN
		GroupLayout timePanelLayout = new GroupLayout(timePanel);
		timePanel.setLayout(timePanelLayout);

		timePanelLayout.setAutoCreateGaps(true);
		timePanelLayout.setAutoCreateContainerGaps(true);

		timePanelLayout.setHorizontalGroup(
				timePanelLayout.createSequentialGroup()
				.addComponent(startDateLabel)
				.addComponent(startDayCombo)
				.addComponent(startMonthCombo)
				.addComponent(startYearCombo)
				.addComponent(endDateLabel)
				.addComponent(endDayCombo)
				.addComponent(endMonthCombo)
				.addComponent(endYearCombo)
				);

		timePanelLayout.setVerticalGroup(
				timePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(startDateLabel)
				.addComponent(startDayCombo)
				.addComponent(startMonthCombo)
				.addComponent(startYearCombo)
				.addComponent(endDateLabel)
				.addComponent(endDayCombo)
				.addComponent(endMonthCombo)
				.addComponent(endYearCombo)
				);
		// TimePanel Layout END

		// ContinuePanel Layout BEGIN
		GroupLayout continuePanelLayout = new GroupLayout(continuePanel);
		continuePanel.setLayout(continuePanelLayout);

		continuePanelLayout.setAutoCreateGaps(true);
		continuePanelLayout.setAutoCreateContainerGaps(true);

		continuePanelLayout.setHorizontalGroup(
				continuePanelLayout.createSequentialGroup()
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(continueLabel)
				.addComponent(continueButton)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		continuePanelLayout.setVerticalGroup(
				continuePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(continueLabel)
				.addComponent(continueButton)
				);
		// ContinuePanel Layout END

		// Frame Layout BEGIN
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addComponent(connectPanel)
				.addComponent(typesPanel)
				.addComponent(timePanel)
				.addComponent(continuePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(connectPanel)
				.addComponent(typesPanel)
				.addComponent(timePanel)
				.addComponent(continuePanel)
				);
		// Frame Layout END

		pack();

		// Close Action
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	private void continueButtonActionPerformed(ActionEvent evt) {
		int createCalls = (int) createCallsSpinner.getValue();
		int createContacts = (int) createContactsSpinner.getValue();
		int createCalendar = (int) createCalendarSpinner.getValue();
		int updateCalls = (int) updateCallsSpinner.getValue();
		int updateContacts = (int) updateContactsSpinner.getValue();
		int updateCalendar = (int) updateCalendarSpinner.getValue();
		int deleteCalls = (int) deleteCallsSpinner.getValue();
		int deleteContacts = (int) deleteContactsSpinner.getValue();
		int deleteCalendar = (int) deleteCalendarSpinner.getValue();


		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd MMM yyyy");
		long startDate = fmt.parseDateTime(startDayCombo.getSelectedItem() + " " + startMonthCombo.getSelectedItem() + " " + startYearCombo.getSelectedItem()).getMillis();
		long endDate = fmt.parseDateTime(endDayCombo.getSelectedItem() + " " + endMonthCombo.getSelectedItem() + " " + endYearCombo.getSelectedItem()).getMillis();

		DataGenerator dg = new DataGenerator(startDate, endDate);

		dg.register(new CallGenerator(createCalls, updateCalls, deleteCalls));
		dg.register(new ContactGenerator(createContacts, updateContacts, deleteContacts));
		dg.register(new CalendarGenerator(createCalendar, updateCalendar, deleteCalendar));
		
		dg.generate();

		System.out.println(dg);

		showLogSaveDialog(dg);
	}

	private void showLogSaveDialog(DataGenerator dg) {
		Object [] options = {"Browse..."};

		/*String log = "Created Calls: " + dg.createdCalls + "\n";
		log += "Updated Calls: " + dg.updatedCalls + "\n";
		log += "Deleted Calls: " + dg.deletedCalls +"\n\n";
		log += "Created Contacts: " + dg.createdContacts + "\n";
		log += "Updated Contacts: " + dg.updatedContacts + "\n";
		log += "Deleted Contacts: " + dg.deletedContacts; */
		String log = "";

		if (JOptionPane.showOptionDialog(getContentPane(), "Data successfully generated, where shall the LogFile be saved?", "Generation completed", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.OK_OPTION) {
			JFileChooser fc = new JFileChooser();
			File targetDirectory = null;
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			if (fc.showOpenDialog(getContentPane()) == JFileChooser.APPROVE_OPTION) {
				targetDirectory = fc.getSelectedFile();

				try {
					OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(targetDirectory.getAbsolutePath() + "\\android_data_generator.log"), "UTF-8");
					out.write(log);
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(getContentPane(), "The log file could not be saved.", "Discard Log", JOptionPane.WARNING_MESSAGE, null);
				System.exit(ERROR);
			}

			try {
				Runtime rt = Runtime.getRuntime();
				Process pr = rt.exec("adb push C:\\Users\\benedikt\\Dropbox\\devel\\unversioned\\DataGenerator\\bin\\callLog.sqlite /data/data/com.android.providers.contacts/databases/contacts2.db");

				// Get the input stream and read from it
				InputStream in = pr.getInputStream();
				int c;
				while ((c = in.read()) != -1) {
					System.out.println("Push ended with Code: " + c);
				}
				in.close();

				pr.waitFor();


				// TODO reenable for real world use, disable for emulator
				/*pr = rt.exec("adb reboot");

				in = pr.getInputStream();

				while ((c = in.read()) != -1) {
			    	System.out.println("Reboot ended with Code: " + c);
			    }
			    in.close();*/

				pr.waitFor();

				JOptionPane.showMessageDialog(getContentPane(), "Log saved to " + targetDirectory.getAbsolutePath() + "\\android_data_generator.log");
				System.exit(0);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(ERROR);
			}
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "The log file was not saved and the generated Data was not transfered to the device.", "Discard Data", JOptionPane.WARNING_MESSAGE, null);
			System.exit(ERROR);
		}
	}

	private void connectButtonActionPerformed(ActionEvent evt) {
		try {
			Runtime rt = Runtime.getRuntime();
			String cmd = "adb pull /data/data/com.android.providers.contacts/databases/contacts2.db C:\\Users\\benedikt\\Dropbox\\devel\\unversioned\\DataGenerator\\bin\\callLog.sqlite";
			Process pr = rt.exec(cmd);
			int exitVal = pr.waitFor();
			System.out.println("Exited with code" +exitVal);
		} catch(Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			System.exit(ERROR);
		}
	}

	private void callsCheckBoxActionPerformed(ActionEvent evt) {
		createCallsSpinner.setEnabled(!createCallsSpinner.isEnabled());
		updateCallsSpinner.setEnabled(!updateCallsSpinner.isEnabled());
		deleteCallsSpinner.setEnabled(!deleteCallsSpinner.isEnabled());
	}

	private void contactsCheckBoxActionPerformed(ActionEvent evt) {
		createContactsSpinner.setEnabled(!createContactsSpinner.isEnabled());
		updateContactsSpinner.setEnabled(!updateContactsSpinner.isEnabled());
		deleteContactsSpinner.setEnabled(!deleteContactsSpinner.isEnabled());
	}

	private void calendarCheckBoxActionPerformed(ActionEvent evt) {
		createCalendarSpinner.setEnabled(!createCalendarSpinner.isEnabled());
		updateCalendarSpinner.setEnabled(!updateCalendarSpinner.isEnabled());
		deleteCalendarSpinner.setEnabled(!deleteCalendarSpinner.isEnabled());
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new ConfigDialog().setVisible(true);
			}
		});
	}

	// Variables declaration
	private JPanel connectPanel;
	private JLabel connectText;
	private JButton connectButton;

	private JPanel typesPanel;
	private JLabel typesLabel;
	private JCheckBox callsCheckBox;
	private JCheckBox contactsCheckBox;
	private JCheckBox calendarCheckBox;
	private JLabel createLabel;
	private JSpinner createCallsSpinner;
	private JSpinner createContactsSpinner;
	private JSpinner createCalendarSpinner;
	private JLabel updateLabel;
	private JSpinner updateCallsSpinner;
	private JSpinner updateContactsSpinner;
	private JSpinner updateCalendarSpinner;
	private JLabel deleteLabel;
	private JSpinner deleteCallsSpinner;
	private JSpinner deleteContactsSpinner;
	private JSpinner deleteCalendarSpinner;

	private JPanel timePanel;
	private JLabel startDateLabel;
	private JComboBox<String> startDayCombo;
	private JComboBox<String> startMonthCombo;
	private JComboBox<String> startYearCombo;
	private JLabel endDateLabel;
	private JComboBox<String> endDayCombo;
	private JComboBox<String> endMonthCombo;
	private JComboBox<String> endYearCombo;

	private JPanel continuePanel;
	private JLabel continueLabel;
	private JButton continueButton;
	// End of variables declaration
}
