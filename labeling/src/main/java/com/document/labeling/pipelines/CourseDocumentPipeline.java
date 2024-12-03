package com.document.labeling.pipelines;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CourseDocumentPipeline {
    private static String annotators = "tokenize";
    private static Properties properties;
    private static StanfordCoreNLP stanfordCoreNLP;

    private CourseDocumentPipeline() {
    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", annotators);
        properties.setProperty("ssplit.newlineIsSentenceBreak", "always");

    }

    public static StanfordCoreNLP getPipeline() {
        if (stanfordCoreNLP == null)
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        return stanfordCoreNLP;
    }

    

}
