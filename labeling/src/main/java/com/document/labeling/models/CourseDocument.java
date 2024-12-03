package com.document.labeling.models;

import javax.persistence.Id;

import com.document.labeling.models.id.CourseDocumentId;

public class CourseDocument extends Base {
    @Id
    private CourseDocumentId id;
    private String name;
    private String description;

    public CourseDocument(CourseDocumentId id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CourseDocumentId getId() {
        return id;
    }

    public void setId(CourseDocumentId id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CourseDocument [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}
