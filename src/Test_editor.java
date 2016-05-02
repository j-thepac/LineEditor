

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.TextArea;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Test_editor {

	JFrame frmRegexEditorBy;
	TextClass textclass;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Test_editor window = new Test_editor();
//					window.frmRegexEditorBy.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Test_editor() {
		//Test_editor window = new Test_editor();
		//this.frmRegexEditorBy.setVisible(set_visible);
		initialize();
		textclass=new TextClass();
		//Test_editor window = new Test_editor();
		//window.frmRegexEditorBy.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegexEditorBy = new JFrame();
		frmRegexEditorBy.setTitle("LineEditor By Deepak");
		frmRegexEditorBy.setBounds(100, 100, 450, 300);
		frmRegexEditorBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{380, 0};
		gridBagLayout.rowHeights = new int[]{160, 25, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		frmRegexEditorBy.getContentPane().setLayout(gridBagLayout);
		
		final TextArea textArea = new TextArea();
		textArea.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				textclass.set_CurrentString(textArea.getText());
				
			}
		});
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		frmRegexEditorBy.getContentPane().add(textArea, gbc_textArea);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.NORTH;
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 1;
		frmRegexEditorBy.getContentPane().add(toolBar, gbc_toolBar);
		
		Button button_1 = new Button("Original");
		button_1.setActionCommand("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.setText(textclass.get_OriginalString());
			}
		});
		toolBar.add(button_1);
		
		Button button_2 = new Button("Line Break");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textclass.break_line(JOptionPane.showInputDialog("Enter character or string")));
			}
		});
		toolBar.add(button_2);
		
		Button button_4 = new Button("Line Number");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textclass.add_Linenumber());
			}
		});
		
		Button button = new Button("Del BlankLine");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textclass.remove_blank());
			}
		});
		toolBar.add(button);
		toolBar.add(button_4);
		
		Button button_3 = new Button("Sentence Case");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textclass.sentence_case());
			}
		});
		button_3.setActionCommand("");
		toolBar.add(button_3);
	}
}
