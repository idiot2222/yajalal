package me.bogeun;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@TestConfiguration
// 얘는 @Component 붙은 애들 찾아서 빈으로 등록하는 애
@ComponentScan(basePackages = "me.bogeun")
// 컴포넌트 스캔 끝나고 spring.factories 내부의 여러 Configuration을 보고
// 프로젝트에 드간 의존성을 보고 해당되는 설정을 자동으로 사용하여 빈을 등록시켜주는 애
// 내 같은 경우는 HibernateJpaAutoConfiguration 얘 때문에 이거 썼는데, 얘만 따로 할 수 있는 방법은 없나
@EnableAutoConfiguration
@PropertySource("classpath:application-jpa-test.properties")
public class TestConfig {
}
