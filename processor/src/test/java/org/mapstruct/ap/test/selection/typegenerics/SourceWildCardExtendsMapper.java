/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.selection.typegenerics;

import java.math.BigInteger;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SourceWildCardExtendsMapper {

    SourceWildCardExtendsMapper INSTANCE = Mappers.getMapper( SourceWildCardExtendsMapper.class );

    Target map( Source source);

    default String unwrap(Wrapper<? extends Number> t) {
        return t.getWrapped().toString();
    }

    class Source {

        private final Wrapper<BigInteger> prop;

        public Source(Wrapper<BigInteger> prop) {

            this.prop = prop;
        }

        public Wrapper<BigInteger> getProp() {
            return prop;
        }
    }

    class Wrapper<T> {

        private final T wrapped;

        public Wrapper(T wrapped) {
            this.wrapped = wrapped;
        }

        public T getWrapped() {
            return wrapped;
        }

    }

    class Target {

        private String prop;

        public String getProp() {
            return prop;
        }

        public Target setProp(String prop) {
            this.prop = prop;
            return this;
        }
    }

}
