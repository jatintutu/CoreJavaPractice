package core.java.annotations.model;

import java.lang.annotation.Repeatable;

@Repeatable(Names.class)
public @interface Name {

	public String name() default "Jack";
}
