package main;
import java.lang.Object.*;

public class KeyboardInput {

	int numberOfCodes = 39;
	private int[] keyCodes = new int[] { 38, 37, 40, 39, 32, 17, 18, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120,
			121, 122, 123, 521, 10, 20, 92, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 83, 71, 70, 27, 73, 76 };
	private String[] keyStrings = new String[] { "Up", "Left", "Down", "Right", "Space", "Ctrl", "Alt", "/", "F1", "F2",
			"F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "+", "Enter", "Caps", "\\", "Zero", "One",
			"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "s", "g","f", "ESC", "i", "l" };

	public static final int UP = 38;
	public static final int LEFT = 37;
	public static final int DOWN = 40;
	public static final int RIGHT = 39;
	public static final int SPACE = 32;
	public static final int CTRL = 17;
	public static final int ALT = 18;
	public static final int SLASH = 111;
	public static final int F1 = 112;
	public static final int F2 = 113;
	public static final int F3 = 114;
	public static final int F4 = 115;
	public static final int F5 = 116;
	public static final int F6 = 117;
	public static final int F7 = 118;
	public static final int F8 = 119;
	public static final int F9 = 120;
	public static final int F10 = 121;
	public static final int F11 = 122;
	public static final int F12 = 123;
	public static final int PLUS = 521;
	public static final int ENTER = 10;
	public static final int CAPS = 20;
	public static final int BACKSLASH = 92;
	public static final int ZERO = 48;
	public static final int ONE = 49;
	public static final int TWO = 50;
	public static final int THREE = 51;
	public static final int FOUR = 52;
	public static final int FIVE = 53;
	public static final int SIX = 54;
	public static final int SEVEN = 55;
	public static final int EIGHT = 56;
	public static final int NINE = 57;
	public static final int ESC = 27;
	public static final int S = 83;
	public static final int G = 71;
	public static final int F = 70;
	public static final int I = 73;
	public static final int L = 76;

	public KeyboardInput() {
		System.out.println("KeyboardInput class present and working (hopefully)");
	}

	public String getKeyString(int keyCode) {
		return keyStrings[indexOf(keyCodes, numberOfCodes, keyCode)];
	}

	public int getKeyCode(String keyString) {
		return keyCodes[indexOf(keyStrings, numberOfCodes, keyString)];
	}

	private int indexOf(int[] list, int listLength, int c) {
		for (int i = 0; i < listLength; i++)
			if (list[i] == c)
				return i;
		return -1;
	}

	private int indexOf(String[] list, int listLength, String c) {
		for (int i = 0; i < listLength; i++)
			if (list[i] == c)
				return i;
		return -1;
	}
}
