package com.softserveinc.ita.redplatform.common.dto;

/**
 * The Class FieldDTO.
 */
public class FieldDTO {
    
    /** The field. */
    private String field;
    
    /** The message. */
    private String message;
 
    /**
     * Instantiates a new field dto.
     *
     * @param newField the field
     * @param newMessage the message
     */
    public FieldDTO(final String newField, final String newMessage) {
        this.field = newField;
        this.message = newMessage;
    }

    /**
     * Gets the field.
     *
     * @return the field
     */
    public final String getField() {
        return field;
    }

    /**
     * Sets the field.
     *
     * @param newField the new field
     */
    public final void setField(final String newField) {
        this.field = newField;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param newMessage the new message
     */
    public final void setMessage(final String newMessage) {
        this.message = newMessage;
    }
   
}
