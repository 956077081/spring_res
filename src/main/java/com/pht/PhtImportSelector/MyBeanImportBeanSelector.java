package com.pht.PhtImportSelector;

import org.omg.CORBA.IMP_LIMIT;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyBeanImportBeanSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        annotationTypes.forEach(item-> System.out.println(item+"| selector"));//当前  import所在类上的注解

        return  new String[]{"com.pht.entity.Menu"};//返回需要注入的  类数组
//        return new String[0];
    }
}
