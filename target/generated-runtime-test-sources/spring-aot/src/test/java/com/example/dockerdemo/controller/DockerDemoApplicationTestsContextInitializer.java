package com.example.dockerdemo.controller;

import com.example.dockerdemo.service.IStudentService;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class DockerDemoApplicationTestsContextInitializer {
  public static void registerStudentController(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("studentController", StudentController.class)
        .instanceSupplier((instanceContext) -> {
          StudentController bean = new StudentController();
          instanceContext.field("studentService", IStudentService.class)
              .invoke(beanFactory, (attributes) -> bean.studentService = attributes.get(0));
                  return bean;
                }).register(beanFactory);
          }
        }
