package cz.novros.intellij.example;

import java.awt.BorderLayout;

import javax.swing.*;

public class View extends JPanel {

	public View() {
		setLayout(new BorderLayout());

		final JLabel helloLabel = new JLabel("Hello from toolbar gui");
		helloLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		helloLabel.setHorizontalAlignment(SwingConstants.CENTER);

		add(helloLabel);
	}
}
