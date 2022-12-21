>1 @SpringBootApplication
> >@EnableAutoConfiguration+@ComponentScan+@Configuration
>* This is Equivalent to 3 annotation
>
>@EnableAutoConfiguration
>> This Help spring-boot-starter-web for autoconfiguration
> Not Need for manual configuration
> 
>@ComponentScan
>> Scan Component scanning
> Scan all packages and sub-packages 
> for the spring bean
> 
>@Configuration
>> Class will be configuration class for the bean 
> creation
 
>2 @Configuration
>
>This will make class as source of Bean definition.
> SPRING CONTAINER will manage the Bean

>@Bean
> >applied on a method to specify that it returns a bean to be managed by Spring context. Spring Bean 
> annotation is usually declared in Configuration classes methods. In this case, bean methods may
> reference other @Bean methods in the same class by calling them directly.


>3 @Autowired
>>by declaring all the bean dependencies in a Spring configuration file, Spring container can autowire
> relationships between collaborating beans


>4 @Component
> * @Controller (Component, MVC Controller)
> * @Service    (Business Logic)
> * @Repository (Dao Layer, Data Access Object)
> These are sub-type / specialize annotation
>
> By using @Component spring will manage the object. 
> No need for the config and bean annotation.
>>@ComponentScan(basePackages = {"mypack"})
>This will scan the packages and create the object

>5 @Qualifier
>
> @Qualifier(("Student 2")) = specify name
> 
> This annotation is used for when there are 
> multiple beans available, and we want to 
> customize or call specific object using an 
> Autowired we use @Qualifier

>6 @LAZY
>>When we put @Lazy annotation over the 
> @Configuration class, 
> it indicates that all the methods with 
> @Bean annotation should be loaded lazily.
> 
> In Short only @Qualifier will be created.

>@ResponseBody
>>@ResponseBody annotation tells a controller that 
the object returned is automatically serialized
into JSON and passed back into the HttpResponse 
object.

>@RequestBody
>>the @RequestBody annotation maps the HttpRequest
> body to a transfer or domain object, enabling 
> automatic deserialization of the inbound 
> HttpRequest body onto a Java object.


>@RestController = @Controller + @ResponseBody

>@PathVariable
> 
> the @PathVariable annotation can be used to
> handle template variables in the request URI 
> mapping, and set them as method parameters.