package com.github.leonardowiest.factory;

import java.util.List;

@FunctionalInterface
public interface LeituraEmailFactory {

	public abstract List<?> read();
}
