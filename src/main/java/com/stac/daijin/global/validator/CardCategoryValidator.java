package com.stac.daijin.global.validator;

import com.stac.daijin.domain.card.enums.CardCategory;
import com.stac.daijin.global.annotation.CardCategoryValid;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CardCategoryValidator implements ConstraintValidator<CardCategoryValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (CardCategory cardCategory : CardCategory.values() ) {
            if (value.equals(cardCategory.getValue())) {
                return true;
            }
        }
        return false;
    }
}
