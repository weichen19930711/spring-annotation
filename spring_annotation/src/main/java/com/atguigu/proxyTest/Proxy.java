package com.atguigu.proxyTest;

import com.atguigu.proxy.Bird;
import com.atguigu.proxy.FlyAble;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Proxy  {


  /*public static Object newProxyInstance() throws Exception {
    TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
            .addSuperinterface(FlyAble.class);

    FieldSpec fieldSpec = FieldSpec.builder(FlyAble.class, "flyable", Modifier.PRIVATE).build();
    typeSpecBuilder.addField(fieldSpec);

    MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PUBLIC)
            .addParameter(FlyAble.class, "flyable")
            .addStatement("this.flyable = flyable")
            .build();
    typeSpecBuilder.addMethod(constructorMethodSpec);

    Method[] methods = FlyAble.class.getDeclaredMethods();
    for (Method method : methods) {
      MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
              .addModifiers(Modifier.PUBLIC)
              .addAnnotation(Override.class)
              .returns(method.getReturnType())
              .addStatement("long start = $T.currentTimeMillis()", System.class)
              .addCode("\n")
              .addStatement("this.flyable." + method.getName() + "()")
              .addCode("\n")
              .addStatement("long end = $T.currentTimeMillis()", System.class)
              .addStatement("$T.out.println(\"Fly Time =\" + (end - start))", System.class)
              .build();
      typeSpecBuilder.addMethod(methodSpec);
    }

    JavaFile javaFile = JavaFile.builder("com.atguigu.proxyTest", typeSpecBuilder.build()).build();
    // 为了看的更清楚，我将源码文件生成到桌面
//    String sourcePath = "D://test";
    String sourcePath = "D://Projects//spring-annotation//spring-annotation//spring_annotation//src//main//java";
    javaFile.writeTo(new File(sourcePath));

    JavaCompiler.compile(new File(sourcePath + "/com/atguigu/proxyTest/TimeProxy.java"));

    URL[] urls = new URL[] {new URL("file:/" + sourcePath)};
    URLClassLoader classLoader = new URLClassLoader(urls);
    Class clazz = classLoader.loadClass("com.atguigu.proxyTest.TimeProxy");
    Constructor constructor = clazz.getConstructor(FlyAble.class);
    FlyAble flyable = (FlyAble) constructor.newInstance(new Bird());
    flyable.fly();

    return null;
  }*/
  public static Object newProxyInstance(Class clazz, InvocationHandler handle) throws Exception {
    TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
            .addSuperinterface(clazz);

    FieldSpec fieldSpec = FieldSpec.builder(InvocationHandler.class, "handler", Modifier.PRIVATE).build();
    typeSpecBuilder.addField(fieldSpec);

    MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PUBLIC)
            .addParameter(InvocationHandler.class, "handler")
            .addStatement("this.handler = handler")
            .build();
    typeSpecBuilder.addMethod(constructorMethodSpec);

    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
              .addModifiers(Modifier.PUBLIC)
              .addAnnotation(Override.class)
              .returns(method.getReturnType())
              .addCode("try {\n")
              .addStatement("\t$T method = " + clazz.getName() + ".class.getMethod(\"" + method.getName() + "\")", Method.class)
              // 为了简单起见，这里参数直接写死为空
              .addStatement("\tthis.handler.invoke(this, method, null)")
              .addCode("} catch(Exception e) {\n")
              .addCode("\te.printStackTrace();\n")
              .addCode("}\n")
              .build();
      typeSpecBuilder.addMethod(methodSpec);
    }

    JavaFile javaFile = JavaFile.builder("com.atguigu.proxyTest", typeSpecBuilder.build()).build();
    // 为了看的更清楚，我将源码文件生成到桌面
//    String sourcePath = "D://test";
    String sourcePath = "D://Projects//spring-annotation//spring-annotation//spring_annotation//src//main//java";
    javaFile.writeTo(new File(sourcePath));

    //编译
    JavaCompiler.compile(new File(sourcePath + "/com/atguigu/proxyTest/TimeProxy.java"));

    //使用反射load到内存
    URL[] urls = new URL[] {new URL("file:/" + sourcePath)};
    URLClassLoader classLoader = new URLClassLoader(urls);
    Class clazz1 = classLoader.loadClass("com.atguigu.proxyTest.TimeProxy");
    Constructor constructor = clazz1.getConstructor(InvocationHandler.class);
    Object obj = constructor.newInstance(handle);

    return obj;
  }
}
