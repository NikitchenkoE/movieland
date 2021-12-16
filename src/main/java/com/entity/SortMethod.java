package com.entity;

public enum SortMethod {
    ASC("asc"),
    DESC("desc");

    SortMethod(String method) {
        this.method = method;
    }
    private final String method;

    public String getMethod() {
        return method;
    }

    static public SortMethod valueOfIgnoreCase(String value) {
        for (SortMethod method : SortMethod.values()) {
            if ( method.name().equalsIgnoreCase(value) ) return method;
        }
       throw new RuntimeException("Unsupported method " + value);
    }
}
