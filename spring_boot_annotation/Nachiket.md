1 @SpringBootApplication
> >@EnableAutoConfiguration+@ComponentScan+@Configuration
* This is Equivalent to 3 annotation
>@EnableAutoConfiguration
>> This Help spring-boot-starter-web for autoconfiguration
> Not Need for manual configuration

>@ComponentScan
>> Scan Component scanning
> Scan all packages and sub-packages 
> for the spring bean

>@Configuration
>> Class will be configuration class for the bean 
> creation
 
2 @Configuration

>This will make class as source of Bean definition.
> SPRING CONTAINER will manage the Bean

>@Bean
> >applied on a method to specify that it returns a bean to be managed by Spring context. Spring Bean annotation is usually declared in Configuration classes methods. In this case, bean methods may reference other @Bean methods in the same class by calling them directly.






