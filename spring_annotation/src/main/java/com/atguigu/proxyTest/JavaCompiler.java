package com.atguigu.proxyTest;

import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JavaCompiler {

  public static void compile(File javaFile) throws IOException {
    javax.tools.JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
    Iterable iterable = fileManager.getJavaFileObjects(javaFile);
    String compilePath = "D://Projects//spring-annotation//spring-annotation//spring_annotation//target//classes//com//atguigu//proxyTest//TimeProxy.class";
    /*Writer writer = new FileWriter(new File(compilePath));*/
    javax.tools.JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
    task.call();
    fileManager.close();
  }
}
