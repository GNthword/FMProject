package com.milog.fm.annotation.processor;

import com.milog.fm.annotation.processor.app.Log;
import com.milog.fm.annotation.processor.app.MyApp;
import com.milog.fm.annotation.processor.javac.MiloProcessor;
import com.sun.tools.javac.main.JavaCompiler;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

//@SupportedAnnotationTypes("*")
public class FMAnnotationProcessor extends AbstractProcessor{

    private MiloProcessor processor;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        processor = new MiloProcessor();
        processor.init(processingEnv);
        messager = processingEnv.getMessager();
        MyApp.init(messager);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            MyApp.destroy();
            return false;
        }
        Log.print(Diagnostic.Kind.NOTE, "" + JavaCompiler.version());
        processor.process(annotations, roundEnv);
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return MyApp.getAnnotations();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
