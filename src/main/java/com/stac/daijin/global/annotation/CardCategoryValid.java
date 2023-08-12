package com.stac.daijin.global.annotation;

import com.stac.daijin.global.validator.CardCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {CardCategoryValidator.class})
public @interface CardCategoryValid {

    String message() default "포함 되지 않는 카드뉴스 카테고리 입니다";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
