package com.jcrexplorer.dto.value;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Binary;
import javax.jcr.PropertyType;
import javax.jcr.Value;

import org.apache.commons.io.IOUtils;

public class ValueUtils {
	public static String convert(Value value) throws Exception {
		switch (value.getType()) {
		case PropertyType.BINARY:
			Binary binary = value.getBinary();
			return IOUtils.toString(binary.getStream());
		case PropertyType.DATE:
			return  value.getDate().getTime().toLocaleString();
		case PropertyType.REFERENCE:
			// Not Implemented
			return "";
		case PropertyType.BOOLEAN:
			return Boolean.toString(value.getBoolean());
		case PropertyType.DECIMAL:
			return value.getDecimal().toString();
		case PropertyType.DOUBLE:
			return Double.toString(value.getDouble());
		case PropertyType.LONG:
			return Long.toString(value.getLong());
		default:
			return value.getString();
		}
	}

	public static List<String> convert(Value... values) throws Exception {
		List<String> valueList = new ArrayList<String>();
		for (Value v : values) {
			valueList.add(convert(v));
		}
		return valueList;
	}
}
