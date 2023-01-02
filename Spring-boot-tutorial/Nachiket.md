# Notes 

@SpringBootTest 
-> For the service layer we will use this annotation for the testing

@DataJpaTest
-> Data will be persisted into the database but after the run data will be flushed from the DB.

@WebMvcTest(DepartmentController.class)
->We have 2 end point for controller
we will use WebMvcTest annotation for it :
service layer -> Repository

* @RequestMapping(value = "/", method = RequestMethod.GET) == @GetMapping("/")

Both are Equal
