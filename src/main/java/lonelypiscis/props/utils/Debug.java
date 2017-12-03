package lonelypiscis.props.utils;

import java.lang.reflect.Field;

import javax.annotation.CheckForNull;

public class Debug {
	public static boolean enabled = true;

	/**
	 * Checks if all fields marked by the @Check annotation are not null and
	 * therefor properly set.
	 * 
	 * @param object
	 * @return
	 */

	public static boolean areCheckableFieldsSet(Object object) {
		for (Field field : object.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Check.class)) {
				try {
					if (field.get(object) == null)
						return false;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		}

		return true;
	}
}
