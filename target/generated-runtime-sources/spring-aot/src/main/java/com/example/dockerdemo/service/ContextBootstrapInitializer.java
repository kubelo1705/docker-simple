package com.example.dockerdemo.service;

import com.example.dockerdemo.repository.StudentRepository;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerStudentServiceImp(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("studentServiceImp", StudentServiceImp.class)
        .instanceSupplier((instanceContext) -> {
          StudentServiceImp bean = new StudentServiceImp();
          instanceContext.field("repository", StudentRepository.class)
              .invoke(beanFactory, (attributes) -> bean.repository = attributes.get(0));
                  return bean;
                }).register(beanFactory);
          }
        }
