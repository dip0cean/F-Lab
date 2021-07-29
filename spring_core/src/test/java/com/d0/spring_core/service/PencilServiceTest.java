package com.d0.spring_core.service;

import com.d0.spring_core.entity.Pencil;
import com.d0.spring_core.repository.PencilRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PencilServiceTest {

    @Test
    public void test() {
        // BeanFactory 하위 구현체, IoC 컨테이너를 위임 받고 다양한 기능들을 제공한다.
        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("application.xml");
        // Spring Bean 으로 등록된 객체의 이름 확인
        String[]           beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));

        // IoC 컨테이너에 존재하는 Spring Bean 객체를 꺼내온다.
        PencilRepository pencilRepository = (PencilRepository) applicationContext.getBean(beanDefinitionNames[1], PencilRepository.class);
        PencilService    pencilService    = (PencilService) applicationContext.getBean(beanDefinitionNames[0], PencilService.class);

        // 객체 존재하는지 검증
        assertThat(pencilRepository).isNotNull();
        assertThat(pencilService).isNotNull();

        // Service UnitTest
        Pencil pencil = new Pencil();
        pencil.setVendor("모나미");

        Pencil result = pencilService.create(pencil);
        assertThat(result).isNotNull();

        /*
            그런데 이렇게 되면 Service 객체만의 UnitTest 가 아니라 다양한 관심사가 하나의 메소드에 존재하게 되는데,
            이렇게 단일 책임 원칙에 어긋나는 경우 어떻게 해결 할 수 있을까?
         */
    }
}
