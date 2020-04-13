package com.github.leonardowiest.schedule.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.github.leonardowiest.schedule.AgendamentoSchedule;
import com.github.leonardowiest.service.LeituraEmailService;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@EnableScheduling
@Configuration
public class AgendamentoScheduleImpl implements AgendamentoSchedule {

	@Autowired
	private LeituraEmailService leituraEmailService;

	@PostConstruct
	public void init() {

		System.out.println("Bean AgendamentoScheduleImpl registrado.");
	}

	@Scheduled(fixedDelay = 5000)
	@Override
	public List<?> buscarXMLs() {

		leituraEmailService.ler();

		return Collections.emptyList();
	}

}
