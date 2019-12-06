package teamProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import java.awt.Panel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.awt.FlowLayout;

import javax.swing.UIManager;

public class test extends JFrame 
{

	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JPanel contentPane;
	private JButton btnSaveFile;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private JLabel lblUploadedFile;
	private JLabel lblNewLabel_1;
	private JRadioButton rdbtnNewRadioButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1520, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Text Formatting");
		lblNewLabel.setBounds(5, 5, 1489, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Upload File");
		btnNewButton.setBounds(5, 607, 1489, 43);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(btnNewButton);
		
		btnSaveFile = new JButton("Save File");
		btnSaveFile.setBounds(5, 655, 1489, 43);
		btnSaveFile.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(btnSaveFile);
		
		textPane = new JTextPane();
		textPane.setName("Uploaded Text Document");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane1 = new JScrollPane(textPane);
		scrollPane1.setBounds(10, 125, 750, 471);
		contentPane.add(scrollPane1);
		
		textPane_1 = new JTextPane();
		textPane_1.setName("Preview Formatted File");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_1.setForeground(new Color(0, 0, 0));
		JScrollPane scrollPane2 = new JScrollPane(textPane_1);
		scrollPane2.setBounds(770, 125, 719, 471);
		contentPane.add(scrollPane2);
		
		lblUploadedFile = new JLabel("Uploaded File");
		lblUploadedFile.setHorizontalAlignment(SwingConstants.CENTER);
		lblUploadedFile.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUploadedFile.setBounds(10, 81, 750, 33);
		contentPane.add(lblUploadedFile);
		
		lblNewLabel_1 = new JLabel("Preview");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(770, 81, 719, 33);
		contentPane.add(lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("View Error Logs");
		rdbtnNewRadioButton.setBorder(new LineBorder(UIManager.getColor("Button.foreground")));
		rdbtnNewRadioButton.setBackground(UIManager.getColor("Button.light"));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnNewRadioButton.setBounds(6, 705, 1488, 43);
		contentPane.add(rdbtnNewRadioButton);
		
		handler thehandler = new handler();
		btnNewButton.addActionListener(thehandler);
		btnSaveFile.addActionListener(thehandler);
		rdbtnNewRadioButton.addActionListener(thehandler);
	}
	
	private class handler implements ActionListener
	{
		String preview = "";			//Strings to be added to the text panes.
		String original = "";
		String error = "";
		File output;
		
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == btnNewButton)			//If the user presses the upload button.
			{
				ReadFile ofInput = new ReadFile();			//Have them open file explorer for a text file.
				FileProcessor fp = new FileProcessor();
				
				try
				{
					ofInput.select();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				textPane.setText(ofInput.builder.toString());		//Set the selected text file to the text pane and original string.
				original = ofInput.builder.toString();
				
				try
				{
					File input = ofInput.getCurrentSourceFile();	//Process the flags.
					output = fp.handleFile(input);
					error = (fp.getErrorString()).toString();		//From the ErrorHandler class access the string.
					
					if(error.compareTo("") != 0)					//If there are errors.
					{
						preview = "There are errors within the text file. Please select the Error log" +
								" to view them and then reupload a file with no errors.";
					}
					
					else
					{
						Scanner readOutput = new Scanner(output);	//If there are no errors read the lines into the preview.
						while (readOutput.hasNextLine())
						{
							preview += (readOutput.nextLine() + "\n");
						}
					}
					
					textPane_1.setText(preview);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			if(event.getSource() == btnSaveFile)		//If the save file button is selected.
			{
				Scanner transfer = null;
				try
				{
					transfer = new Scanner(output);
				}
				catch (FileNotFoundException e1)
				{
					e1.printStackTrace();
				}
				
				ReadFile ofOutput = new ReadFile();
				File saveFilepath;
				PrintStream ps = null;
				
				try
				{
					ofOutput.select();
					saveFilepath = ofOutput.getCurrentSourceFile();
					ps = new PrintStream(saveFilepath);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				while (transfer.hasNextLine())
				{
					String nextLine = transfer.nextLine();
					ps.println(nextLine);
					ps.flush();
				}
				
				transfer.close();
				ps.close();
			}
			
			if(event.getSource() == rdbtnNewRadioButton)
			{
				if(rdbtnNewRadioButton.isSelected())	//If the radio button is selected then set to the error log.
				{
					lblNewLabel_1.setText("Error Log");
					textPane_1.setText(error);
				}
				else									//Else if it is deselected set to preview.
				{
					lblNewLabel_1.setText("Preview");
					textPane_1.setText(preview);
				}
			}
		}
	}
}