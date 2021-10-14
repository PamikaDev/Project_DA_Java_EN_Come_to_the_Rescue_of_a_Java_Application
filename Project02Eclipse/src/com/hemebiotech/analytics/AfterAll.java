/**
 * 
 */
package com.hemebiotech.analytics;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author WEB_DEV
 *
 * @since 5.0
 * @see BeforeAll
 * @see BeforeEach
 * @see AfterEach
 * @see Test
 * @see TestFactory
 * @see TestInstance
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AfterAll   {
}
