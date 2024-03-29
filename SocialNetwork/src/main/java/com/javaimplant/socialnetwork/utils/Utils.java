package com.javaimplant.socialnetwork.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils {
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}
