package com.example.demo.scalar;

import com.netflix.graphql.dgs.DgsScalar;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@DgsScalar(name = "Date")
public class DateCoercing implements Coercing<Date, String> {
	private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

	@Override
	public String serialize(Object o) throws CoercingSerializeException {
		if (o instanceof Date && Objects.nonNull(o)) {
			Date date = (Date)o;
			SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
			return sdf.format(date);
		}
		return null;
	}

	@Override
	public Date parseValue(Object o) throws CoercingParseValueException {
		if (o instanceof Date && Objects.nonNull(o)) {
			return (Date)o;
		} else {
			throw new CoercingParseValueException("type is not date ");
		}
	}

	@Override
	public Date parseLiteral(Object o) throws CoercingParseLiteralException {
		if (o instanceof String && Objects.nonNull(o)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
			LocalDateTime localDateTime = LocalDateTime.parse(o.toString(), formatter);
			return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		}
		return null;
	}
}
