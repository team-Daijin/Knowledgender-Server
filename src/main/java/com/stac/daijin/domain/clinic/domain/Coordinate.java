package com.stac.daijin.domain.clinic.domain;

import com.stac.daijin.domain.clinic.exception.IsNotInRangeClinicException;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coordinate {
    private static final double LATITUDE_LOWER_BOUND = 33;
    private static final double LATITUDE_UPPER_BOUND = 43;
    private static final double LONGITUDE_LOWER_BOUND = 124;
    private static final double LONGITUDE_UPPER_BOUND = 132;

    private String address;

    @Column(columnDefinition = "Decimal(18,15)")
    private double latitude;

    @Column(columnDefinition = "Decimal(18,15)")
    private double longitude;

    public static Coordinate of(double latitude, double longitude) {
        validateRange(latitude, longitude);

        return new Coordinate(latitude, longitude);
    }

    public static Coordinate of(double latitude, double longitude, String address) {
        validateRange(latitude, longitude);

        return new Coordinate(latitude, longitude, address);
    }

    private static void validateRange(double latitude, double longitude) {
        if (isNotInRange(latitude, longitude)) {
            throw IsNotInRangeClinicException.EXCEPTION;
        }
    }

    private static boolean isNotInRange(double latitude, double longitude) {
        return (latitude < LATITUDE_LOWER_BOUND || LATITUDE_UPPER_BOUND < latitude)
                || (longitude < LONGITUDE_LOWER_BOUND || LONGITUDE_UPPER_BOUND < longitude);
    }

    private Coordinate(double latitude, double longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    private Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
