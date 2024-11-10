package com.document.labeling.daos;

import jakarta.validation.constraints.NotBlank;

public class CoursePostRequest {
    @NotBlank(message = "name field is required")
    private String name;
    private String description;

    public CoursePostRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
