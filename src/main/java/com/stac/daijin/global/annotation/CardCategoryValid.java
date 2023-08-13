package com.stac.daijin.global.annotation;

import com.stac.daijin.global.validator.CardCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CardCategoryValidator.class})
public @interface CardCategoryValid {

    String message() default "포함 되지 않는 카드뉴스 카테고리 입니다";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
