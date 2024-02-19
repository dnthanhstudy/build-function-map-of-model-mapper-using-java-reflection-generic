package com.laptrinhjavaweb.modelmapper;

import java.lang.reflect.Field;

public class ConfigModelMapper {

	public <T> T map(Object source, Class<T> destination) {
		try {
			Class<?> classOfSource = source.getClass();
			
			T result = destination.newInstance();

			Field fieldsOfSrc[] = classOfSource.getDeclaredFields();
			Field fieldsOfDes[] = destination.getDeclaredFields();
			
			for (Field fieldOfSrc : fieldsOfSrc) {
				fieldOfSrc.setAccessible(true);

				String fieldNameOfSrc = fieldOfSrc.getName();
				Object fieldTypeOfSrc = fieldOfSrc.getType();
				Object value = fieldOfSrc.get(source);
				

				for (Field fieldOfDes : fieldsOfDes) {
					fieldOfDes.setAccessible(true);

					String fieldNameOfDes = fieldOfDes.getName();
					Object fieldTypeOfDes = fieldOfDes.getType();

					if (fieldNameOfDes.equals(fieldNameOfSrc) && fieldTypeOfDes.equals(fieldTypeOfSrc)) {	
						fieldOfDes.set(result, value);
						break;
					}
				}
			}
			return result;
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
}
