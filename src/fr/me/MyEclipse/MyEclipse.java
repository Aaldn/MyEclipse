package fr.me.MyEclipse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

@SuppressWarnings("serial")
public class MyEclipse extends JFrame {

	private static final long serialVersionUID = -3128399604207420276L;

	private JLabel labelDatetime = new JLabel();

	private Action actNewFile = new AbstractAction() {
		{
			putValue(NAME, "New");
			putValue(SMALL_ICON, new ImageIcon("menuBar/new.png"));
			putValue(SHORT_DESCRIPTION, "New File (CTRL+N)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_N);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MyEclipse.this, "New file created");
		}
	};
	private Action actOpenFile = new AbstractAction() {
		{
			putValue(NAME, "Open File...");
			putValue(SMALL_ICON, new ImageIcon("menuBar/open.png"));
			putValue(SHORT_DESCRIPTION, "Open File...");
			putValue(MNEMONIC_KEY, KeyEvent.VK_PERIOD);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actSave = new AbstractAction() {
		{
			putValue(NAME, "Save");
			putValue(SMALL_ICON, new ImageIcon("menuBar/save.png"));
			putValue(SHORT_DESCRIPTION, "Save (CTRL+S)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_S);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actSaveAs = new AbstractAction() {
		{
			putValue(NAME, "Save As...");
			putValue(SMALL_ICON, new ImageIcon("menuBar/save_as.png"));
			putValue(SHORT_DESCRIPTION, "Save As...");
			putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actExit = new AbstractAction() {
		{
			putValue(NAME, "Exit");
			putValue(SMALL_ICON, new ImageIcon("menuBar/exit.png"));
			putValue(SHORT_DESCRIPTION, "Exit (ALT+F4)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_X);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int closingOption = JOptionPane.showConfirmDialog(MyEclipse.this, "Souhaitez-vous quittez l'app ?",
					"Quittez l'app ?",
					JOptionPane.YES_NO_OPTION);
			if (closingOption == JOptionPane.YES_OPTION) {
				MyEclipse.this.dispose();
			}
		}
	};
	private Action actUndo = new AbstractAction() {
		{
			putValue(NAME, "Undo Typing");
			putValue(SMALL_ICON, new ImageIcon("menuBar/undo.png"));
			putValue(SHORT_DESCRIPTION, "Undo (CTRL+Z)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_U);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actRedo = new AbstractAction() {
		{
			putValue(NAME, "Redo");
			putValue(SMALL_ICON, new ImageIcon("menuBar/redo.png"));
			putValue(SHORT_DESCRIPTION, "Redo (CTRL+Y)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_R);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actCopy = new AbstractAction() {
		{
			putValue(NAME, "Copy");
			putValue(SMALL_ICON, new ImageIcon("menuBar/copy.png"));
			putValue(SHORT_DESCRIPTION, "New File (CTRL+C)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_C);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actCut = new AbstractAction() {
		{
			putValue(NAME, "Cut");
			putValue(SMALL_ICON, new ImageIcon("menuBar/cut.png"));
			putValue(SHORT_DESCRIPTION, "Cut (CTRL+X)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_X);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actPaste = new AbstractAction() {
		{
			putValue(NAME, "Paste");
			putValue(SMALL_ICON, new ImageIcon("menuBar/paste.png"));
			putValue(SHORT_DESCRIPTION, "Paste (CTRL+V)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_V);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actNewWindow = new AbstractAction() {
		{
			putValue(NAME, "New Window");
			// putValue(SMALL_ICON, new ImageIcon("menuBar/.png"));
			putValue(SHORT_DESCRIPTION, "New Window");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new MyEclipse().setVisible(true);
		}
	};
	private Action actZoomIn = new AbstractAction() {
		{
			putValue(NAME, "Zoom In");
			// putValue(SMALL_ICON, new ImageIcon("menuBar/.png"));
			putValue(SHORT_DESCRIPTION, "Zoom In (CTRL+)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_I);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actZoomOut = new AbstractAction() {
		{
			putValue(NAME, "Zoom Out");
			// putValue(SMALL_ICON, new ImageIcon("menuBar/.png"));
			putValue(SHORT_DESCRIPTION, "Zoom Out (CTRL-)");
			putValue(MNEMONIC_KEY, KeyEvent.VK_O);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actFullScreen = new AbstractAction() {
		{
			putValue(NAME, "Toggle Full Screen");
			putValue(SHORT_DESCRIPTION, "Full Screen ()");
			putValue(MNEMONIC_KEY, KeyEvent.VK_N);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F11, KeyEvent.ALT_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			MyEclipse.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
	};
	private Action actPreference = new AbstractAction() {
		{
			putValue(NAME, "Preferences");
			putValue(SHORT_DESCRIPTION, "Preferences");
			putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
	private Action actAboutEclipse = new AbstractAction() {
		{
			putValue(NAME, "About Eclipse");
			putValue(SMALL_ICON, new ImageIcon("menuBar/eclipse.png"));
			putValue(SHORT_DESCRIPTION, "About Eclipse");
			putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Runtime.getRuntime().exec("firefox https://www.eclipse.org/");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	};

	public MyEclipse() {
		super("My App");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("menuBar/.face").getImage());

		JPanel contentPane = (JPanel) this.getContentPane();

		JScrollPane scrollCodeEditor = new JScrollPane(createCodeEditor());
		JScrollPane scrollTerminal = new JScrollPane(createTerminal());
		JScrollPane scrollTreeProjects = createTreeProjects();
		JScrollPane scrollOutline = createTreeProjects();

		JTabbedPane leftTreeTab = new JTabbedPane();
		leftTreeTab.addTab("Package", scrollTreeProjects);
		leftTreeTab.addTab("Type Hierarchy", createTreeProjects());

		JSplitPane middleSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollCodeEditor, scrollTerminal);
		middleSplitPane.setResizeWeight(0.80);
		JSplitPane leftSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftTreeTab, middleSplitPane);
		leftSplitPane.setResizeWeight(0.10);
		JSplitPane mainSplitPain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSplitPane, scrollOutline);
		mainSplitPain.setResizeWeight(0.95);

		this.setJMenuBar(createMenuBar());
		contentPane.add(createToolBar(), BorderLayout.NORTH);
		contentPane.add(mainSplitPain);
		contentPane.add(createStatusBar(), BorderLayout.SOUTH);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				int closingOption = JOptionPane.showConfirmDialog(MyEclipse.this, "Souhaitez-vous quittez l'app ?",
						"Quittez l'app ?",
						JOptionPane.YES_NO_OPTION);
				if (closingOption == JOptionPane.YES_OPTION) {
					MyEclipse.this.dispose();
				}
			}
		});

	}

	private JMenuBar createMenuBar() {

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createMenuFile());
		menuBar.add(createMenuEdit());
		menuBar.add(createMenuWindow());
		menuBar.add(createMenuHelp());
		return menuBar;
	}

	private JMenu createMenuFile() {
		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic('F');

		menuFile.add(actNewFile);
		menuFile.add(actOpenFile);

		menuFile.addSeparator();

		menuFile.add(actSave);
		menuFile.add(actSaveAs);

		menuFile.addSeparator();

		menuFile.add(actExit);

		return menuFile;
	}

	private JMenu createMenuEdit() {

		JMenu menuEdit = new JMenu("Edit");
		menuEdit.setMnemonic('E');

		menuEdit.add(actUndo);
		menuEdit.add(actRedo);

		menuEdit.addSeparator();

		menuEdit.add(actCut);
		menuEdit.add(actCopy);
		menuEdit.add(actPaste);

		return menuEdit;
	}

	private JMenu createMenuWindow() {

		JMenu menuWindow = new JMenu("Window");
		menuWindow.setMnemonic('W');

		menuWindow.add(actNewWindow);

		menuWindow.addSeparator();

		JMenu menuItemEditor = new JMenu("Editor");
		menuItemEditor.setMnemonic('E');
		menuWindow.add(menuItemEditor);

		menuItemEditor.add(actZoomIn);
		menuItemEditor.add(actZoomOut);

		JMenu menuItemAppearance = new JMenu("Appearance");
		menuItemAppearance.setMnemonic('a');
		menuWindow.add(menuItemAppearance);

		menuItemAppearance.add(actFullScreen);

		menuWindow.addSeparator();

		menuWindow.add(actPreference);

		return menuWindow;
	}

	private JMenu createMenuHelp() {

		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic('H');

		menuHelp.add(actAboutEclipse);

		return menuHelp;
	}

	private JPanel createToolBar() {
		JPanel mainToolbar = new JPanel(new BorderLayout());

		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);

		toolbar.add(actNewFile);
		toolbar.add(actOpenFile);

		toolbar.addSeparator();

		toolbar.add(actSave);
		toolbar.add(actSaveAs);

		toolbar.addSeparator();

		toolbar.add(actExit);

		toolbar.addSeparator();

		toolbar.add(actUndo);
		toolbar.add(actRedo);

		toolbar.addSeparator();

		toolbar.add(actCut);
		toolbar.add(actCopy);
		toolbar.add(actPaste);

		toolbar.addSeparator();

		toolbar.add(actAboutEclipse);

		mainToolbar.add(toolbar, BorderLayout.WEST);

		mainToolbar.add(createSchemeSelector());

		return mainToolbar;
	}

	private JScrollPane createTreeProjects() {
		JScrollPane treeProjects = new JScrollPane(new JTree());
		return treeProjects;
	}

	private JTextArea createCodeEditor() {
		JTextArea codeEditor = new JTextArea("Let's code !");
		JPopupMenu popupMenu = createPopopMenu();
		codeEditor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger())
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		return codeEditor;
	}

	private JPanel createSchemeSelector() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton lightModeBtn = new JButton("Light Mode");
		JButton darkModeBtn = new JButton("Dark Mode");

		lightModeBtn.setBackground(Color.WHITE);
		darkModeBtn.setBackground(Color.BLACK);
		lightModeBtn.setForeground(Color.BLACK);
		darkModeBtn.setForeground(Color.WHITE);

		lightModeBtn.addActionListener((e) -> {
			lightModeBtn.setForeground(Color.RED);
			darkModeBtn.setForeground(Color.WHITE);
		});
		darkModeBtn.addActionListener((e) -> {
			lightModeBtn.setForeground(Color.BLACK);
			darkModeBtn.setForeground(Color.RED);
		});

		panel.add(lightModeBtn);
		panel.add(darkModeBtn);
		return panel;
	}

	private JPanel createStatusBar() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
		JLabel label1 = new JLabel("Writable");
		JLabel label2 = new JLabel("Smart Insert");
		JLabel label3 = labelDatetime;
		actualizeTime();
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		return panel;
	}

	private JTextArea createTerminal() {
		JTextArea terminal = new JTextArea("Let's run new commands");
		return terminal;
	}

	private JPopupMenu createPopopMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		popupMenu.add(actNewFile);
		popupMenu.add(actOpenFile);

		popupMenu.addSeparator();

		popupMenu.add(actSave);
		popupMenu.add(actSaveAs);

		popupMenu.addSeparator();

		popupMenu.add(actExit);

		popupMenu.addSeparator();

		popupMenu.add(actUndo);
		popupMenu.add(actRedo);

		popupMenu.addSeparator();

		popupMenu.add(actCut);
		popupMenu.add(actCopy);
		popupMenu.add(actPaste);

		popupMenu.addSeparator();

		popupMenu.add(actNewWindow);

		popupMenu.addSeparator();

		popupMenu.add(actZoomIn);
		popupMenu.add(actZoomOut);

		popupMenu.addSeparator();

		popupMenu.add(actFullScreen);

		popupMenu.addSeparator();

		popupMenu.add(actPreference);

		popupMenu.addSeparator();

		popupMenu.add(actAboutEclipse);

		return popupMenu;
	}

	private void actualizeTime() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			Pattern pattern = Pattern.compile("\\b\\d{2}:\\d{2}:\\d{2}\\b");

			@Override
			public void run() {
				if (!MyEclipse.this.isVisible())
					timer.cancel();
				String currentDate = Calendar.getInstance().getTime().toString();
				Matcher matcher = pattern.matcher(currentDate);
				if (matcher.find())
					labelDatetime.setText(matcher.group());
			}
		}, 100, 1000); // delay 100 to set the frame visible first
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JFrame myEclipseWindow = new MyEclipse();
		myEclipseWindow.setVisible(true);
	}

}