package com.milog.fm.annotation.processor.javac;

import com.milog.fm.annotation.processor.app.Log;
import com.milog.fm.annotation.processor.app.MyApp;
import com.milog.fm.annotation.processor.javac.handler.JavacAnnotationHandler;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miloway on 2018/7/19.
 * 处理和分发到对应的Handler
 */

public class JavacProcessor {

    public static void delegate(Context context, List<JavacNode> nodes) {
        TreeMaker treeMaker = TreeMaker.instance(context);

        HashMap<Class<? extends Annotation>, JavacAnnotationHandler> maps = MyApp.getAnnotationMap(context);
        for (JavacNode node : nodes) {
            for (Map.Entry<Class<? extends Annotation>, JavacAnnotationHandler> map : maps.entrySet()) {
                if (isAnnotationEqual(node.annotation, map.getKey())) {
                    Log.print("delegate handle ===============");
                    //node.classDecl.accept(new MiloTreeTranslator(context, messager, node));
                    ((JavacAnnotationHandler)map.getValue()).handle(treeMaker, node);

                }
            }
        }

    }

    public static boolean isAnnotationEqual(JCTree.JCAnnotation jcAnnotation, Class<? extends Annotation> annotation) {
        return jcAnnotation.type.tsym.toString().equals(annotation.getCanonicalName());
    }

}
