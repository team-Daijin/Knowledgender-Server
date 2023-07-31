package com.stac.daijin.global.jpa;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
@RequiredArgsConstructor
public abstract class BaseUUIDEntity {

        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "BINARY(16)")
        protected UUID id;

}
