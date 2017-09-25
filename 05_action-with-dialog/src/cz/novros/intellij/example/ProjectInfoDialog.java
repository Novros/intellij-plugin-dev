package cz.novros.intellij.example;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.*;

import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProjectInfoDialog extends JDialog {

	private static final int LAYOUT_GAP = 8;

	private final JLabel lblName = new JLabel();
	private final JLabel lblBasePath = new JLabel();
	private final JLabel lblLocationHash = new JLabel();
	private final JLabel lblPresentableUrl = new JLabel();
	private final JLabel lblProjectFilePath = new JLabel();
	private final JLabel lblIsDefault = new JLabel();
	private final JLabel lblIsInitialized = new JLabel();
	private final JLabel lblIsOpen = new JLabel();
	private final JButton btnShowProjectFile = new JButton("Show project file");
	private final JButton btnShowWorkspaceFile = new JButton("Show workspace file");
	private final JButton btnClose = new JButton("Close");

	private final Project project;

	public ProjectInfoDialog(@NotNull final Project project) {
		this.project = project;

		getRootPane().registerKeyboardAction(e -> dispose(),
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		designUi();
		setContent(project);
		assignListeners();

		setLocationRelativeTo(null);
		pack();
	}

	private void setContent(@NotNull final Project project) {
		lblName.setText(project.getName());
		lblBasePath.setText(project.getBasePath());
		lblLocationHash.setText(project.getLocationHash());
		lblPresentableUrl.setText(project.getPresentableUrl());
		lblProjectFilePath.setText(project.getProjectFilePath());
		lblIsDefault.setText(project.isDefault() ? "Yes" : "No");
		lblIsInitialized.setText(project.isInitialized() ? "Yes" : "No");
		lblIsOpen.setText(project.isOpen() ? "Yes" : "No");
	}

	private void assignListeners() {
		btnClose.addActionListener(e -> dispose());
		btnShowProjectFile.addActionListener(e -> openFileInEditor(project.getProjectFile()));
		btnShowWorkspaceFile.addActionListener(e -> openFileInEditor(project.getWorkspaceFile()));
	}

	/**
	 * Open file in project editor.
	 *
	 * @param file File which will be opened in editor.
	 */
	private void openFileInEditor(@Nullable final VirtualFile file) {
		if (file != null) {
			OpenFileDescriptor descriptor = new OpenFileDescriptor(project, file);
			descriptor.navigateInEditor(project, false);
		}
	}

	private void designUi() {
		getContentPane().setLayout(new BorderLayout(LAYOUT_GAP, LAYOUT_GAP));

		final JPanel twoColumnPanel = new JPanel(new HorizontalLayout(LAYOUT_GAP));
		final JPanel labelsPanel = createPanelWithLabels("Name: ", "Base path: ", "Location hash: ", "Presentable url: ",
				"Project file path: ", "Is default: ", "Is initialized: ", "Is open: ");
		final JPanel contentPanel = createPanelWithLabelValues(lblName, lblBasePath, lblLocationHash, lblPresentableUrl,
				lblProjectFilePath, lblIsDefault, lblIsInitialized, lblIsOpen);
		contentPanel.add(new JPanel(new FlowLayout(FlowLayout.CENTER)) {{
			add(btnShowProjectFile);
			add(btnShowWorkspaceFile);
		}});

		twoColumnPanel.add(labelsPanel);
		twoColumnPanel.add(contentPanel);

		final JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		footerPanel.add(btnClose);

		getContentPane().add(twoColumnPanel, BorderLayout.CENTER);
		getContentPane().add(footerPanel, BorderLayout.SOUTH);
	}

	private JPanel createPanelWithLabels(@NotNull final String... labels) {
		return createPanelWithLabelValues(
				Arrays.stream(labels)
						.map(this::createLabel)
						.toArray(JLabel[]::new)
		);
	}

	private JPanel createPanelWithLabelValues(@NotNull final JLabel... labels) {
		final JPanel contentPanel = new JPanel(new VerticalLayout(LAYOUT_GAP));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

		Arrays.stream(labels).forEach(contentPanel::add);

		return contentPanel;
	}

	private JLabel createLabel(@NotNull final String text) {
		final JLabel label = new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		return label;
	}
}
