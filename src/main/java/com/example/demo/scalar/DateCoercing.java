package com.example.demo.scalar;

import com.netflix.graphql.dgs.DgsScalar;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@DgsScalar(name = "Date")
public class DateCoercing implements Coercing<Date, String> {
	private static final String PATTERN = "yyyy-MM-dd";

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
		if (o instanceof StringValue && Objects.nonNull(o)) {
			DateTime dateTime = new DateTime(((StringValue) o).getValue());
			return dateTime.toDate();
		}
		return null;
	}
}
