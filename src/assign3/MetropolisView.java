package assign3;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class MetropolisView extends JFrame {

	private static final String LARGER_THAN = "Population Larger Than";
	private static final String SMALLER_THAN = "Population Smaller Than";
	private static final String EQUAL_TO = "Population Equal To";
	private static final String EXACT_MATCH = "Exact Match";
	private static final String PARTIAL_MATCH = "Partial Match";
	private static final int TEXT_FIELD_LENGTH = 10;
	private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 450;
	private static final int PULLDOWN_WIDTH = 140;
	private static final int PULLDOWN_HEIGHT = 20;
	private static final int SCROLL_PANE_WIDTH = 300;
	private static final int SCROLL_PANE_HEIGHT = 200;

	private JPanel northPanel;
	private JPanel eastPanel;
	private JPanel comboBoxPanel;

	private JTextField metropolisField;
	private JTextField continentField;
	private JTextField populationField;

	private JButton addButton;
	private JButton searchButton;

	private JComboBox populationPulldown;
	private JComboBox matchTypePulldown;

	private MetropolisTableModel model;
	private JTable table;
	private JComponent content;


	public MetropolisView(String title) {
		super(title);

		model = new MetropolisTableModel();
		table = new JTable(model);
		content = (JComponent) getContentPane();


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(SCROLL_PANE_WIDTH, SCROLL_PANE_HEIGHT));
		content.add(scrollPane, FlowLayout.LEFT);


		northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		add(northPanel, BorderLayout.NORTH);

		metropolisField = new JTextField(TEXT_FIELD_LENGTH);
		continentField = new JTextField(TEXT_FIELD_LENGTH);
		populationField = new JTextField(TEXT_FIELD_LENGTH);

		northPanel.add(new JLabel("Metropolis: "));
		northPanel.add(metropolisField);
		northPanel.add(new JLabel("Continent: "));
		northPanel.add(continentField);
		northPanel.add(new JLabel("Population: "));
		northPanel.add(populationField);


		eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		content.add(eastPanel, BorderLayout.EAST);

		addButton = new JButton("Add");
		searchButton = new JButton("Search");
		eastPanel.add(addButton, BorderLayout.WEST);
		eastPanel.add(searchButton, BorderLayout.WEST);


		comboBoxPanel = new JPanel();
		comboBoxPanel.setBorder(new TitledBorder("Search Options"));
		comboBoxPanel.setPreferredSize(new Dimension(SCROLL_PANE_WIDTH / 2, SCROLL_PANE_HEIGHT / 2));


		populationPulldown = new JComboBox<>(new String[]{LARGER_THAN, SMALLER_THAN, EQUAL_TO});
		populationPulldown.setPreferredSize(new Dimension(PULLDOWN_WIDTH, PULLDOWN_HEIGHT));

		matchTypePulldown = new JComboBox<>(new String[]{EXACT_MATCH, PARTIAL_MATCH});
		matchTypePulldown.setPreferredSize(new Dimension(PULLDOWN_WIDTH, PULLDOWN_HEIGHT));

		comboBoxPanel.add(populationPulldown, BorderLayout.WEST);
		comboBoxPanel.add(matchTypePulldown, BorderLayout.WEST);
		eastPanel.add(comboBoxPanel);


		// Default stuff.
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setLocationByPlatform(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) {
		}
		new MetropolisView("Metropolis Viewer");
	}
}
