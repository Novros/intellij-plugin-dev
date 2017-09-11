package cz.novros.intellij.example;

import com.intellij.util.xmlb.annotations.Tag;

import org.jetbrains.annotations.NotNull;

public class SaveState {

	@Tag("data")
	public String data;

	@Tag("number")
	public int number;

	public SaveState() {
	}

	public SaveState(@NotNull final String data, final int number) {
		this.data = data;
		this.number = number;
	}
}
