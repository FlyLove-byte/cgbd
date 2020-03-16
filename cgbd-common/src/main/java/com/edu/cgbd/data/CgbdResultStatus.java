package com.edu.cgbd.data;

public enum CgbdResultStatus {
    Ok("Ok", 200),
    Created("Created", 201),
    No_Content("No Content", 204),
    Bad_Request("Bad Request", 400),
    Unauthorized("Unauthorized", 401),
    Forbidden("Forbidden", 403),
    Not_Found("Not Found", 404),
    Unknown_Error("Unknown Error", 500);

    private String description;
    private int code;

    CgbdResultStatus(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return description;
    }
}
