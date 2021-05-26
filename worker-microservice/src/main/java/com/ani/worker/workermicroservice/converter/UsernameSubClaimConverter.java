package com.ani.worker.workermicroservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.MappedJwtClaimSetConverter;

import java.util.Collections;
import java.util.Map;

public class UsernameSubClaimConverter implements Converter< Map<String, Object>,Map<String, Object> > {

    private final MappedJwtClaimSetConverter delegate = MappedJwtClaimSetConverter.withDefaults(Collections.emptyMap());

    @Override
    public Map<String, Object> convert(Map<String, Object> claims) {
        Map<String, Object> convertedClaims = this.delegate.convert(claims);
        String userName = (String) convertedClaims.get("preferred_username");
        convertedClaims.put("sub", userName);
        return convertedClaims;
    }
}
