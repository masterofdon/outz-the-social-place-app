package com.outz.app.utils;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class StringSequenceIdentifier implements IdentifierGenerator, Configurable {

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

	}

	@Override
	public Serializable generate(SessionImplementor session, Object obj) {
		return OutzRandom.getRandomAlphaNumeric();
	}
}
