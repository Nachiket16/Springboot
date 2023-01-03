###  Cascading
* Cascade = CascadeType.ALL   
* This will avoid unsaved transient instances
* eg-> if we want to save course material without saving course this error will be shown to avoid this we will use Cascade

### Fetch Type
How you want to fetch the data from the table DB.   
You have relation between two table and while fetching the data from the database do you want to fetch the data of single table or the related table as well.

#### Types
* Eager Fetch -> Bring both the table
* Lazy Fetch -> only fetch the single table unless you specifically told