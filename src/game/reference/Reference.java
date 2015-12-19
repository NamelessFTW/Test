//Ivan Ribeiro
//10 Dec 2015

package game.reference;

import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.input.KeyCode;

public class Reference
{
	public static KeyCode[] assignedKeys = {KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D};
	static Path path = Paths.get("");
	public static final String baseImageLocation = path.toAbsolutePath().toString();
}
