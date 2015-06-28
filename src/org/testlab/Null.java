package org.testlab;

import org.eclipse.jdt.annotation.*;

public class Null {
	private @NonNull String nonNullFunc(@Nullable final String input) {
		return String.valueOf(input.length());
	}

	public void useNotNullFunc() {
		if (nonNullFunc(null) == null)
			System.out.println("null");
		else
			System.out.println("not null");
	}

	public static void main(final String[] args) {
		new Null().useNotNullFunc();
	}

}
