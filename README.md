# Packages:
    in.ineuron.controller  ------- Interface between View and Service.
    in.ineuron.service   -------- Interface between Controller and Dao.
    in.ineuron.dao  ------ Database Communication
    in.ineuron.dto  ------ Data Transfer Object(Student)
    in.ineuron.main  -------- Provides view to the User.
    in.ineuron.util  -------- Provides Connection to Database(Class.forName("com.mysql.cj.jdbc.driver"))
    in.ineuron.factory  ------ Factory Methods
    in.ineuron.properties  ----- DB detais(url, user, password)


# Interface and its Implimented classes:

    in.ineuron.controller.IStudentController  -----------> in.ineuron.controller.StudentControllerImpl
    in.ineuron.service.IStudentService  -----------> in.ineuron.service.StudentServiceImpl
    in.ineuron.dao.IStudentDao  -----------> in.ineuron.dao.StudentDaoImpl

    
# Factory:
    This package is used to manage the Object Creation Using private constructors and static getters also called as factory methods.

# Database Used  ----- MySql :
    database name - crudappdb
    table name - student

# First Commit :
        physical connection for jdbc was used.

# Second Commit:
        HikariCp logical connection pooling mechanism is use.
