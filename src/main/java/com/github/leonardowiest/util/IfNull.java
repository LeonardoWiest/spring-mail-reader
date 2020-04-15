package com.github.leonardowiest.util;

public final class IfNull {

	public final static <T> T get(T value, T otherValue) {

		if (value == null) {
			return otherValue;
		}

		return value;
	}
}
