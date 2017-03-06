package com.mb.middle.ware.setting;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SecretSetting {
	/**
	 * 
	 * @return
	 */
	boolean decrypt() default true;
}
