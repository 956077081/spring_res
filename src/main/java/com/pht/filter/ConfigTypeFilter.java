package com.pht.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

public class ConfigTypeFilter  implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata metadata = metadataReader.getAnnotationMetadata();//当前注解信息
        //当前扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //当前资源信息 （类路径）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println(className);
        if(className.contains("Service")){
            System.out.println("truee"+className);
            return true;//返回true 进行注册
        }
        return false;

    }
}
