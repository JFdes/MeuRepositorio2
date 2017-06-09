package br.com.myapp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ExceptionUtils {

	public static String removeClasseDeExceptionNaMensagem(final String message) {

		if (message == null) {
			return null;
		}

		final Pattern pattern = Pattern.compile("br\\.{1}.*: ");
		final Matcher matcher = pattern.matcher(message);

		return matcher.replaceAll(StringUtils.EMPTY);
	}
}
