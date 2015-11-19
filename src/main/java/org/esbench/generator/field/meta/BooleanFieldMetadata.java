package org.esbench.generator.field.meta;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.esbench.config.ConfigurationConstants;
import org.esbench.generator.field.FieldConstants;

import com.fasterxml.jackson.annotation.JsonProperty;

//@TODO - implement rest of the configuration
public class BooleanFieldMetadata extends FieldMetadata {
	public enum Type {
		ALWAYS_TRUE, ALWAYS_FALSE, TICK_TOCK
	};

	@JsonProperty(value = ConfigurationConstants.TOKENS_PROP)
	private Type booleanType;

	public BooleanFieldMetadata() {
	}

	public BooleanFieldMetadata(String name) {
		this(name, FieldConstants.SINGLE_VALUE, Type.TICK_TOCK);
	}

	public BooleanFieldMetadata(String name, int valuesPerDoc, Type type) {
		super(name, MetaType.BOOLEAN, valuesPerDoc);
		Validate.notNull(type);
		this.booleanType = type;
	}

	public Type getBooleanType() {
		return booleanType;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

	public void setBooleanType(Type type) {
		this.booleanType = type;
	}

}
