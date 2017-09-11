package cz.novros.intellij.example;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "SaveService", storages = {@Storage("save-state-example.xml")})
public class SaveService implements PersistentStateComponent<SaveState> {

	private SaveState currentState = new SaveState("Example", 1);

	@Nullable
	@Override
	public SaveState getState() {
		return new SaveState(currentState.data, currentState.number);
	}

	@Override
	public void loadState(final SaveState saveState) {
		currentState = saveState;
	}

	public SaveState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(@NotNull final SaveState state) {
		currentState = state;
	}
}
