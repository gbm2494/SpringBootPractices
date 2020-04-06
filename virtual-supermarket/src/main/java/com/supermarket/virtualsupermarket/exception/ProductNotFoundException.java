package com.supermarket.virtualsupermarket.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public ProductNotFoundException(String exception) {
        super(exception);
    }

    //Error handling added to be used in GraphQL
    public ProductNotFoundException(String message, Long invalidProductId) {
        super(message);
        extensions.put("invalidApplicationId", invalidProductId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

}