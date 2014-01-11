package com.jayway.jsonpath.spi.impl;

import java.io.InputStream;
import java.io.Reader;

import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.spi.Mode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

/**
 * @author Weiliang Shuai
 * @version 1.0
 */
public class JsonlibProvider extends AbstractJsonProvider {

    @Override
    public Mode getMode() {
        return Mode.SLACK;
    }

    @Override
    public Object parse(String json) throws InvalidJsonException {
        if (StringUtils.isEmpty(json)) {
            return new JSONObject();
        }

        if (json.startsWith("[")) {
            return JSONArray.fromObject(json);
        } else {
            return JSONObject.fromObject(json);
        }
    }

    @Override
    public Object parse(Reader jsonReader) throws InvalidJsonException {
        return JSONObject.fromObject(jsonReader);
    }

    @Override
    public Object parse(InputStream jsonStream) throws InvalidJsonException {
        return JSONObject.fromObject(jsonStream);
    }

    @Override
    public String toJson(Object obj) {
        return obj.toString();
    }

    @Override
    public Object createMap() {
        return new JSONObject();
    }

    @Override
    public Iterable createArray() {
        return new JSONArray();
    }

}
