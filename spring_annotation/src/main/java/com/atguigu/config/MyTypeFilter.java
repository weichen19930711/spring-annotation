package com.atguigu.config;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MyTypeFilter implements TypeFilter {

    /*
        metadataReader: 读取到的当前正在扫描的类的信息
        metadataReaderFactory: 可以获取到其他任何类信息的
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        metadataReader.getAnnotationMetadata();//注解信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();//类信息
        metadataReader.getResource();//获取当前类资源（比如：类的路径）

        String className = classMetadata.getClassName();
        System.out.println("---->"+className);
        String[] arrs = {"er", "ok"};
        if(some(Arrays.asList(arrs), className)) return true;
        return false;
    }

    public boolean some(List<String> arrs, String className) {
        return arrs.stream().anyMatch(x -> {
            System.out.println(x);
            return className.contains(x);
        });
    }
}
