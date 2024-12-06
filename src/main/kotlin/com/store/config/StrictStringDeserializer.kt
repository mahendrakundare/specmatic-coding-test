package com.store.config


import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer


class StrictStringDeserializer : JsonDeserializer<String>() {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): String {
        val token = p.currentToken
        if (token != JsonToken.VALUE_STRING) {
            throw ctxt.mappingException("Expected a string value, but got $token")
        }
        return p.text
    }
}
