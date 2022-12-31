# Condition Execution
> @EnabledOnOs(OS.LINUX)
> 
> @EnabledOnJre(JRE.JAVA_11)
> 
> @EnabledIf
> 
> @EnabledIfSystemProperty
> 
> @EnabledIfEnvironmentVariable

# Handling External Factors

>### assumethat
> >same structure as assert.
> 
> eg: assumeTrue(value)
>

# Assert

>This contains many predefined methods
> 
> * assertEquals(a,b,"message");
> * assertAll()
> * assertThrow()

### assertAll()
>@Test   
>@DisplayName("Multiply method test")   
>void testMultiply(){   
>assertAll(   
>() -> assertEquals(4, mathUtils.multiply(2,2)),  
>() -> assertEquals(0, mathUtils.multiply(0, 123)),  
>() -> assertEquals(-1, mathUtils.multiply(-1, 1))  
>);  
>}

### @Nested
It's used for nesting multiple test 