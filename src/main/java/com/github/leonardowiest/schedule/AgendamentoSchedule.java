package com.github.leonardowiest.schedule;

import java.util.List;

@FunctionalInterface
public interface AgendamentoSchedule {

	public abstract List<?> buscarXMLs();
}
