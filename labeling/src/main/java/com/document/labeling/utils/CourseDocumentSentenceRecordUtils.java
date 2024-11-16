package com.document.labeling.utils;

import com.document.labeling.daos.CourseDocumentSentenceRecordPutRequest;
import com.document.labeling.models.CourseDocumentSentenceRecord;

public class CourseDocumentSentenceRecordUtils {
    private CourseDocumentSentenceRecordUtils() {
    }

    public static CourseDocumentSentenceRecord getUpdatedCourseDocumentSentenceRecord(CourseDocumentSentenceRecord cdsr,
            CourseDocumentSentenceRecordPutRequest newCdsr) {
        CourseDocumentSentenceRecord updatedCdsr = new CourseDocumentSentenceRecord(cdsr.getId(),
                cdsr.getWords(), cdsr.getLabels());
        if (newCdsr.getWords() != null)
            updatedCdsr.setWords(newCdsr.getWords());
        if (newCdsr.getLabels() != null)
            updatedCdsr.setLabels(newCdsr.getLabels());
        if (updatedCdsr.equals(cdsr)) {
            return null;
        }
        return updatedCdsr;
    }
}
