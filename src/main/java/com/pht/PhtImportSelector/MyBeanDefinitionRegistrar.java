package com.pht.PhtImportSelector;

import com.pht.entity.Employe;
import com.pht.entity.Menu;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**a
 * 通过  BeanDefinitionRegister来注册bean
 */
public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if(registry.containsBeanDefinition("com.pht.entity.Menu")){
            BeanDefinition definition= new RootBeanDefinition(Employe.class);
            registry.registerBeanDefinition("employe",definition);
        }
    }
}
