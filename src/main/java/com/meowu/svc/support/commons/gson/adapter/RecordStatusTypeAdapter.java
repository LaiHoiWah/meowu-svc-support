package com.meowu.svc.support.commons.gson.adapter;

import com.google.gson.*;
import com.meowu.starter.commons.domain.TypeAdapter;
import com.meowu.starter.commons.security.constants.RecordStatus;

import java.lang.reflect.Type;

public class RecordStatusTypeAdapter implements TypeAdapter<RecordStatus>{

    @Override
    public Class<RecordStatus> getType(){
        return RecordStatus.class;
    }

    @Override
    public JsonElement serialize(RecordStatus status, Type type, JsonSerializationContext jsonSerializationContext){
        return status == null ? null : new JsonPrimitive(status.getCode());
    }

    @Override
    public RecordStatus deserialize(JsonElement element, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException{
        return element == null ? null : RecordStatus.getByCode(element.getAsJsonPrimitive().getAsString());
    }
}
